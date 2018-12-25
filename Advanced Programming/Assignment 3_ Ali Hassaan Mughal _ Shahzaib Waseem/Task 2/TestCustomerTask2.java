package org.hibernate.task2;
//Task 2
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestCustomerTask2 {
public static void main(String[] args)
{
	System.out.println("Adding Two new Customers\n\n\n\n");
	//Create New Student;
	Customer first = new Customer();
	Customer second=  new Customer();
	first.getCustomerDetail().setCreditScore(15000);
	first.getCustomerDetail().setCustomerAddress("House 166-B, Islamabad");
	first.setCustomerName("Ali Hassan");
	first.getCustomerDetail().setRewardPoints(2000);
	second.getCustomerDetail().setCreditScore(1700);
	second.setCustomerName("Muhammad");
	second.getCustomerDetail().setRewardPoints(200);
	second.getCustomerDetail().setCustomerAddress("House 150, Lahore");
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(first);
	session.save(second);
	session.getTransaction().commit();
	
	//Update a Record From Table
	System.out.println("Update a Record From Table with id = 1\n\n\n");
		Query query = session.createQuery("from Customer where id=\'1\'");
		List<Customer> list=query.list();  
		Iterator<Customer> itr=list.iterator();  
		if(itr.hasNext()){  
			Customer cust=itr.next();  
			System.out.println("Old Customer: "+cust.toString());
			session.beginTransaction();
			cust.getCustomerDetail().setRewardPoints(800);
			session.save(cust);
			session.getTransaction().commit();
			System.out.println("New Student: "+cust.toString());
			
		}
	//Printing All Records From Table
	System.out.println("Printing All Records From Table\n\n\n");
	query = session.createQuery("from Customer");
	list=query.list();  
	itr=list.iterator();  
	while(itr.hasNext()){  
		Customer emp=itr.next();  
		System.out.println(emp.toString());  
	} 
	//Delete a Record From Table
	System.out.println("Deleting a Record with Reg id : 2\n\n\n");
			query = session.createQuery("from Customer where id=\'2\'");
			list=query.list();  
			itr=list.iterator();  
			if(itr.hasNext()){  
				Customer emp=itr.next();  
				session.beginTransaction();
				session.delete(emp);
				session.getTransaction().commit();
			}
	
}

}
