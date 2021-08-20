package com.taskmanager.persistence;

import com.taskmanager.domain.Task;

import java.util.List;

public interface TaskRepository {


    void saveTask(Task newTask);


    List<Task> findTask();
}
