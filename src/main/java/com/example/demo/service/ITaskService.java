package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Task;

public interface ITaskService {
	public List<Task> getTasks();
	public Task saveTask(Task p);
	public void deleteTask(Integer id);
	public Task findTask(Integer id);

}
