// Another way to implement multithreading is to implement Runnable interface. We need to make referance of Runnable interface and object of 
// the class. Also we need to passs this referance of Runnable as parameter to the Thread constructor as in below example

class Thread3 implements Runnable
{
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("Thread 1");
            try{Thread.sleep(100); } catch(Exception e) {};
        }
    }
}

class Thread4 implements Runnable
{
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("Thread 2");
            try{Thread.sleep(100); } catch(Exception e) {};
        }
    }
}

public class Multithreading2 {
    public static void main(String[] args) 
    {
        Runnable ob1 = new Thread3();
        Runnable ob2 = new Thread4();
        
        Thread t1 = new Thread(ob1);
        Thread t2 = new Thread(ob2);

        t1.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            // TODO: handle exception
        }
        t2.start();
    }
}
