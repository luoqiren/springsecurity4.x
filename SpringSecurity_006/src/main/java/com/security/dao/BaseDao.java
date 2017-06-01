package com.security.dao;

import java.util.List;

import org.hibernate.Session;


public interface BaseDao {
	
	/*** gerCurrentSession 会自动关闭session，使用的是当前的session事务
	 * @return
	 */
	public Session getSession();
	
	/*** openSession 需要手动关闭session 意思是打开一个新的session
	 * @return
	 */
	public Session getNewSession();
	
	public void flush();
	
	public void clear();
	/*** 根据 id 查询信息
	 * @param id
	 * @return
	 */
	public Object load(Class<?> c, String id);
	/**获取所有信息
	 * @param c
	 * @return
	 */
	public List<?> getAllList(Class<?> c);//无条件
	/*** 获取总数量
	 * @param c
	 * @return
	 */
	public long getTotalCount(Class<?> c);//无条件
	/*** 保存
	 * @param bean
	 * @throws Exception 
	 */
	public void save(Object bean) throws Exception;
	/*** 更新
     * @param bean 
	 * @throws Exception 
     */
    public void update(Object bean) throws Exception;
    /** * 删除
     * @param bean 
     * @throws Exception 
     */
    public void delete(Object bean) throws Exception;
    /*** 根据ID删除
     * @param c 类
     * @param id ID
     */
    public void delete(Class<?> c, String id);
    /*** 批量删除
     * @param c 类
     * @param ids ID 集合 String类型
     */
    public void delete(Class<?> c, List<String> ids);
}
