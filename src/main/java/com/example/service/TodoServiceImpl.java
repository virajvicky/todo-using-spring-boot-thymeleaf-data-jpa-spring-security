package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Todo;
import com.example.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository repo;

	@Override
	public List<Todo> getAllData() {

		return repo.findAll();
	}

	@Override
	public void saveTodo(Todo todo) {
		repo.save(todo);
	}

	@Override
	public Todo updateTodo(int id) {
		Optional<Todo> optional = repo.findById(id);
		Todo todo = null;
		todo = optional.get();
		return todo;
	}

	@Override
	public void deleteTodo(int id) {
		repo.deleteById(id);

	}

	@Override
	public List<Todo> getEnabledData() {

		List<Todo> allItems = repo.findAll();
		List<Todo> enabledItems = allItems.stream().filter(todo -> todo.isDays7() || todo.isDays5() || todo.isDays3() || todo.isDays2())
 // Filter only checked items
				.collect(Collectors.toList());
		return enabledItems;
	}

	@Override
	public List<Todo> getDisabledData() {

		List<Todo> allItems = repo.findAll();
		List<Todo> enabledItems = allItems.stream().filter(todo -> !todo.isDays7() && !todo.isDays5() && !todo.isDays3() && !todo.isDays2()) // Filter only checked items
				.collect(Collectors.toList());
		return enabledItems;
	}

}
