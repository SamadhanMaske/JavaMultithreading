// isAlive() is method to check whether the method is woking or not
// join() is used to join the thread with main thread

public class Multithreading5
{
    public static void main(String[] args) throws InterruptedException  {
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

        t1.join();
        t2.join();
        System.out.println(t1.isAlive());
    }
}

