package com.OneToManyMapping;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserDetails {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@OneToMany
	@JoinTable(name = "USER_VEHICLE", 
	           joinColumns = @JoinColumn(name = "USER_ID"),
	           inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")) 
			
	/*@OneToMany(targetEntity=Vehicle.class,mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)*/
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

	public int getUserId() {
		return userId;
	}

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
