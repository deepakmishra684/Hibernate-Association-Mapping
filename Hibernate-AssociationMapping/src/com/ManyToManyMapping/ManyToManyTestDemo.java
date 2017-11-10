package com.ManyToManyMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ManyToManyTestDemo {
	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		UserDetails user2 = new UserDetails();

		user1.setUserName("First User");
		user2.setUserName("Second User");

		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();

		vehicle1.setVehicleName("Car");
		vehicle2.setVehicleName("Jeep");

		vehicle1.getUser().add(user1);
		vehicle1.getUser().add(user2);

		vehicle2.getUser().add(user2);
		vehicle2.getUser().add(user1);

		user1.getVehicle().add(vehicle1);
		user2.getVehicle().add(vehicle1);

		user1.getVehicle().add(vehicle2);
		user2.getVehicle().add(vehicle2);

		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernateMTM.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
	}
}
