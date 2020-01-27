package com.flags.observer;

public interface ICommand {
    void execute();
    void undo();
    void redo();
}
