package com.expensetracker.expensetrackerapi.expense;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensetracker.expensetrackerapi.user.User;


@Repository
public interface ExpenseRepo extends JpaRepository<ExpenseEntity, Long> {
    List<ExpenseEntity> findByUser(User user);
}