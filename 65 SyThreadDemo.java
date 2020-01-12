      /*Title:线程同步*/
      /*Description:通过使用同步锁实现对共享数据的操作*/



      /*类说明：主程序*/
      /*功能描述：构造两个线程，并启动他们*/

public class SyThreadDemo
{
  public static void main(String[] args)
  {
     trade ft = new trade();
     addThread tt1 = new addThread(ft, "add");
     addThread tt2 = new addThread(ft, "dec");
     tt1.start();
     tt2.start();
  }
}


/*类说明：同步类*/
/*功能描述：保存共享数据*/

class trade
{
   private String transName;
   private double amount;
 
   /*方法说明：更新数据*/
   /*输入参数：String transName操作名称*/
   /*输入参数：doubt amount资金数量*/

synchronized void update(String transName, double amount)
{
   this.transName = transName;
   this.amount = amount;
   System.out.println(this.transName + "  " + this.amount);
}
}

/*类说明：添加资金*/
/*功能描述：单线程，调用trade.update()方法。修改数据*/

class addThread extends Thread
{
   private trade ft ;
   addThread(trade ft, String name)
   {
     super(name);
     this.ft = ft;
    }
    public void run()
    {
        for (int i = 0; i < 10; i++)
          ft.update("add", 2000.0);
    }
}

/*类说明：减少资金*/
/*功能描述：单线程，调用trade.update()方法。修改数据*/
class decThread extends Thread
{
   private trade fd ;
   decThread(trade fd, String name)
   {
     super(name);
     this.fd = fd;
    }

    /*方法说明：线程主体*/
    public void run()
    {
        for (int i = 0; i < 10; i++)
          fd.update("dec", 2000.0);
    }
}



   




