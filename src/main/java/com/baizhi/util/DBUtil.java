package com.baizhi.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	private static SqlSessionFactory factory=null;
	
	static{
		try{
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			factory=builder.build(reader);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static final ThreadLocal<SqlSession> tol=new ThreadLocal<>();
	
	public static SqlSession openSession(){
		SqlSession session=tol.get();
		if(session==null){
			session=factory.openSession();
			tol.set(session);
		}
		return session;
	}
	public static void close(SqlSession session){
		if(session!=null)try{session.close();tol.remove();}catch(Exception e){}
	}
	
	//�߼�����
	public static Object getDao(Class a){
		SqlSession session=openSession();
		Object obj=session.getMapper(a);
		return obj;
	}
	public static void close(){
		SqlSession session=openSession();
		if(session!=null)try{session.close();tol.remove();}catch(Exception e){}
	}
	public static void commit(){
		SqlSession session=openSession();
		session.commit();
		close();
	}
	public static void rollback(){
		SqlSession session=openSession();
		session.rollback();
		close();
	}
}
