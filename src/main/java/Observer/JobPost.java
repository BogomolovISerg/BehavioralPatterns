package Observer;

public class JobPost {
    protected String title;

    public JobPost(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
