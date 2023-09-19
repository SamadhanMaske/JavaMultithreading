// The runnable is a functional interface, so we can use lambda expression to make object of runnable interface

public class Multithreading4
{
    public static void main(String[] args) {
        Runnable ob1 = ()->
                {
                    for(int i=0;i<5;i++)
                    {
                        System.out.println("Thread 1");
                        try{Thread.sleep(100); } catch(Exception e) {};
                    }        
                };
        Runnable ob2 = ()->
                {
                    for(int i=0;i<5;i++)
                    {
                        System.out.println("Thread 2");
                        try{Thread.sleep(100); } catch(Exception e) {};
                    }
                };
        
        Thread t1 = new Thread(ob1);
        Thread t2 = new Thread(ob2);

        t1.start();
        try { Thread.sleep(10); } catch (Exception e) { }
        t2.start();
    }
}
