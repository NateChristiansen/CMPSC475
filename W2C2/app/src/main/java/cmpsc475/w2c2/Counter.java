package cmpsc475.w2c2;

/**
 * Created by natec on 1/19/2017.
 */

public class Counter {
    private int count;

    public Counter(){
        count = 0;
    }
    public void add(){
        count++;
    }
    public void sub(){
        if (count > 0)
            count--;
    }
    public Integer getCount(){
        return count;
    }
}
