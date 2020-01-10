import java.sql.*;

          /*Title:JDBC连接数据库*/
          /*Description:本实例演示如何使用JDBC连接Oracle数据库，并演示添加数据和查询数据*/

public class JDBCSTMConn {
       private static String url            = "";
       private static String username = "";
       private static String password  = "";     
            
       /*方法说明：获得数据连接*/  
       
       /*返回类型：Connection连接对象*/

       public Connection conn() {
            try {
                /*加载JDBC驱动*/
                Class.forName("oracle.jdbc.driver.OracleDriver");
                /*创建数据库连接*/
                Connection con = DriverManager.getConnection(url,username,password);
                return con;
            }catch(ClassNotFoundException cnf) {
                System.out.println("driver not found" + cnf);
                return null;
            }catch(SQLException sqle) {
                System.out.println("can't connection db:" + sqle);
                return null;
            }catch(Exception e) {
                System.out.println("Failed to load JDBC/ODBC driver.");
                return null;  
            }
       }

       /*方法说明：调用存储过程，查看数据结果*/  
       /*输入参数：Connection con数据库连接*/  
       /*输入参数：String sql要执行的SQL语句*/

       public void execute(Connection con) {
         CallableStatement toesUp = null;
         try {
            con.setAutoCommit(false);  
           /*调用存储过程*/
           toesUp= con.prepareCall("{call p_test(?)}");
           /*传递参数给存储过程*/
           toesUp.setInt(1,6);
           /*执行存储过程*/
           toesUp.executeQuery();

           Statement stmt = con.createStatement();
           Result rs = (ResultSet) stmt.executeQuery("SELECT * FROM TEST");
           While (rs.next()) {
                 String ID       = rs.getString(1);
                 String NAME     = rs.getString(2);
                 System.out.println(ID + "  " + NAME);
           }
           rs.close();
        } catch (SQLException e) {
        System.out.println(e);
        try {
        toesUp.close();
        con.close();
        }catch(Exception es) {System.out.println(es);}
       }
      }

      /*方法说明：实例演示*/

      public void demo() {
           try {
                 JDBCSTMConn oc = new JDBCSTMConn();
                 Connection conn = oc.conn();
                 oc.execute(conn);
                 conn.close();
           }catch(SQLException se) {
                System.out.println(se);
           }catch(Exception se) {
                System.out.println(e);
           }

      }

      /*方法说明：主方法*/

     public static void main(String[] args) {
           if (arg.length != 3) {
               System.out.println("use: java JDBCSTMConn url username password");
               return;
           }
            JDBCSTMConn oc = new JDBCSTMConn();
            oc.url            = arg[0];
            oc.username = arg[1];
            oc.password  = arg[2];
            oc.demo();
          }
      }












        
