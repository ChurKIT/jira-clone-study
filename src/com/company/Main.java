package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите команду:");
        String command;
        do{
            command = reader.readLine();
            new Command(command);
        } while (!command.equals("quit"));
    }
}
