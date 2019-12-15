package ru.bobahe.api;

public interface Command {

    void execute() throws RuntimeException;
    String getName();

}
