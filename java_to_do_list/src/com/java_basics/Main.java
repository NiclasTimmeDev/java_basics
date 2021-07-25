package com.java_basics;

import com.java_basics.input_handler.InputHandler;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to your personal To-Do list :)");
        InputHandler inputHandler = new InputHandler();
        inputHandler.handleInput();
    }
}
