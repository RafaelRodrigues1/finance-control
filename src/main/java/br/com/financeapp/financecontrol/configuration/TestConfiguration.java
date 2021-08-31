package br.com.financeapp.financecontrol.configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.financeapp.financecontrol.models.entities.Address;
import br.com.financeapp.financecontrol.models.entities.Expense;
import br.com.financeapp.financecontrol.models.entities.Income;
import br.com.financeapp.financecontrol.models.entities.User;
import br.com.financeapp.financecontrol.models.entities.enums.ExpenseStatus;
import br.com.financeapp.financecontrol.models.entities.enums.ExpenseType;
import br.com.financeapp.financecontrol.models.entities.enums.IncomeType;
import br.com.financeapp.financecontrol.models.repositories.ExpenseRepository;
import br.com.financeapp.financecontrol.models.repositories.IncomeRepository;
import br.com.financeapp.financecontrol.models.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Address address1 = new Address("Pernambuco", "Recife", "Casa Amarela", 
				"Bonito de Santa Fé", "174A");
		Address address2 = new Address("Pernambuco", "Olinda", "Alto da Sé", 
				"Sé", "621");
		Address address3 = new Address("Pernambuco", "Igarassu", "Saramandaia", 
				"Rua Epitáfio", "S/N");
		
		User user1 = new User("Rafael", "rafa@email.com", 
				LocalDate.of(1994, Month.OCTOBER, 27),"122334455", address1, "123456");
		User user2 = new User("Larissa", "lari@email.com", 
				LocalDate.of(2003, Month.AUGUST, 15),"455336622", address3, "654321");
		User user3 = new User("Carla", "carla@email.com", 
				LocalDate.of(1997, Month.MARCH, 1),"988776655", address2, "456321");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Income income1 = new Income("Salário mensal", 3963.00, 
				LocalDate.of(2021, Month.OCTOBER, 5), IncomeType.TRANSFER, user1);
		Income income2 = new Income("Cachê", 2340.00, 
				LocalDate.of(2021, Month.OCTOBER, 3), IncomeType.MONEY, user2);
		Income income3 = new Income("Salário mensal", 1890.00, 
				LocalDate.of(2021, Month.OCTOBER, 3), IncomeType.MONEY, user3);
		
		incomeRepository.saveAll(Arrays.asList(income1, income2, income3));
		
		Expense expense1 = new Expense("Conta de energia", 168.43, 
				LocalDate.of(2021, Month.SEPTEMBER, 14), ExpenseType.FIXED, 
				ExpenseStatus.OPEN, user1);
		Expense expense2 = new Expense("Conta de energia", 364.73, 
				LocalDate.of(2021, Month.APRIL, 14), ExpenseType.FIXED, 
				ExpenseStatus.DUE, user3);
		Expense expense3 = new Expense("Conta de energia", 647.22, 
				LocalDate.of(2021, Month.SEPTEMBER, 14), ExpenseType.FIXED, 
				ExpenseStatus.OPEN, user2);
		Expense expense4 = new Expense("Feira", 512.48, 
				LocalDate.of(2021, Month.MARCH, 14), ExpenseType.VARIABLE, 
				ExpenseStatus.PAID, user2);
		Expense expense5 = new Expense("Lanche", 32.50, 
				LocalDate.of(2021, Month.AUGUST, 14), ExpenseType.VARIABLE, 
				ExpenseStatus.PAID, user3);
		
		expenseRepository.saveAll(Arrays.asList(expense1, expense2, 
				expense3, expense4, expense5));
	}
}









