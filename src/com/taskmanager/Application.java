package com.taskmanager;

import com.taskmanager.domain.Task;
import com.taskmanager.domain.User;
import com.taskmanager.persistence.FileTaskRepository;
import com.taskmanager.persistence.FileUserRepository;
import com.taskmanager.service.TaskService;
import com.taskmanager.service.UserService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        TaskService taskService = new TaskService(new FileTaskRepository());
        UserService userService = new UserService(new FileUserRepository());


        if (args[0].equals("-createUser")) {
            userService.createUser(new User(args[1], args[2], args[3]));


        }
        if (args[0].equals("-showAllUsers")) {
            List<User> a = userService.showAllUser();
            for (User i : a) {
                Pattern p = Pattern.compile("\'([^\']*)\'");
                Matcher m = p.matcher(i.aranjareUser());
                while (m.find()) {
                    System.out.println(m.group(1));
                }


            }
        }
        if (args[0].equals("-addTask")) {
            taskService.createTask(new Task(args[1],args[2],args[3]));
        }

        if(args[0].equals("-showTasks")){
            List<Task> t = taskService.showTask(args[1]);

            for(Task i : t){

                System.out.println(i.aranjareTask());
            }
        }



    }

}

