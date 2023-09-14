package com.ml.read;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.users.Bank;
import com.ml.users.DatabaseConfiguration;

public class ReadBank {

	public static void main(String[] args) {
		Transaction tx=null;
		try {
			SessionFactory sf=DatabaseConfiguration.getSessionFactory();
			System.out.println("Session Created");
			System.out.println(sf.equals(null)+" Session Factory is created if it prints false");
			Session session=sf.openSession();
			System.out.println("Session open");
			tx=session.beginTransaction();
			System.out.println("Transaction Begin");
			
			Bank bank=session.load(Bank.class, 14);
			System.out.println(bank.getBankName());
			System.out.println(bank.getBranch());
			System.out.println(bank.getBranchAddress());
			System.out.println(bank.getAccount());
			System.out.println(bank.getUsers());
			
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
