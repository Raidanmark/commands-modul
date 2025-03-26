package org.example.commands;

import org.example.services.Command;

public abstract class AbstractCommand implements Command {

    @Override
    public boolean isAvailableInStatus(Status status) {};
}
