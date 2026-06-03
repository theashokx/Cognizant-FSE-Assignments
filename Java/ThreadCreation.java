import java.util.*;

class MyThread extends Thread
{
    String msg;
    MyThread(String s)
    {
        this.msg=s;
    }
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println("Message : "+msg);
        }
        
    }
}
class ThreadCreation
{
    public static void main(String args[])
    {
        MyThread t1=new MyThread("Thread-1: Running");
        MyThread t2=new MyThread("Thread-2: Running");

        t1.start();
        t2.start();
    }
}