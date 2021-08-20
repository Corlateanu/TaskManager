package com.taskmanager.service;

import com.taskmanager.domain.Task;
import com.taskmanager.persistence.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }

    public void createTask(Task newTask) {


        taskRepository.saveTask(newTask);


    }


    public List<Task> showTask(String userNameT) {
        List<Task> userTasks = new ArrayList<>();
        List<Task> a = taskRepository.findTask();

        for (Task i : a) {

            if (i.getUserName().equals(userNameT)) {

                userTasks.add(i);
            }


        }


        return userTasks;
    }
}
