package Observer;

public interface Observable {
    public void notify(JobPost jobPosting);
    public void attach(Observer observer);
    public void addJob(JobPost jobPosting);
}
