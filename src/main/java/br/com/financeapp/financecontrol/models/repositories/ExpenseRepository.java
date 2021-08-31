package br.com.financeapp.financecontrol.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.financeapp.financecontrol.models.entities.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
