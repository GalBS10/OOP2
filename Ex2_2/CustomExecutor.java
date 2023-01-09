package Ex2.Ex2_2;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CustomExecutor {

    private PriorityBlockingQueue<Runnable> ThreadPool;
    private ExecutorService executor;
    private int Max_Priority;

    //constructor//
    public CustomExecutor(){
        ThreadPool = new PriorityBlockingQueue<>();
        executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()/2
                ,Runtime.getRuntime().availableProcessors()-1,300,TimeUnit.MILLISECONDS,ThreadPool);
    }

    //1//
    public Future submit(Task task) {
        if(ThreadPool.size()==Runtime.getRuntime().availableProcessors()-1){//checking if there is more space for new threads.
            return null;
        }
        if(task.getPriority()<Max_Priority){ //Checking if the new thread has higher priority than Max_Priority.
            Max_Priority = task.getPriority();
        }
       return executor.submit(task);
    }
    //2//
    public Future submit(Callable c,TaskType t) {
        Task task =  Task.createTask(c,t);
        Future f = submit(task);
        return f;
    }
    //3//
    public Future submit(Callable c){
        Task task = Task.createTask(c);
        Future f = submit(task);
        return f;
    }
    //10//
    public int getCurrentMax(){
        return Max_Priority;
    }
    //11.b//
    public void executeAll(){
        try {
            for (Runnable r : ThreadPool) {
                ((Task) r).call();
            }
        }
        catch(Exception e){
            System.out.println("There is an error with executeAll");
            e.printStackTrace();
        }
    }
    //11.c//
    public void gracefullyTerminate(){
       executor.close();// After a thread had finished, the executor removing him from the priorityBlockingQueue
    }


}


