package br.com.financeapp.financecontrol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.financeapp.financecontrol.models.services.ExpenseService;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	
}
