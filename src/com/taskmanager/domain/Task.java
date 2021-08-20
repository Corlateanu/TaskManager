package com.taskmanager.domain;

public class Task implements java.io.Serializable {
    String taskTitle;
    String userName;
    String descrpition;

    public Task(String userName, String taskTitle, String descrpition) {
        this.userName = userName;
        this.taskTitle = taskTitle;
        this.descrpition = descrpition;
    }

    public String aranjareTask() {


        return userName + "," + taskTitle + "," + descrpition;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescrpition() {
        return descrpition;
    }

    public void setDescrpition(String descrpition) {
        this.descrpition = descrpition;
    }

}
