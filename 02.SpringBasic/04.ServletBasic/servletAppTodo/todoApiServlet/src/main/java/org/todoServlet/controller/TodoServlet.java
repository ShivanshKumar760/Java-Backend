package org.todoServlet.controller;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.todoServlet.model.Todo;
import org.todoServlet.service.TodoService;

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.io.IOException;

public class TodoServlet extends HttpServlet {

    TodoService service;
    public TodoServlet(TodoService s){
        this.service=s;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
        System.out.println("Get Method called!");
        resp.setContentType("application/json");
        StringBuilder result = service.getRequstService();
        resp.getWriter().write(result.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws IOException {
        System.out.println("Post Method called!");
        String task = req.getParameter("task");
        service.addTask(task);
        resp.getWriter().write("Todo added successfully");
    }

}
