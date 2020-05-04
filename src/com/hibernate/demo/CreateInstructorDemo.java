package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			
            
			
            Instructor tempInstructor = new Instructor("Susan","Public","susan@code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.code.com/youtube","Video Games");
			
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
		
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			
			//
			
			//Note: this will also save the details object
			
			//because of CascadeType.All
			
			//
			
			System.out.println("Saving Instructor: "+ tempInstructor);
			session.save(tempInstructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
        finally {
        	//add clean up code
        	session.close();
        	factory.close();
        	
        }
	}

}
