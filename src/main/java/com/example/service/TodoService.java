package com.example.service;

import java.util.List;

import com.example.Entity.Todo;

public interface TodoService {
	
	List<Todo>getAllData();
	void saveTodo( Todo todo);
	Todo updateTodo(int id);
	void deleteTodo(int id);
	List<Todo> getEnabledData();
	List<Todo> getDisabledData();
	

}
