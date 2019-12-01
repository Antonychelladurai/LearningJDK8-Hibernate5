package com.anto.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Sessionfactory {
	
	Configuration config = new Configuration();

	Genmetadata gm=new Genmetadata();
	Session sess; 
	Session getsession(){
		if (sess==null) {
		sess=gm.getMetaData().openSession();
		}
		return sess;
		
	}
	
	public void productInsert(DBProduct genproduct) {
		
		DBProduct temp=genproduct;
		// TODO Auto-generated method stub
		try {
		
		Transaction tran;
		
		sess=getsession();
		tran=sess.beginTransaction();
		sess.save(temp);
		tran.commit();
		//sess.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
