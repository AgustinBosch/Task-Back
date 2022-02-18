package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Task;
import com.example.demo.service.ITaskService;

@RestController
public class TaskController {

	@Autowired
	private ITaskService taskService;

	@CrossOrigin(origins = "*")
	@GetMapping("/task/todos")
	public List<Task> getProductos() {
		return taskService.getTasks();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/task/crear")
	public Task createProducto(@RequestBody Task t) {
		return taskService.saveTask(t);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/task/borrar/{id}")
	public String deleteProducto(@PathVariable Integer id) {
		taskService.deleteTask(id);
		return "ok";
	}
	
	
	@CrossOrigin(origins = "*")
	@PutMapping("/task/editar/{id}")
	public Task editProducto(@PathVariable Integer id, @RequestBody Task t) {
		Task newt = taskService.findTask(id);

		newt.setText(t.getText());
		newt.setDate(t.getDate());
		newt.setReminder(t.isReminder());

		taskService.saveTask(t);

		return t;

	}
}
