package com.flags.observer;

import com.flags.observer.ICommand;
  
public class SaveObserver extends Observer {
    @Override
    public void update() {
        // TODO Auto-generated method stub
        System.out.println("Creating Country flag information in DB");
    }

    public SaveObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

}
