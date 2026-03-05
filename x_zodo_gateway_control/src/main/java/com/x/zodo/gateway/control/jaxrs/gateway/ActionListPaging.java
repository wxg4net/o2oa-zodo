package com.x.zodo.gateway.control.jaxrs.gateway;

import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.zodo.gateway.control.jaxrs.BaseAction;
import com.x.zodo.gateway.entity.ZodoGatewayLog;
import com.x.zodo.gateway.entity.ZodoGatewayLog_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * 分页查询
 * @author sword
 */
public class ActionListPaging extends BaseAction {

	ActionResult<List<Wo>> execute(EffectivePerson effectivePerson, Integer page, Integer size) throws Exception {
		try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
			ActionResult<List<Wo>> result = new ActionResult<>();
			EntityManager em = emc.get(ZodoGatewayLog.class);
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ZodoGatewayLog> cq = cb.createQuery(ZodoGatewayLog.class);
			Predicate p = cb.conjunction();
			Root<ZodoGatewayLog> root = cq.from(ZodoGatewayLog.class);
			p = cb.and(p, cb.equal(root.get(ZodoGatewayLog_.category), "pass"));
			List<Wo> wos = emc.fetchDescPaging(ZodoGatewayLog.class, Wo.copier, p, page, size, ZodoGatewayLog.sequence_FIELDNAME);
			result.setData(wos);
			result.setCount(emc.count(ZodoGatewayLog.class, p));
			return result;
		}
	}

	public static class Wo extends ZodoGatewayLog {

		private static final long serialVersionUID = -4635222902589827154L;

		static final WrapCopier<ZodoGatewayLog, Wo> copier = WrapCopierFactory.wo(ZodoGatewayLog.class, Wo.class,
				JpaObject.singularAttributeField(ZodoGatewayLog.class, true, true), null);

	}
}
