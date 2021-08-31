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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.financeapp.financecontrol.models.entities.enums.ExpenseStatus;
import br.com.financeapp.financecontrol.models.entities.enums.ExpenseType;
	
@Entity
@Table(name = "expenses")
public class Expense implements Serializable{
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
	private int expenseType;
	
	@Column(nullable = false)
	private int expenseStatus;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@OneToMany(mappedBy = "expense", cascade = CascadeType.ALL)
	private Set<Installment> installments = new HashSet<>();
	
	public Expense() {}

	public Expense(String name, double amount, LocalDate instant, ExpenseType expenseType, 
			ExpenseStatus expenseStatus, User user) {
		this.name = name;
		this.amount = amount;
		this.instant = instant;
		setExpenseType(expenseType);
		setStatus(expenseStatus);
		this.user = user;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getInstant() {
		return instant;
	}

	public void setInstant(LocalDate instant) {
		this.instant = instant;
	}

	public ExpenseType getExpenseType() {
		return ExpenseType.valueOf(this.expenseType);
	}

	public void setExpenseType(ExpenseType expenseType) {
		if(expenseType != null) {
			this.expenseType = expenseType.getCode();
		}
	}

	public ExpenseStatus getStatus() {
		return ExpenseStatus.valueOf(this.expenseStatus);
	}

	public void setStatus(ExpenseStatus expenseStatus) {
		if(expenseStatus != null)
		this.expenseStatus = expenseStatus.getCode();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Installment> getInstallments() {
		return installments;
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
		Expense other = (Expense) obj;
		return id == other.id;
	}
}
