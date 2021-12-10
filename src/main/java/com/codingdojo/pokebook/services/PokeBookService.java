package com.codingdojo.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.pokebook.models.Expense;
import com.codingdojo.pokebook.repositories.PokeBookRepository;

@Service
public class PokeBookService {

	
	 // adding the book repository as a dependency
   private final PokeBookRepository pokebookRepository;
   
   public PokeBookService(PokeBookRepository pokebookRepository) {
       this.pokebookRepository = pokebookRepository;
   }
   // returns all the books
   public List<Expense> allExpense() {
       return pokebookRepository.findAll();
   }
   // creates a book
   public Expense createExpense(Expense e) {
       return pokebookRepository.save(e);
   }
   // retrieves a book
   public Expense findExpense(Long id) {
       Optional<Expense> optionalExpense = pokebookRepository.findById(id);
       if(optionalExpense.isPresent()) {
           return optionalExpense.get();
       } else {
           return null;
       }
   }
   
// Updates a book
	public Expense updateExpense(Expense expense) {
		
		return pokebookRepository.save(expense);
	}
	
	// Deletes a book
	public void deleteExpense(Long id) {
		pokebookRepository.deleteById(id);
		
	}
}
