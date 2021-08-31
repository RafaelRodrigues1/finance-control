package br.com.financeapp.financecontrol.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 60)
	private String name;
	
	@Column(nullable = false, length = 40)
	private String email;
	
	@Column(nullable = false, name = "birth_date")
	private LocalDate birthDate;
	
	@Column(nullable = false, length = 15)
	private String phone;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Address address;
	
	@Column(nullable = false, length = 20)
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	private Set<Expense> expenses = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	private Set<Income> incomes = new HashSet<>();
	
	public User() {}

	public User(String name, String email, LocalDate birthDate, String phone, 
			Address address, String password) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.phone = phone;
		setAddress(address);
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
		address.setUser(this);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Expense> getExpenses() {
		return expenses;
	}

	public Set<Income> getIncomes() {
		return incomes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
