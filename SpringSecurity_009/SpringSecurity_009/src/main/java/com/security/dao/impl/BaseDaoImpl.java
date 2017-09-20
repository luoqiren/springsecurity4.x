package com.security.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.security.dao.BaseDao;


/**
 * @author lqr
 *
 */
public class BaseDaoImpl implements BaseDao {
	
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	public BaseDaoImpl() {
	}

	/**
	 * gerCurrentSession 会自动关闭session，使用的是当前的session事务
	 * 
	 * @return
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * openSession 需要手动关闭session 意思是打开一个新的session
	 * 
	 * @return
	 */
	public Session getNewSession() {
		return sessionFactory.openSession();
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	/**
	 * 根据 id 查询信息
	 * 
	 * @param id
	 * @return
	 */
	public Object load(Class<?> c, String id) {
		Session session = getSession();
		return session.get(c, id);
	}

	/**
	 * 获取所有信息
	 * 
	 * @param c
	 * @return
	 */
//	@SuppressWarnings({ "rawtypes" })
	public List<?> getAllList(Class<?> c) {
		String hql = "from " + c.getName();
		Session session = getSession();
		return session.createQuery(hql).list();
	}

	/**
	 * 获取总数量
	 * 
	 * @param c
	 * @return
	 */
//	@SuppressWarnings("rawtypes")
	public long getTotalCount(Class<?> c) {
		Session session = getSession();
		String hql = "select count(*) from " + c.getName();
		Long count = (Long) session.createQuery(hql).uniqueResult();
		return count != null ? count.longValue() : 0;
	}

	/**
	 * 保存
	 * @param bean
	 * @throws Exception 
	 */
	public void save(Object bean) throws Exception {
		Session session = getSession();
		System.out.println(session.save(bean));
		session.flush();
		session.clear();
	}
	
	/**
     * 更新
     * @param bean 
	 * @throws Exception 
     */
    public void update(Object bean) throws Exception {
        Session session = getSession();
		session.update(bean);
		session.flush();
		session.clear();
    }
    
    /**
     * 删除
     * @param bean 
     * @throws Exception 
     */
    public void delete(Object bean) throws Exception {
        Session session = getSession();
		session.delete(bean);
		session.flush();
		session.clear();
    }

    /**
     * 根据ID删除
     * @param c 类
     * @param id ID
     *            
     */
//    @SuppressWarnings({ "rawtypes" })
    public void delete(Class<?> c, String id) {
        Session session = getSession();
        Object obj = session.get(c, id);
        session.delete(obj);
        flush();
        clear();
    }
    
    /**
     * 批量删除
     * @param c 类
     * @param ids ID 集合 String类型
     */
//    @SuppressWarnings({ "rawtypes" })
    public void delete(Class<?> c, List<String> ids) {
        for (String id : ids) {
            Object obj = getSession().get(c, id);
            if (obj != null) {
                getSession().delete(obj);
            }
        }
    }
    
    
}
