package com.expensetracker.expensetrackerapi.expense;

import org.springframework.stereotype.Service;

import com.expensetracker.expensetrackerapi.user.User;

@Service
public class ExpenseService {
    private final ExpenseRepo expenseRepo;
    public ExpenseService(ExpenseRepo expenseRepo){
        this.expenseRepo = expenseRepo;
    }

    //create expense
    public ExpenseResponseDTO addExpense(ExpenseRequestDTO expenseRequestDTO,User user){
        ExpenseEntity expenseEntity = ExpenseMapper.toEntity(expenseRequestDTO, user);
        ExpenseEntity savedExpense = expenseRepo.save(expenseEntity);
        return ExpenseMapper.toDTO(savedExpense);
    }

    //Read all
    public java.util.List<ExpenseResponseDTO> getAllExpenses(User user){
        java.util.List<ExpenseEntity> expenses = expenseRepo.findByUser(user);
        java.util.List<ExpenseResponseDTO> expenseDTOs = new java.util.ArrayList<>();
        for(ExpenseEntity expense : expenses){
            expenseDTOs.add(ExpenseMapper.toDTO(expense));
        }
        return expenseDTOs;
    }
    //same using steam api
    public java.util.List<ExpenseResponseDTO> getAllExpensesStream(User user){
        java.util.List<ExpenseEntity> expenses = expenseRepo.findByUser(user);
        return expenses.stream()
                .map(ExpenseMapper::toDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    //Read one 
    public ExpenseResponseDTO getExpenseById(Long id,User user){
        ExpenseEntity expense = expenseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        if(!expense.getUser().getId().equals(user.getId())){
            throw new RuntimeException("Unauthorized access");
        }
        return ExpenseMapper.toDTO(expense);
    }
    //update
    public ExpenseResponseDTO updateExpense(Long id,ExpenseRequestDTO expenseRequestDTO,User user){
        ExpenseEntity expense = expenseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        if(!expense.getUser().getId().equals(user.getId())){
            throw new RuntimeException("Unauthorized access");
        }
        expense.setTitle(expenseRequestDTO.getTitle());
        expense.setAmount(expenseRequestDTO.getAmount());
        expense.setDate(java.time.LocalDate.parse(expenseRequestDTO.getDate()));
        ExpenseEntity updatedExpense = expenseRepo.save(expense);
        return ExpenseMapper.toDTO(updatedExpense);
    }
    //delete
    public void deleteExpense(Long id,User user){
        ExpenseEntity expense = expenseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        if(!expense.getUser().getId().equals(user.getId())){
            throw new RuntimeException("Unauthorized access");
        }
        expenseRepo.delete(expense);
    }
    
}
