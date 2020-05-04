package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .buildSessionFactory();
	
		//create session
		
		Session session = factory.getCurrentSession();
		
		try {

			//start a transaction
			session.beginTransaction();
			
		     //get the instructor from db
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			
			System.out.println("Code: Instructor: "+tempInstructor);
			
			
			System.out.println("Code: Courses: "+tempInstructor.getCourses());
			
	
			
			//commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			System.out.println("Code: The session is now closed!\n");
			
			
			//since courses are lazy loaded.. this should fail
			
			
			//get course for the instructor
			System.out.println("Code: Courses: "+tempInstructor.getCourses());
			
			
			System.out.println("Code: Done!");
			
			
		}
        finally {
        	//add clean up code
        	session.close();
        	factory.close();
        	
        }
	}

}
