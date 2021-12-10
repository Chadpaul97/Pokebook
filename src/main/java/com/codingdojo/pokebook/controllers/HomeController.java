package com.codingdojo.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.services.PokeBookService;


@Controller
public class HomeController {
	
	private final PokeBookService pokebookService;
    
    public HomeController(PokeBookService pokebookService) {
        this.pokebookService = pokebookService;
    }
    
    
    @RequestMapping("/pokebook")
    public String index(Model model) {
        List<Expense> expenses = pokebookService.allExpense();
        model.addAttribute("expenses", expenses);
        return "index.jsp";
    }
    
	    //returns expense
	    @RequestMapping("/pokebook/expenses")
	    public List<Expense> all() {
	        return pokebookService.allExpense();
	    }
	    
	    //Creates a expense
	    @RequestMapping(value="/pokebook/expenses", method=RequestMethod.POST)
	    public Expense create(@RequestParam(value="name") String name, @RequestParam(value="vendor") String vendor, @RequestParam(value="amount") Double amount, @RequestParam(value="description") String description) {
	    	Expense expense = new Expense(name, vendor, amount, description);
	        return pokebookService.createExpense(expense);
	    }
	    
	    
	    //FIND ONE EXPENSE
	    @RequestMapping("/api/expense/{id}")
	    public Expense show(@PathVariable("id") Long id) {
	    	Expense book = pokebookService.findExpense(id);
	        return book;
	    }
	    
	  //UPDATE EXPENSE
	    
	    @RequestMapping("/expenses/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	    	Expense expense = pokebookService.findExpense(id);
	        model.addAttribute("expense",expense);
	        return "edit.jsp";
	    }
	    
	    @RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	        	pokebookService.updateExpense(expense);
	            return "redirect:/pokebook";
	        }
	    }
	    
	    //DELETE EXPENSE
	    @RequestMapping(value="/expense/delete/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	    	pokebookService.deleteExpense(id);
	    	return "redirect:/pokebook";
	    	
	    }
	    
	    
	    //NEW EXPENSE
	    @RequestMapping("/expense/new")
	    public String newExpense(@ModelAttribute("expense") Expense expense) {
	        return "newexpense.jsp";
	    }
	    @RequestMapping(value="/expenses", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	        if (result.hasErrors()) {
	            return "newexpense.jsp";
	        } else {
	            pokebookService.createExpense(expense);
	            return "redirect:/pokebook";
	        }
	    }
	    
	    
		///ONE EXPENSE
		@GetMapping("/expense/{expenseId}")
		public String oneexpense(Model model,@PathVariable("expenseId") Long expenseId) {
		
			Expense expense = pokebookService.findExpense(expenseId);
			
			model.addAttribute("expense",expense);
			
			return "show.jsp";
		}
}
