// Whenever we run a program, it is exexuted by a main thread. We can create many threads by extending Thread class.
// When we start a thread it always call to the run method. So we must define/override the run method inside the thread

class Thread1 extends Thread
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

class Thread2 extends Thread
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

class Multithreading1
{
    public static void main(String args[])
    {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        
        t1.start();
        try{Thread.sleep(10); } catch(Exception e) {};
        t2.start();
    }
}