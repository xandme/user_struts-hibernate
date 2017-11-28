package com.qingshixun.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.project.model.UserModel;

@Repository
public class UserDao {

	SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<UserModel> findUser() {
		return (List<UserModel>) sessionFactory.getCurrentSession().createQuery("from UserModel");
	}

	@SuppressWarnings("unchecked")
	public List<UserModel> selectPage(int pageNow, int pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery("from UserModel");
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<UserModel> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public int selectTotalSize() {
		String hql = "select count(*) from UserModel";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Long> list = query.list();
		int totalSize = list.get(0).intValue();
		System.out.println("数据行数：" + totalSize);
		return totalSize;
	}

	public void deleteUser(UserModel userModel) {
		String hql = "delete from UserModel us where us.id=:iidd";
		sessionFactory.getCurrentSession().createQuery(hql).setParameter("iidd", userModel.getId()).executeUpdate();
	}

	public void addUser(UserModel userModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(userModel);
	}

	@SuppressWarnings("unchecked")
	public List<UserModel> findName(int pageNow, int pageSize, String nameKey) {
		String hql = "from UserModel um where um.name like:key";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("key", "%" + nameKey + "%");
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<UserModel> list = query.list();
		System.out.println(list.toString());
		return list;
	}

	public List getUserGenderNumber() {
		// 根据gender分组统计用户性别人数
		String hql = "select count(*) as number,gender from UserModel group by gender";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List getUserCreateData() {
		// 根据createTime分组统计用户创建日期人数（利用MySQL提供的DATE_FORMAT函数对createTime进行格式化）
		String hql = "select count(*) as number,DATE_FORMAT(createDate,'%y-%m-%d') from UserModel group by DATE_FORMAT(createDate,'%y-%m-%d')";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public UserModel getUser(int id) {
		UserModel user=(UserModel) sessionFactory.getCurrentSession().get(UserModel.class, id);
		return user;
	}
}
