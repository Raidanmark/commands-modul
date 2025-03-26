package org.example.model.commands;

import org.example.services.Command;

public abstract class AbstractCommand implements Command {

    @Override
    public boolean isAvailableInStatus(Status status) {
        return true;
    };

    @Override
    public Status getNewStatus() {
        return null;
    }
}
