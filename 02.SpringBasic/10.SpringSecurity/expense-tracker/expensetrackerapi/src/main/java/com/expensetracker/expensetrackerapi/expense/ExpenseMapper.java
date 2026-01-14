package com.expensetracker.expensetrackerapi.expense;

import java.time.LocalDate;

import com.expensetracker.expensetrackerapi.user.User;

public class ExpenseMapper {
    //to entity
    public static ExpenseEntity toEntity(ExpenseRequestDTO expenseDTO,User user) {
        ExpenseEntity expense = new ExpenseEntity();
        expense.setAmount(expenseDTO.getAmount());
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(LocalDate.parse(expenseDTO.getDate()));
        expense.setUser(user);
        return expense;
    }

    //to dto
    public static ExpenseResponseDTO toDTO(ExpenseEntity expenseEntity) {
        ExpenseResponseDTO expenseDTO = new ExpenseResponseDTO();
        expenseDTO.setId(expenseEntity.getId());
        expenseDTO.setAmount(expenseEntity.getAmount());
        expenseDTO.setTitle(expenseEntity.getTitle());
        expenseDTO.setDate(expenseEntity.getDate().toString());
        return expenseDTO;
    }
}
