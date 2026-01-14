package com.expensetracker.expensetrackerapi.expense;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.expensetrackerapi.auth.UserService;
import com.expensetracker.expensetrackerapi.user.User;
// import com.expensetracker.expensetrackerapi.user.UserDTO.UserResponsDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/api/expenses")
@RestController
public class ExpenseController {
    private final ExpenseService expenseService;
    private final UserService userService;
    public ExpenseController(ExpenseService expenseService, UserService userService) {
        this.expenseService = expenseService;
        this.userService = userService;
    }

     // CREATE
    @PostMapping
    public ExpenseResponseDTO addExpense(
            @RequestBody ExpenseRequestDTO dto,
            Authentication auth
    ) {
        // User user = (User) auth.getPrincipal();
        User user = userService.getUserEntityByEmail(auth.getName());
        return expenseService.addExpense(dto, user);
    }

    // Read, Update, Delete methods to be implemented
    @GetMapping("/all")
    public List<ExpenseResponseDTO> getAllExpense(Authentication auth) {
        User user = userService.getUserEntityByEmail(auth.getName());
        return expenseService.getAllExpenses(user);
        
    }

    @GetMapping("/{id}")
    public ExpenseResponseDTO getExpenseById(
            @PathVariable Long id,
            Authentication auth
    ) {
        User user = userService.getUserEntityByEmail(auth.getName());
        return expenseService.getExpenseById(id, user);
    }


    @PutMapping("/{id}")
    public ExpenseResponseDTO updateExpense(
            @PathVariable Long id,
            @RequestBody ExpenseRequestDTO dto,
            Authentication auth
    ) {
        User user = userService.getUserEntityByEmail(auth.getName());
        return expenseService.updateExpense(id, dto, user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteExpense(
            @PathVariable Long id,
            Authentication auth
    ) {
        User user = userService.getUserEntityByEmail(auth.getName());
        expenseService.deleteExpense(id, user);
    }
}
