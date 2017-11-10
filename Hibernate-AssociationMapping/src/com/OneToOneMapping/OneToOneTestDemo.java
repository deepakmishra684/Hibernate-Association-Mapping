package com.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class OneToOneTestDemo {
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		Vehicle vehicle = new Vehicle();

		vehicle.setVehicleName("BMW Car");
		
		user.setUserName("Deepak Mishra");
		user.setVehicle(vehicle);

		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernateOTO.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);
		//Vehicle v=(Vehicle)session.load(Vehicle.class, 1);
		//System.out.println(v.getUserDetails().toString());
		session.getTransaction().commit();
		session.close();

	}
}