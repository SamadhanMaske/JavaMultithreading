// Thread communication with wait() and notify()

class Factory
{
    int num;
    boolean valSet = false;
    public synchronized void setNum(int n)
    {
        while(valSet)
        {
            try{wait();} catch(Exception e){}
        }
        num = n;
        valSet = true;
        System.out.println("Set "+ num);
        notify();
    }

    public synchronized void getNum()
    {
        while(!valSet)
        {
            try{wait();} catch(Exception e){} 
        }
        System.out.println("Get "+ num);
        valSet = false;
        notify();
    }
}

class Producer implements Runnable
{
    Factory f;
    public Producer(Factory f)
    {
        this.f = f;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    public void run()
    {
        int i=0;
        while(true)
        {
            f.setNum(i++);
            
        }
    }
}
class Consumer implements Runnable
{
    Factory f;
    public Consumer(Factory f)
    {
        this.f = f;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }
    public void run()
    {
        while(true)
        {
            f.getNum();
            try{Thread.sleep(1000);} catch(Exception e){}
        }
    }
}

class ThreadCommunication1
{
    public static void main(String[] args) {
        Factory f = new Factory();
        new Producer(f);
        new Consumer(f);
    }
}
