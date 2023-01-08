package Ex2.Ex2_2;

import java.util.Iterator;
import java.util.PriorityQueue;

public class CustomExecutor {

    private PriorityQueue<Task> ThreadPool;


    public CustomExecutor() {
        this.ThreadPool = new PriorityQueue<Task>();
    }

    public boolean add_withPriority(Task t) {//2
        return this.ThreadPool.add(t);
    }
    public boolean add_withoutPriority(Task t) {//2
        return this.ThreadPool.add(t);
    }

    public void remove(Task t) {
        this.ThreadPool.remove(t);

    }
    public void submit(){
        try {
            this.ThreadPool.peek().call();
        }
        catch(Exception e){
            System.out.println("There is a problem with submit");
            e.printStackTrace();
        }
        this.ThreadPool.poll();
    }

    public void submitAll(){
        for(Task t: this.ThreadPool){
            this.submit();
        }
    }



}


