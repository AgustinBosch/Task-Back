package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repo.TaskRepository;

@Service
public class TaskService implements ITaskService{
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> getTasks() {
		return this.taskRepository.findAll();
	}

	@Override
	public Task saveTask(Task t) {
		return this.taskRepository.save(t);
	}

	@Override
	public void deleteTask(Integer id) {
		taskRepository.deleteById(id);
	}

	@Override
	public Task findTask(Integer id) {
		return taskRepository.findById(id).orElse(null);
	}

}
