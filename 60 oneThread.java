        /*Title: 继承Thread，实现线程*/
        /*Description:通过继承Thread类，实现其run方法，实现自己的线程*/

public class oneThread extends Thread {
        
        /*方法说明：构造器，本类没有使用*/

public oneThread() {
     
       }

       /*方法说明：继承Thread类必须实现的方法，当调用start方法时运行本方法*/
 
       public void run() {
           System.out.println("................oneThread begining................");
           int flag = 0;
           while (true) {
                if (flag ==20) {
                    System.out.println("\n................oneThread end................");
                }
                for (int i = 0; i < flag; i++)
                        System.out.println("*");
                System.out.println("");
                flag++;
           try{
             /*睡眠0.1秒*/
             sleep(100);
            }catch(Exception e) {
            }
          }
         }

         /*方法说明：主方法，启动本线程*/
 
         public static void main(String args[]) {
               new oneThread().start();
         }
}
