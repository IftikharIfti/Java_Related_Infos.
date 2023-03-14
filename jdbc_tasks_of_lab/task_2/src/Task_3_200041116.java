import java.sql.*;  
class App {
    public static void main(String args[]) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "USER1116";
        String password = "iutcse";
        String query = "SELECT * FROM TRANSACTIONS";
        String query2="SELECT * FROM ACCOUNT";

        try {
            // step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // step2 create the connection object
            Connection con = DriverManager.getConnection(url, username, password);

            // step3 create the statement object
            Statement statement = con.createStatement();
            System.out.println("Connection to the Database established succesfully!");

            // step4 execute query
            System.out.println("Info for Transactions\n");
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs . getMetaData () ;
             for (int i = 1; i <= rsmd . getColumnCount () ; i ++) {
             System . out . println ( rsmd . getColumnName ( i ) ) ;
             System . out . println ( rsmd . getColumnTypeName ( i ) ) ;
             }
                         
            System.out.println("Total number of columns: " + rsmd.getColumnCount());
            rs.close();            
            statement.close();
            Statement statement1 = con.createStatement();
           // System.out.println("Connection to the Database established succesfully!");

            // step4 execute query
            System.out.println("Info for ACCOUNT\n");
            ResultSet rs1 = statement1.executeQuery(query2);
            ResultSetMetaData rsmd1 = rs1 . getMetaData () ;
             for (int i = 1; i <= rsmd1 . getColumnCount () ; i ++) {
             System . out . println ( rsmd1 . getColumnName ( i ) ) ;
             System . out . println ( rsmd1 . getColumnTypeName ( i ) ) ;
             }


            
            System.out.println("Total number of columns: " + rsmd1.getColumnCount());
           
            // step5 close the connection object
          
            rs1.close();
            con.close();
            statement1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


