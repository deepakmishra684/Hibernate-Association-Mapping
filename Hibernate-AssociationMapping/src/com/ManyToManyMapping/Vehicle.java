package com.ManyToManyMapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VEHICLE_ID")
	private int vehicleId;

	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	/**
	 * What is mappedBy
	 * 
	 * mappedBy attribute says that, hey hibernate/JPA I already associated with
	 * Opposite entity, they will create a column for me or going to place
	 * generated table to manage the foreign key relationship.
	 * 
	 * If mapped by is not used then hibernate is going to create a table for
	 * vehicle id to manage the realatioship
	 */
	@ManyToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
	private Collection<UserDetails> user = new ArrayList<UserDetails>();

	public Collection<UserDetails> getUser() {
		return user;
	}

	public void setUser(Collection<UserDetails> user) {
		this.user = user;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}