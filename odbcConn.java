import java.sql.*;

        /*Title:ODBC连接数据库*/
        /*Description:本实例演示如何使用JDBC-ODBC桥操作数据库*/
 

public class odbcConn{
       private String url      = "";
       private String username = "";
       private String password = "";

       /*方法说明：获得数据连接*/
       /*返回类型：Connection连接对象*/
         
       public Connection conn() {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection(url,username,password);
                return con;
            }catch(SQLException sqle) {
                System.out.println("can't connection db:" + sqle);
                return null;
            }catch(Exception e) {
                System.out.println("Failed to load JDBC/ODBC driver.");
                return null;
            }
       }

       /*方法说明：执行查询SQL语句*/
       /*输入参数：Connection con数据库连接*/
       /*输入参数：String sql要执行的SQL语句*/

       public void query(Connection con, String sql) {
            try {
               if (con==null) return;
               Statement stmt                = con.createStatement();
               ResultSet   rs                    = stmt.executeQuery(sql);
               ResultSetMetaData rmeta = rs.getMetaData();
               int numColumns               = rmeta.getColumnCount();
               while (rs.next())
               {
                  for (int i = 0; i <numColumns; i++)
                  {
                    String sTemp = rs.getString(i+1);
                    System.out.print(sTemp + "");
                  }
               System.out.println("");
               }
            }catch(Exception e) {
               System.out.println("query error:" + e);
            }finally{
               try{
                con.close();
             }catch(SQLException se) {}
            }
         }
       

       /*方法说明：执行插入、更新、删除等没有返回结果集的SQL语句*/
       /*输入参数：Connection con数据库连接*/
       /*输入参数：String sql要执行的sql语句*/

       public void execute(Connection con, String sql) {
            try{
               if(con==null) return;
               Statement stmt = con.createStatement();
               stmt.executeUpdate(sql);

            }catch(Exception e) {
               System.out.println("query error:" +e);
            }finally{
               try{
                 con.close();
               }catch(SQLException se) {}
            }
         }
        
         /*方法说明：主方法*/

         public static void main(String[] arg) {
              if(arg.length != 3) {
                   System.out.println("use: java odbcConn url username password");
                   return;
              }
              odbcConn oc = new odbcConn();
              oc.url = arg[0];
              oc.username = arg[1];
              oc.password  = arg[2];
              oc.execute(oc.conn(), "insert into userinfo(name,address)values('switch','new york')");
              oc.query(oc.conn(), "select * from userinfo");
          }
}
         


         
             


 
