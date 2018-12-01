package package_java_test;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserManage {
	Session session=null;
	UserInfo userInfo=null;
	public UserInfo getUser(int studentID) {
		
		try {
			session=HibernateInitClass.getSession();
			session.beginTransaction();
			String HQl="from UserInfo as u where u.userName=?";
			Query query=session.createQuery(HQl).setParameter(0, studentID);
			userInfo=(UserInfo)query.uniqueResult();
			session.getTransaction().commit();
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			session.beginTransaction().rollback();
			
			
		}finally {
			
			HibernateInitClass.closeSession();
			
		}
		return userInfo;
		
	}

	public UserInfo update(UserInfo userInfo) {
		try {
			
			session=HibernateInitClass.getSession();
			session.beginTransaction();
			session.saveOrUpdate(userInfo);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			session.beginTransaction().rollback();
		}finally {
			HibernateInitClass.closeSession();
			
		}
		return userInfo;
		
		
		
	}
	
	public UserInfo add(UserInfo userInfo) {
		try {
			
			session=HibernateInitClass.getSession();
			session.beginTransaction();
			session.save(userInfo);
			session.getTransaction().commit();
			
			
			
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			session.beginTransaction().rollback();
			
		}finally {
			HibernateInitClass.closeSession();
			
		}
		
		
		
		return userInfo;
		
	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> getallUser() {
		List<UserInfo> list=null;
		try {
			session=HibernateInitClass.getSession();
			session.beginTransaction();
			Query query=session.createQuery("from UserInfo");
			 list=query.list();
			session.getTransaction().commit();
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			session.beginTransaction().rollback();
		}finally {
			HibernateInitClass.closeSession();
			
		}
		return list;
		
		
	}

	public void delete(String studentID) {
		try {
			session=HibernateInitClass.getSession();
			session.beginTransaction();
			String HQL="delete UserInfo as u where u.studentID=?";
			Query query=session.createQuery(HQL).setInteger(0, Integer.parseInt(studentID));
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			session.beginTransaction().rollback();
		}finally {
			HibernateInitClass.closeSession();
		}
	}

}
