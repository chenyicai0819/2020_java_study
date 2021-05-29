package org.example.ui.pay;

public class GenerateException extends Exception{
    public GenerateException(String message){
        super(message);
        System.out.println(message);
    }
}