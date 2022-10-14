import ChainResponsibility.Bank;
import ChainResponsibility.Bitcoin;
import ChainResponsibility.Paypal;
import Command.Bulb;
import Command.RemoteControl;
import Command.TurnOff;
import Command.TurnOn;
import Iterator.RadioStation;
import Iterator.StationList;
import Mediator.ChatRoom;
import Mediator.User;
import Memento.Editor;
import Memento.EditorMemento;
import Observer.EmploymentAgency;
import Observer.JobPost;
import Observer.JobSeeker;
import State.DefaultText;
import State.LowerCase;
import State.TextEditor;
import State.UpperCase;
import Strategy.BubbleSortStrategy;
import Strategy.QuickSortStrategy;
import Strategy.Sorter;
import TemplateMethod.AndroidBuilder;
import TemplateMethod.IosBuilder;
import Visitor.*;

public class App {

    public static void main(String[] args) {

        //  Chain of Responsibility
        Bank bank = new Bank(100);
        Paypal paypal = new Paypal(200);
        Bitcoin bitcoin = new Bitcoin(300);

        bank.setNext(paypal);
        paypal.setNext(bitcoin);
        try {
            bank.pay(259);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Command
        Bulb bulb = new Bulb();

        TurnOn turnOn = new TurnOn(bulb);
        TurnOff turnOff = new TurnOff(bulb);

        RemoteControl remote = new RemoteControl();
        remote.submit(turnOn);
        remote.submit(turnOff);

        // Iterator
        StationList stationList = new StationList(5);

        stationList.addStation(new RadioStation(89));
        stationList.addStation(new RadioStation(101));
        stationList.addStation(new RadioStation(102));
        stationList.addStation(new RadioStation(103.2f));

        for(stationList.rewind();stationList.key()< stationList.count();stationList.next()) {
            System.out.println(stationList.current().getFrequency());
        }
        stationList.removeStation(new RadioStation(89));

        // Mediator
        ChatRoom mediator = new ChatRoom();

        User john = new User("'John Doe", mediator);
        User jane = new User("'Jane Doe", mediator);

        john.send("'Hi there!");
        jane.send("Hey!");

        // Memento
        Editor editor = new Editor();

        editor.type("'This is the first sentence.");
        editor.type("'This is second.");

        EditorMemento saved = editor.save();

        editor.type("'And this is third.");

        System.out.println(editor.getContent());

        editor.restore(saved);

        editor.getContent();

        // Observer
        JobSeeker johnDoe = new JobSeeker("John Doe");
        JobSeeker janeDoe = new JobSeeker("Jane Doe");

        EmploymentAgency jobPostings = new EmploymentAgency();
        jobPostings.attach(johnDoe);
        jobPostings.attach(janeDoe);

        jobPostings.addJob(new JobPost("Software Engineer"));

        // Visitor
        Monkey monkey = new Monkey();
        Lion lion = new Lion();
        Dolphin dolphin = new Dolphin();

        Speak speak = new Speak();

        monkey.accept(speak);
        lion.accept(speak);
        dolphin.accept(speak);

        Jump jump = new Jump();

        monkey.accept(speak);
        monkey.accept(jump);

        lion.accept(speak);
        lion.accept(jump);

        dolphin.accept(speak);
        dolphin.accept(jump);

        // Strategy
        int[] dataset = {1, 5, 4, 3, 2, 8};

        Sorter sorter_b = new Sorter(new BubbleSortStrategy());
        sorter_b.sort(dataset);

        Sorter sorter_q = new Sorter(new QuickSortStrategy());
        sorter_q.sort(dataset);

        // State
        TextEditor edit = new TextEditor(new DefaultText());
        edit.type("First line");

        edit.setState(new UpperCase());
        edit.type("Second line");
        edit.type("Third line");

        edit.setState(new LowerCase());
        edit.type("Fourth line");
        edit.type("Fifth line");

        // Template Method
        AndroidBuilder androidBuilder = new AndroidBuilder();
        androidBuilder.build();

        IosBuilder iosBuilder = new IosBuilder();
        iosBuilder.build();
    }
}
