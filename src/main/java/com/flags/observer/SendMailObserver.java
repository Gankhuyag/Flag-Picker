package com.flags.observer;
 

public class SendMailObserver extends Observer {

    @Override
    public void update() {
        System.out.println("Sending mail to Customer");
    }

    public SendMailObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

}
