package com.masai.Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EM_Util {

	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("OHASS");
	}
	
	public static EntityManager provideEntityManager() {
		EntityManager em = emf.createEntityManager();
		return em;
	}
}
