package br.com.financeapp.financecontrol.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "installments")
public class Installment implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private double amount;
	
	@Column(nullable = false, name = "due_date")
	private LocalDate dueDate;
	
	@ManyToOne
	@JoinColumn(name = "id_expense")
	private Expense expense;
	
	@OneToOne(mappedBy = "installment", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Installment() {}

	public Installment(double amount, LocalDate dueDate, Expense expense, Payment payment) {
		this.amount = amount;
		this.dueDate = dueDate;
		this.expense = expense;
		setPayment(payment);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
		payment.setInstallment(this);
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
		Installment other = (Installment) obj;
		return id == other.id;
	}
}
