package Memento;

public class Editor {
    protected String content = "";

    public void type(String words){
        this.content += " " + words;
    }

    public String getContent(){
        return this.content;
    }

    public EditorMemento save(){
        return new EditorMemento(this.content);
    }

    public void restore(EditorMemento memento){
        this.content = memento.getContent();
    }
}
