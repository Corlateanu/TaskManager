package com.taskmanager.persistence;

import com.taskmanager.domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUserRepository implements UserRepository {


    @Override
    public void saveUser(User newUser) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt",true);
            myWriter.write(newUser.aranjareUser());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

    @Override
    public List<User> findUsers() {
        List<User> users = new ArrayList<>();


        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] data1 = data.split(",");
                users.add(new User(data1[0],data1[1],data1[2]));

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return users;
    }


}
