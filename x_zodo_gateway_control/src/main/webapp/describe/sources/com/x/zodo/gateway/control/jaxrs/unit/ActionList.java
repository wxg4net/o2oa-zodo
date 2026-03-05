package com.x.zodo.gateway.control.jaxrs.unit;

import com.google.gson.JsonElement;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.project.annotation.FieldDescribe;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.cache.Cache;
import com.x.base.core.project.cache.CacheManager;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.base.core.project.tools.ListTools;
import com.x.organization.core.entity.Identity;
import com.x.organization.core.entity.Unit;
import com.x.organization.core.entity.Unit_;
import com.x.zodo.gateway.control.Business;
import com.x.zodo.gateway.control.jaxrs.BaseAction;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;


public class ActionList extends BaseAction {

    private Logger logger = LoggerFactory.getLogger( ActionList.class );


    ActionResult<List<Wo>> execute(HttpServletRequest request) throws Exception {
        try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
            ActionResult<List<Wo>> result = new ActionResult<>();
            Business business = new Business(emc);
            Cache.CacheKey cacheKey = new Cache.CacheKey(this.getClass());
            Optional<?> optional = CacheManager.get(business.cache(), cacheKey);
            if (optional.isPresent()) {
                result.setData((List<Wo>) optional.get());
            } else {
                List<Wo> wos = this.list(business);
                CacheManager.put(business.cache(), cacheKey, wos);
                result.setData(wos);
            }
            return result;
        }
    }

    public static class Wo extends Unit {

        private static final long serialVersionUID = -125007357898871894L;

        @FieldDescribe("直接下级组织数量")
        private Long subDirectUnitCount = 0L;

        @FieldDescribe("是否为叶子节点")
        private Boolean leaf = false;
        @FieldDescribe("直接成员身份数量")
        private Long subDirectIdentityCount = 0L;

        static WrapCopier<Unit, Wo> copier = WrapCopierFactory.wo(Unit.class, Wo.class, null,
                ListTools.toList(JpaObject.FieldsInvisible, Unit.typeList_FIELDNAME, Unit.controllerList_FIELDNAME,
                        Unit.createTime_FIELDNAME, Unit.updateTime_FIELDNAME));

        public Long getSubDirectUnitCount() {
            return subDirectUnitCount;
        }

        public void setSubDirectUnitCount(Long subDirectUnitCount) {
            this.subDirectUnitCount = subDirectUnitCount;
        }

        public Long getSubDirectIdentityCount() {
            return subDirectIdentityCount;
        }

        public void setSubDirectIdentityCount(Long subDirectIdentityCount) {
            this.subDirectIdentityCount = subDirectIdentityCount;
        }

        public Boolean getLeaf() {
            return leaf;
        }

        public void setLeaf(Boolean leaf) {
            this.leaf = leaf;
        }
    }

    private List<Wo> list(Business business) throws Exception {
        EntityManager em = business.entityManagerContainer().get(Unit.class);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Unit> cq = cb.createQuery(Unit.class);
        Root<Unit> root = cq.from(Unit.class);
        Predicate p = cb.equal(root.get(Unit_.level), 1);
        List<Unit> os = em.createQuery(cq.select(root).where(p)).getResultList();
        List<Wo> wos = Wo.copier.copy(os);
        wos.stream().forEach(o -> {
            try {
                o.setSubDirectUnitCount(
                        business.entityManagerContainer().countEqual(Unit.class, Unit.superior_FIELDNAME, o.getId()));

                o.setLeaf(o.getSubDirectUnitCount() == 0);
//                o.setSubDirectIdentityCount(business.entityManagerContainer().countEqual(Identity.class,
//                        Identity.unit_FIELDNAME, o.getId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        wos = business.unit().sort(wos);
        return wos;
    }




}
