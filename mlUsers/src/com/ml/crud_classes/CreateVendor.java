package com.ml.crud_classes;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.ml.users.Account;
import com.ml.users.Address;
import com.ml.users.Bank;
import com.ml.users.DatabaseConfiguration;
import com.ml.users.User;
import com.ml.users.Vendor;

public class CreateVendor {

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
			
			Vendor vendor=new Vendor();
			System.out.println("Plain Vendor Object Created ---- Data being injected");
			/*
			 * List<Location> vLoc=new ArrayList<Location>();
			 * vLoc.add(Location.defaultLocation());
			 * 
			 * session.save(vLoc);
			 */
			
			vendor.setUsername("krishnacom");
			vendor.setPassword("KrishnaCommunication");
			vendor.setName("Krishna Comm. Pvt. Ltd.");
			vendor.setEmail("kcOfficial@gmail.com");
			vendor.setContact("7275855535");
			
			//Address Object Creation
			Address kcAdd=new Address();
			System.out.println("plain address object creadted");
			kcAdd.setHouseNumber("4/42");
			kcAdd.setLocality("Krishna Nagar");
			kcAdd.setPostOffice("Krishna Nagar");
			kcAdd.setPoliceStation("Krishna Nagar");
			kcAdd.setCity("Lucknow");
			kcAdd.setState("Uttar Pradesh");
			kcAdd.setCountry("India");
			kcAdd.setPincode(226023);
			kcAdd.setZipcode(0);
			System.out.println("address data injected completely");
			session.save(kcAdd);
			vendor.setAddress(kcAdd);
			System.out.println("Venor's user properties have been injected - vendor properties being injected now");

			vendor.setGstn("XYZ123@#6789");
			vendor.setPan("BPVPR6083G");
			vendor.setVoterId("xyz12300");
			vendor.setAadhaar(644856923476L);
			System.out.println("basic vendor properties have been injected - account details only remaining");
			//Account Creation

			Account a1=new Account();
			System.out.println("plain account object created");
			
			a1.setBankName("Bank of India");
			a1.setBranch("Krishna Nagar");
			a1.setBranchAddress(kcAdd);
			System.out.println("DummyUsers set is being injected");
			a1.setUsers(null);
			System.out.println("DummyAccounts set is being injected");
			a1.setAccount(null);
			System.out.println("Bank's properties have been injected- accounts properties only remain");
			
			a1.setAcNo(123456789012L);
			a1.setBal(0);
			a1.setCredit(100);
			a1.setDebit(100);
			a1.setRemarks("Settled");
			session.save(a1);
			System.out.println("Accounts data has been saved");
			vendor.setAcNo(null);
			session.save(vendor);
			
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


/*
 * Bank b1=new Bank(); System.out.println("plain bank object created");
 * Set<User> users=new HashSet<User>(); b1.setName("Bank Of India");
 * b1.setBranch("Krishna Nagar"); b1.setBranchAddress(kcAdd); b1.setAccount(sa);
 * // a1 is null here b1.setUsers(users); //users is null here
 * System.out.println("basic bank properties have been injected");
 * //b1.setBranchLoc(Location.defaultLocation());
 * 			vendor.setAcNo(accounts);
			System.out.println("Vendors set of accounts have been injected");
						//vendor.setRegion(vLoc);
			
			//Catalogue creation
			//Catalogue cat=new Catalogue();
			//cat.setCatName("MyProducts");
			//cat.setVendor(vendor);
			/*			//Upating details
			accounts.add(a1);
			System.out.println("Account added to account set - Account set being saved");
			session.save(accounts);
			System.out.println("Saved");
			
			users.add(vendor);
			session.save(users);
			
			
			session.save(vendor);
			
			System.out.println("set of accounts is ready for vendor's object");
			
			System.out.println("Vendor's Data has been Saved - Update Queries To Be Injected");

			Bank b2=session.load(Bank.class, 1);
			b2.setAccount(accounts);
			b2.setUsers(users);	
			 * Product p=new Product(); p.setProName("Mango"); p.setProColor("Yellow");
			 * Unit.kilogram.put("Kg", null); p.setUnit(Unit.kilogram.keySet().toString());
			 * p.setPpu(5.0); p.setBookings(1000000); p.setProCount(10000);
			 * p.setProDesc("Malihabadi Dussehari"); p.setProPicture(null);
			 * p.setReturned(0); p.setSold(100000000);
			 */
			//List<Product> products=Arrays.asList(p);
		//	cat.setMyProducts(products);
			//session.save(p);
			//session.save(cat);
		//	vendor.setCat(cat);

			//System.out.println("Vendor Object Created");