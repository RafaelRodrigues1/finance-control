package br.com.financeapp.financecontrol.models.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name = "id_user", unique = true)
	private User user;
	
	@Column(nullable = false, length = 9)
	private String cep;
	
	@Column(nullable = false, length = 40)
	private String state;
	
	@Column(nullable = false, length = 40)
	private String city;
	
	@Column(nullable = false, length = 40)
	private String neighborhood;
	
	@Column(nullable = false, length = 40)
	private String street;
	
	@Column(nullable = false, length = 10)
	private String number;
	
	public Address() {}

	public Address(String state, String city, String neighborhood, 
			String street, String number) {
		this.state = state;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.number = number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(user, other.user);
	}
}
