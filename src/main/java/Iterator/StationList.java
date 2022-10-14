package Iterator;

import java.util.Stack;

public class StationList {

    protected RadioStation stations[];
    protected int counter;
    public int teck;

    public StationList(int count){
        this.counter = count;
        stations = new RadioStation[count];
        this.teck = 0;
    }

    public void addStation(RadioStation station){
        this.teck++;
        RadioStation[] r;
        if(this.teck > this.counter){
            this.counter =+ 100;
            r = new RadioStation[this.counter];
            for(int i=0; i < this.teck; i++ )
                r[i] = this.stations[i];
            this.stations = r;
        }
        this.stations[this.teck] = station;
    }

    public void removeStation(RadioStation toRemove){

        float toRemoveFrequency = toRemove.getFrequency();
        Stack<Integer> stack = null;

        for (var i = 0; i < this.stations.length; i++) {
            if(this.stations[i].frequency == toRemoveFrequency){
                stack.push(i);
            }
        }
        if (stack.empty())
            return;

        var result = new RadioStation[this.stations.length-stack.size()];

        int index = stack.pop();
        for (var i = this.stations.length-1; i >=0; i--){

            if (i != index){
                var newIndex = i < index ? i : i - 1;
                result[newIndex] = this.stations[i];
            }else {
                if (stack.empty())
                    index = -1;
                else
                    index = stack.pop();
            }
        }

        this.stations = result;
    }

    public int count(){
        return this.stations.length;
    }

    public RadioStation current(){
        return this.stations[this.counter];
    }

    public int key(){
        return this.counter;
    }

    public void next(){
        this.counter++;
    }

    public void rewind(){
        this.counter = 0;
    }

    public boolean valid(){
        return this.stations[this.counter] != null;
    }
}
