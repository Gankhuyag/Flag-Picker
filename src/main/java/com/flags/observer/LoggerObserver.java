package com.flags.observer;
 

public class LoggerObserver extends Observer {
    @Override
    public void update() {
        System.out.println("Logging the order...");

    }

    public LoggerObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

}
