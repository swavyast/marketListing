package com.ml.crud_classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.users.Address;
import com.ml.users.Administrator;
import com.ml.users.DatabaseConfiguration;

public class CreateAdmin {

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
			Administrator admin=new Administrator();
			
			admin.setUsername("delphic");
			admin.setPassword("XyzIsNothing@all");
			admin.setName("Himanshu Rai");
			admin.setEmail("savyast@gmail.com");
			admin.setContact("7275855535");
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
			admin.setDbId("system");
			admin.setDbPwd("68921794");
			admin.setAddress(himAdd);
			//System.out.println(admin.getAddress());
			System.out.println("User Object Created");
			session.save(admin);
			System.out.println("admin's Data has been Saved");
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
