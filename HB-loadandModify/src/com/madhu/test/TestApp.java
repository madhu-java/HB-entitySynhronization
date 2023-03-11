package com.madhu.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.madhu.model.Student;
import com.madhu.util.HibernateUtil;

public class TestApp {
//to reflect the changes from DB to object 
	public static void main(String[] args) {
Session session =null;
Transaction transaction =null;
Integer id =16;
try {
	session = HibernateUtil.getSession();
	if(session!=null) {
		
		Student student = session.get(Student.class, id);
		System.out.println("before updaton in the table:"+student);
		if(student!=null) {
			System.in.read();
			// go to DB and make changes
			session.refresh(student);
			System.out.println("after updaton in the table:"+student);
			
	}else
		System.out.println("record not available at given id:"+id);
	}
}catch(HibernateException e) {
	e.printStackTrace();
}catch(Exception e) {
	e.printStackTrace();
}finally {
//	HibernateUtil.closeSession(session);
//	HibernateUtil.closeSessionFactory();
}
		
	}

}
