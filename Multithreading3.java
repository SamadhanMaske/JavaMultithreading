// When we are creating only one object of thread created by programmer, we can use the concept of anonymous classes, or 
// anonymous class with interface to make our code more efficient

public class Multithreading3 
{
    public static void main(String[] args) {
        Runnable ob1 = new Runnable()
            {
                public void run()
                {
                    for(int i=0;i<5;i++)
                    {
                        System.out.println("Thread 1");
                        try{Thread.sleep(100); } catch(Exception e) {};
                    }
                }
            };
        Runnable ob2 = new Runnable()
            {
                public void run()
                {
                    for(int i=0;i<5;i++)
                    {
                        System.out.println("Thread 2");
                        try{Thread.sleep(100); } catch(Exception e) {};
                    }
                }
            };
        
        Thread t1 = new Thread(ob1);
        Thread t2 = new Thread(ob2);

        t1.start();
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            // TODO: handle exception
        }
        t2.start();
    }
}
