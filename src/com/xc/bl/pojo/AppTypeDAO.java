package com.xc.bl.pojo;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * AppType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.xc.bl.pojo.AppType
 * @author MyEclipse Persistence Tools
 */
public class AppTypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AppTypeDAO.class);
	// property constants
	public static final String APP_TYPE_NAME = "appTypeName";
	public static final String DB_DELETE = "dbDelete";

	public void save(AppType transientInstance) {
		log.debug("saving AppType instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AppType persistentInstance) {
		log.debug("deleting AppType instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AppType findById(java.lang.Integer id) {
		log.debug("getting AppType instance with id: " + id);
		try {
			AppType instance = (AppType) getSession().get(
					"com.xc.bl.pojo.AppType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AppType instance) {
		log.debug("finding AppType instance by example");
		try {
			List results = getSession()
					.createCriteria("com.xc.bl.pojo.AppType")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AppType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AppType as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAppTypeName(Object appTypeName) {
		return findByProperty(APP_TYPE_NAME, appTypeName);
	}

	public List findByDbDelete(Object dbDelete) {
		return findByProperty(DB_DELETE, dbDelete);
	}

	public List findAll() {
		log.debug("finding all AppType instances");
		try {
			String queryString = "from AppType";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AppType merge(AppType detachedInstance) {
		log.debug("merging AppType instance");
		try {
			AppType result = (AppType) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AppType instance) {
		log.debug("attaching dirty AppType instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AppType instance) {
		log.debug("attaching clean AppType instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}