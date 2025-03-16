package com.example.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.Entity.Todo;
import com.example.service.TodoService;


@Controller
public class TodoController {

	@Autowired
	private TodoService ser;
	
	
	 @ModelAttribute
	    public void addDateAttribute(Model model) {
	        model.addAttribute("currentDate", LocalDate.now());
	    }

	@GetMapping("/")
	public String showHome(Model model) {
		model.addAttribute("todolists", ser.getAllData());
		return "home";
	}

	@GetMapping("/add")
	public String showForm(Model model) {
		model.addAttribute("todo", new Todo());
		return "add_todo";
	}

	@PostMapping("save")
	public String saveData(@ModelAttribute Todo todo) {
		ser.saveTodo(todo);
		return "redirect:/view";
	}

	@GetMapping("/view")
	public String viewDate(Model model) {
		model.addAttribute("todolists", ser.getAllData());
		return "index";
	}

	@GetMapping("/modify")
	public String modifyDate(Model model) {
		model.addAttribute("todolists", ser.getAllData());
		return "update_todo";
	}
     @GetMapping("/enabled")
	public String enabledData(Model model) {
		model.addAttribute("todo", ser.getEnabledData());
		return "enabled_todo";
	}
     @GetMapping("/disabled")
 	public String disabledData(Model model) {
 		model.addAttribute("todo", ser.getDisabledData());
 		return "enabled_todo";
 	}

	@GetMapping("/delete")
	public String deleteDate(Model model) {
		model.addAttribute("todolists", ser.getAllData());
		return "delete_todo";
	}

	@GetMapping("updateTodo/{id}")
	public String updateData(@PathVariable int id, Model model) {
		model.addAttribute("todo", ser.updateTodo(id));
		return "on_edit";
	}

	@GetMapping("deleteTodo/{id}")
	public String deleteTodo(@PathVariable int id) {
		ser.deleteTodo(id);
		return "redirect:/delete";
	}
}
