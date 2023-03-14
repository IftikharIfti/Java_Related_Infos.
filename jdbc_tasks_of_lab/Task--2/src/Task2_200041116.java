import java.sql.*;  
class Task3_200041116 {
    public static void main(String args[]) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "USER1116";
        String password = "iutcse";
        String query = "SELECT * FROM TRANSACTIONS";


        try {
            // step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // step2 create the connection object
            Connection con = DriverManager.getConnection(url, username, password);

            // step3 create the statement object
            Statement statement = con.createStatement();
            System.out.println("Connection to the Database established succesfully!");

            // step4 execute query

            ResultSet result = statement.executeQuery(query);
            PreparedStatement pStmt = con . prepareStatement (
 " INSERT INTO TRANSACTIONS VALUES(?, TO_DATE(?,'yyyy/mm/dd'), ?, ?, ?)") ;
 pStmt . setInt (1 , 130000) ;
 pStmt . setString (2 , " 2003/02/02") ;
 pStmt . setInt (3 , 78) ;
 pStmt . setInt (4 , 1242244) ;
 pStmt . setInt (5 , 0) ;
 pStmt . executeUpdate () ;


            
            // step5 close the connection object
            result.close();
            con.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

