package com.x.zodo.mes.control;

import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.project.cache.Cache;
import com.x.base.core.project.cache.CacheManager;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractFactory {

	private Business business;

	protected Cache.CacheCategory cache;

	public AbstractFactory(Business business) throws Exception {
		try {
			if (null == business) {
				throw new Exception("business can not be null.");
			}
			this.business = business;
		} catch (Exception e) {
			throw new Exception("can not instantiating factory.");
		}
	}

	public EntityManagerContainer entityManagerContainer() throws Exception {
		return this.business.entityManagerContainer();
	}

	@SuppressWarnings("unchecked")
	protected <T extends JpaObject> T pick(String flag, Class<T> clz, String... attributes) throws Exception {
		if (StringUtils.isEmpty(flag)) {
			return null;
		}
		Cache.CacheCategory cacheCategory = new Cache.CacheCategory(clz);
		T t = null;
		Cache.CacheKey cacheKey = new Cache.CacheKey(flag);
		Optional<?> optional = CacheManager.get(cacheCategory, cacheKey);
		if (optional.isPresent()) {
			t = (T) optional.get();
		} else {
			t = this.entityManagerContainer().flag(flag, clz);
			if (t != null) {
				this.entityManagerContainer().get(clz).detach(t);
			}
			CacheManager.put(cacheCategory, cacheKey, t);
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	protected <T extends JpaObject> List<T> pick(List<String> flags, Class<T> clz) throws Exception {
		List<T> list = new ArrayList<>();
		if (null == flags || flags.isEmpty()) {
			return list;
		}
		Cache.CacheCategory cacheCategory = new Cache.CacheCategory(clz);
		boolean hasCache = true;
		for(String flag : flags){
			Cache.CacheKey cacheKey = new Cache.CacheKey(flag);
			Optional<?> optional = CacheManager.get(cacheCategory, cacheKey);
			if (optional.isPresent()) {
				list.add ((T) optional.get());
			}else{
				hasCache = false;
				break;
			}
		}
		if(hasCache){
			return list;
		} else {
			List<T> os = this.entityManagerContainer().flag(flags, clz);
			EntityManager em = this.entityManagerContainer().get(clz);
			os.stream().forEach(o -> {
				em.detach(o);
				list.add(o);
				Cache.CacheKey cacheKey = new Cache.CacheKey(o.getId());
				CacheManager.put(cacheCategory, cacheKey, o);
			});
		}
		return list;
	}

	public Business business() throws Exception {
		return this.business;
	}

}
