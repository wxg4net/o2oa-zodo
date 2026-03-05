package com.x.zodo.gateway.control.jaxrs.gateway;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonElement;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.entity.dataitem.DataItemConverter;
import com.x.base.core.entity.dataitem.ItemCategory;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.gson.XGsonBuilder;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;

import com.x.base.core.project.x_processplatform_assemble_surface;
import com.x.query.core.entity.Item;
import com.x.query.core.entity.Item_;
import com.x.zodo.gateway.control.ThisApplication;
import com.x.zodo.gateway.control.factory.JobItemFactory;
import com.x.zodo.gateway.control.jaxrs.BaseAction;
import com.x.zodo.gateway.entity.ZodoGatewayLog;
import com.x.zodo.gateway.entity.ZodoPassportBlack;
import com.x.zodo.gateway.entity.ZodoPassportBlack_;

/**
 * 根据出入证ID查询详细信息
 * @author sword
 */
public class ActionGetPass extends BaseAction {

	private Logger logger = LoggerFactory.getLogger( ActionGetPass.class );

	protected ActionResult<JsonElement> execute( HttpServletRequest request, EffectivePerson effectivePerson, String job ) throws Exception {

		ActionResult<JsonElement> result = new ActionResult<>();

		try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {

//			WorkCompleted workCompleted = emc.find(job, WorkCompleted.class);
//			if (null == workCompleted) {
//				throw new ExceptionEntityNotExist(job, WorkCompleted.class);
//			}

			Wo blackPass =  this.checkPassportBlack(job);
			if (blackPass != null) {
				throw new ExceptionZodoPassportBlackExists(job);
			}

			EntityManager em = emc.get(Item.class);
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Item> cq = cb.createQuery(Item.class);
			Root<Item> root = cq.from(Item.class);
			Predicate p = cb.equal(root.get(Item_.bundle), job);
			p = cb.and(p, cb.equal(root.get(Item_.itemCategory), ItemCategory.pp));
			cq.select(root).where(p);
			List<Item> list = em.createQuery(cq).getResultList();
			DataItemConverter<Item> converter = new DataItemConverter<>(Item.class);
			result.setData(converter.assemble(list, 0));
			JsonElement jobData = converter.assemble(list, 0);

			JobItemFactory jobDataFactory = XGsonBuilder.convert(jobData, JobItemFactory.class);
			Integer hitTimes = jobDataFactory.getHitTimes();
			jobDataFactory.setHitTimes(hitTimes+1);
			ThisApplication.context().applications().
					putQuery(x_processplatform_assemble_surface.class,
							"data/job/" + job, jobDataFactory);
			return result;
		}
	}

	protected Wo checkPassportBlack(String job) throws Exception {
		try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
			ActionResult<Wo> result = new ActionResult<>();
			EntityManager em = emc.get(ZodoPassportBlack.class);
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ZodoPassportBlack> cq = cb.createQuery(ZodoPassportBlack.class);
			Predicate p = cb.conjunction();
			Root<ZodoPassportBlack> root = cq.from(ZodoPassportBlack.class);
			p = cb.and(p, cb.equal(root.get(ZodoPassportBlack_.jobId), job));
			cq.select(root).where(p);
			List<ZodoPassportBlack> list = em.createQuery(cq).setMaxResults(1).getResultList();
			if (list.isEmpty() ) {
				return null;
			}
			ZodoPassportBlack entity  = list.get(0);
            return Wo.copier.copy(entity);
		}
	}


	public static class Wo extends ZodoPassportBlack {

		private static final long serialVersionUID = -20250620123456L;

		static final WrapCopier<ZodoPassportBlack, Wo> copier = WrapCopierFactory.wo(ZodoPassportBlack.class, Wo.class,
				JpaObject.singularAttributeField(ZodoGatewayLog.class, true, true), null);

	}



}
