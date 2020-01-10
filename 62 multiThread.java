       /*Title:创建多线程*/
       /*Description:使用构造器，创建多线程*/



public class multiThread
{

      /*方法说明：主方法*/

     public static void main(String[] args) {  
         new multiThread();
     }

     /*方法说明：构造器，构造多个线程，并启动他们*/

     multiThread() {
              for (int i = 0; i < 5; i++) {
                  System.out.println("Creating thread" + i);
                  innThread mt = new innThread(i);
                  mt.start();
               }
     }

     /*类说明：内部通过继承Thread实现线程*/
     /*类描述：通过构造器参数，区别不同线程*/

     class innThread extends Thread
     {
       int count;
       innThread(int i){
            count = i;
       }
       
       /*方法说明：内部类线程主题，继承Thread必须实现的方法*/

       public void run()
       {
           System.out.println("now" + count + "thread is begining........" );
           try{
               sleep(10-count);
           }catch(Exception e) {
               System.out.println(e);
           } 
           System.out.println("\n" + count + "thread is end!");
        }
       }
}
