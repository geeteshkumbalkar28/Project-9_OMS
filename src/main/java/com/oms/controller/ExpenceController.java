package com.oms.controller;


import com.oms.dto.ExpenseDto.AllResponseExpenseDto;
import com.oms.dto.ExpenseDto.ExpenseDeleteResponse;
import com.oms.dto.ExpenseDto.ExpenseDto;
import com.oms.dto.ExpenseDto.ExpenseResponseDto;
import com.oms.exceptions.ExpenceException.Incorrect;
import com.oms.exceptions.ExpenceException.Incorrect1;
import com.oms.service.ExpenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Expence")
@RestController
public class ExpenceController {


    @Autowired
    public ExpenceService expenceService;


    //Post Mapping (Add)
    @PostMapping("/addExpence")
    public ResponseEntity<ExpenseResponseDto> addExpence(@RequestBody ExpenseDto expense) {

        try {
            String s = expenceService.addExpence(expense);
            return (ResponseEntity.status(HttpStatus.OK).body(new ExpenseResponseDto("Sucess", s)));

        } catch (Incorrect i) {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExpenseResponseDto("Unscess", "Incorrect")));
        }

    }


    //Put Mapping(update)
    @PutMapping("/updateExpenceById/{Id}")
    public ResponseEntity<ExpenseResponseDto> updateExpenceById(@PathVariable Integer Id, @RequestBody ExpenseDto newExpenseDto) {
        try {
            String s = expenceService.updateExpence(newExpenseDto, Id);
            return ResponseEntity.status(HttpStatus.OK).body(new ExpenseResponseDto("Sucess", s));
        } catch (Incorrect i) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExpenseResponseDto("unsucess", "IdNotFound"));

        }
    }


    @GetMapping("/getById")
    public ResponseEntity<ExpenseDto> getById(@RequestParam Integer expenseId) {

        try {
            ExpenseDto byId = expenceService.getById(expenseId);
            return ResponseEntity.status(HttpStatus.OK).body(byId);
        } catch (Incorrect i) {
            return (ResponseEntity<ExpenseDto>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }


    //Get Mapping
    @GetMapping("/getAll")
    public ResponseEntity<AllResponseExpenseDto> getAll() {

        try {
            AllResponseExpenseDto allResponseExpenseDto = new AllResponseExpenseDto("Sucessfull");
            List<ExpenseDto> allExpence = expenceService.getAllExpences();
            allResponseExpenseDto.setList(allExpence);

            return ResponseEntity.status(HttpStatus.OK).body(allResponseExpenseDto);
        } catch (Incorrect i) {
            AllResponseExpenseDto allResponseExpenseDto1 = new AllResponseExpenseDto("Unsucessfull");
            allResponseExpenseDto1.setException("No Expense Data Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allResponseExpenseDto1);
        }
    }


    @DeleteMapping("/DeleteExpenceById")
    public ResponseEntity<?> DeleteExpenceById(@RequestParam Integer id) {

        try {
            ExpenseDeleteResponse expenseDeleteResponse = new ExpenseDeleteResponse("Sucessfull");
            expenseDeleteResponse.setResponse(expenceService.deleteExpence(id));
            return ResponseEntity.status(HttpStatus.OK).body(expenseDeleteResponse);
        } catch (Incorrect1 incorrect1) {
            ExpenseDeleteResponse expenseDeleteResponse = new ExpenseDeleteResponse("Unsucessfull");
            expenseDeleteResponse.setException(String.valueOf(incorrect1));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(expenseDeleteResponse);
        }


    }


}









