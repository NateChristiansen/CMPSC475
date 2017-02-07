package cmpsc475.w2c2;

/**
 * Created by natec on 1/19/2017.
 */

public class Counter {
    private int count;
    public boolean negatives;

    public Counter(){
        count = 0;
    }
    public void add(int i){
        count+=i;
    }
    public void sub(int i){
        if (count >= i || negatives)
            count-=i;
        else
            count = 0;
    }
    public Integer getCount(){
        return count;
    }
}
