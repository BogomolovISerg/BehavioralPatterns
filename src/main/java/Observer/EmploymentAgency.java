package Observer;

import java.util.ArrayList;

public class EmploymentAgency implements Observable{
    protected ArrayList<Observer> observers;

    public EmploymentAgency(){
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void notify(JobPost jobPosting){
        for(Observer ob : observers){
            ob.onJobPosted(jobPosting);
        }
    }

    @Override
    public void attach(Observer observer){
        this.observers.add(observer);
    }

    @Override
    public void addJob(JobPost jobPosting){
        this.notify(jobPosting);
    }
}
