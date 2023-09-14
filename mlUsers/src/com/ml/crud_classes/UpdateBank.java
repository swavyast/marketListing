package com.ml.crud_classes;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ml.users.Account;
import com.ml.users.Bank;
import com.ml.users.DatabaseConfiguration;
import com.ml.users.User;
import com.ml.users.Vendor;

public class UpdateBank {

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
			
			Bank bank=session.load(Bank.class, 1);
			
			/*
			 * System.out.println("Bank Name : "+bank.getBankName()+"Branch Name : "+bank.
			 * getBranch()
			 * +"Branch Address : "+bank.getBranchAddress()+"\n Bank Users"+bank.getUsers()
			 * +"\n Accounts"+bank.getAccount());
			 */
			Set<Account> accounts=new HashSet<Account>();
			accounts=bank.getAccount();
			accounts.add(session.load(Account.class, 1));
			//session.save(accounts);
			Set<User> users=new HashSet<User>();
			users=bank.getUsers();
			users.add(session.load(Vendor.class, 1L));

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
