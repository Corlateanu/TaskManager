package com.taskmanager.persistence;

import com.taskmanager.domain.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTaskRepository implements TaskRepository {
    @Override
    public void saveTask(Task newTask) {
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(findTask());
        tasks.add(newTask);

        try {
            FileOutputStream myWriter = new FileOutputStream("tasks.txt");
            ObjectOutputStream out = new ObjectOutputStream(myWriter);
            out.writeObject(tasks);
            out.close();
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }


    @Override
    public List<Task> findTask() {
        List<Task> tasks = new ArrayList<>();
        try {
            FileInputStream myObj = new FileInputStream("tasks.txt");
            ObjectInputStream in = new ObjectInputStream(myObj);
            tasks.addAll((List<Task>) in.readObject());
        } catch (IOException | ClassNotFoundException i) {
        }

        return tasks;
    }
}

