package org.example.services;

public interface Command {
    String getName();
    boolean isAvailable(Status status);
    void execute();
    Status getNewStatus();
}
