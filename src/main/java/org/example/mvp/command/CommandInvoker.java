package org.example.mvp.command;

public class CommandInvoker<T> {

    public T invoke(Command<T> command){
        return command.execute();
    }
}
