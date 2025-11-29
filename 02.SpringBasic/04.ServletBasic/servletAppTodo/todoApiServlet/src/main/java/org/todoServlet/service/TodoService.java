package org.todoServlet.service;
import org.todoServlet.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private List<Todo> todos=new ArrayList<>();

    private int counter = 1;
    public StringBuilder getRequstService(){

            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < todos.size(); i++) {
                Todo t = todos.get(i);
                json.append(String.format("{\"id\":%d, \"task\":\"%s\"}", t.getId(), t.getTask()));
                if (i < todos.size() - 1) json.append(",");
            }
            json.append("]");

            return json;

    }
    public void addTask(String task){
        Todo todo = new Todo(counter++, task);
        todos.add(todo);
    }
}
