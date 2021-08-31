package br.com.financeapp.financecontrol.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.financeapp.financecontrol.models.entities.enums.IncomeType;

@Entity
@Table(name = "incomes")
public class Income implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 40)
	private String name;
	
	@Column(nullable = false)
	private double amount;
	
	@Column(nullable = false)
	private LocalDate instant;
	
	@Column(nullable = false)
	private int incomeType;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	public Income() {}

	public Income(String name, double amount, LocalDate instant, 
			IncomeType incomeType, User user) {
		this.name = name;
		this.amount = amount;
		this.instant = instant;
		setIncomeType(incomeType);
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getInstant() {
		return instant;
	}

	public void setInstant(LocalDate instant) {
		this.instant = instant;
	}

	public IncomeType getIncomeType() {
		return IncomeType.valueOf(this.incomeType);
	}

	public void setIncomeType(IncomeType incomeType) {
		if(incomeType != null) {
			this.incomeType = incomeType.getCode();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Income other = (Income) obj;
		return id == other.id;
	}
}
