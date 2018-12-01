package package_java_test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateInitClass {

	private static final ThreadLocal<Session> threadlocal= new ThreadLocal<Session>();
	private static SessionFactory sessionFactory= null;
	static {
		try {
			Configuration configuration=new Configuration().configure();//加载hibernate的配置文件
			sessionFactory=configuration.buildSessionFactory(new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("创建会话工厂失败");
			e.printStackTrace();
		}
	}

	public static Session getSession() throws HibernateException{
		Session session=(Session)threadlocal.get();
		if (session==null||!session.isOpen()) {
			if (sessionFactory==null) {
				rebuildSessionFactory();
			}
			session=(sessionFactory!=null)?sessionFactory.openSession():null;
			threadlocal.set(session);
		}
		return session;
	}

	public static void rebuildSessionFactory() {
		try {
			Configuration configuration=new Configuration().configure();
			sessionFactory=configuration.buildSessionFactory(new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("创建会话工厂失败");
			e.printStackTrace();
		}
	}

	public static void closeSession() throws HibernateException{
		Session session=(Session)threadlocal.get();
		threadlocal.set(null);
		if (session!=null) {
			session.close();	
		}
	}







}
