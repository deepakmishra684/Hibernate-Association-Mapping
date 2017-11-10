package com.OneToManyMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class OneToManyTestDemo {
	public static void main(String[] args) {
		UserDetails user = new UserDetails();

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("BMW Car");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Audi Car");

		user.setUserName("Deepak Mishra");

		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle1);

		vehicle.setUser(user);
		vehicle1.setUser(user);

		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernateOTM.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(vehicle);
		session.save(vehicle1);
		session.save(user);

		session.getTransaction().commit();
		session.close();
	}
}
