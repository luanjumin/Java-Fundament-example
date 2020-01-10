          /*Title:实现Runnable接口，获得线程*/
          /*Description:通过实现Runnable接口来获得自己的线程*/


public class twothread implements Runnable {
          /*方法说明：构造器，实现线程，并启动这个线程*/

   twothread() {
          /*获取当前线程*/
          Thread t1= Thread.currentThread();
          t1.setName("The first main thread");
          System.out.println("The running thread:" + t1);

          /*通过将本类(Runnable接口)和名称构造一个线程*/
          Thread t2= newThread(this, "the second thread");
          System.out.println("create another thread");

          /*启动线程*/
          t2.start();
          try {
               System.out.println("first thread will sleep");
               Thread.sleep(3000);
          }catch (InterruptedException e) {
               System.out.println("first thread has wrong");
          }
          System.out.println("first thread exit");
   }

   /*方法说明：线程主体，实现run方法*/

   public void run() {
         try {
             for (int i = 0; i < 5; i++) {
                 System.out.println("Sleep time for thread2:" +i);
                 Thread.sleep(1000);
             }
    } catch (InterruptedException e) {
      System.out.println("thread has wrong");
    }

     /*方法说明：主方法*/
    public static void main(String args[]) {
          new twothread();
    }
   }
           
