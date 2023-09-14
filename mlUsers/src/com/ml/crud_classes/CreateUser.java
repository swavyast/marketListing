package com.ml.crud_classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.users.Address;
import com.ml.users.DatabaseConfiguration;
import com.ml.users.User;

public class CreateUser {

	public static void main(String[] args) {
		Transaction tx=null;
		try {
			SessionFactory sf=DatabaseConfiguration.getSessionFactory();
			System.out.println("Session Created");
			System.out.println(sf.equals(null));
			Session session=sf.openSession();
			System.out.println("Session open");
			tx=session.beginTransaction();
			System.out.println("Transaction Begin");
			User himanshu=new User();
			
			himanshu.setUsername("delphic");
			himanshu.setPassword("XyzIsNothing@all");
			himanshu.setName("Himanshu Rai");
			himanshu.setEmail("savyast@gmail.com");
			himanshu.setContact("7275855535");
			Address himAdd=new Address();
			himAdd.setHouseNumber("4/42");
			himAdd.setLocality("Krishna Nagar");
			himAdd.setPostOffice("Krishna Nagar");
			himAdd.setPoliceStation("Krishna Nagar");
			himAdd.setCity("Lucknow");
			himAdd.setState("Uttar Pradesh");
			himAdd.setCountry("India");
			himAdd.setPincode(226023);
			himAdd.setZipcode(0);
			session.save(himAdd);
			himanshu.setAddress(himAdd);
			//System.out.println(himanshu.getAddress());
			System.out.println("User Object Created");
			session.save(himanshu);
			System.out.println("Himanshu's Data has been Saved");
			tx.commit();
			System.out.println("Transaction Committed");
			session.close();
			System.out.println("Session Closed");
			sf.close();
			System.out.println("Session Factory Closed");
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

}
