package com.ManyToManyMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class LoadManager {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernateMTM.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Vehicle vehicle = (Vehicle) session.load(Vehicle.class, 13);
		System.out.println(vehicle);
		System.out.println("================");
		System.out.println(vehicle.getUser());
		session.getTransaction().commit();
		session.close();
	}
}
