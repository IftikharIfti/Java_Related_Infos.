import java.sql.*;  
class Task_1 {
    public static void main(String args[]) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "USER1116";
        String password = "iutcse";
        String query = "SELECT * FROM TRANSACTIONS";

        int [] balance = new int [1000000];
        int [] total = new int [1000000];
        int [] present = new int [1000000];
        int account ;
        int amount ;
        int type ;
        int cip = 0, vip = 0, ordinary = 0, uncategorized = 0;

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
            while(result.next())
            {
                account = result.getInt("a_id");
                amount = result.getInt("amount");
                type = result.getInt("type");
                System.out.println(account + " " + amount + " " + type);
                total[account] += amount;
                if(type == 1)
                    balance[account] -= amount;
                else
                    balance[amount] += amount;
                
                
                present[account] = 1;
            }

            for (int i=0 ; i<1000 ; i++)
            {
                if(present[i] == 1)
                {
                    if ((balance[i] > 1000000) && (total[i] > 5000000))
                        cip++;
                    else if (balance[i] > 500000 && balance[i] < 900000 && total[i] > 3500000 && total[i] < 4500000)
                        vip++;
                    else if(balance[i] < 40000 && total[i] < 3000000)
                        ordinary++;
                    else
                        uncategorized++;
                }   
            }


            
            System.out.println("Total: " + (cip + vip + ordinary + uncategorized));
            System.out.println("CIP: " + cip);
            System.out.println("VIP: " + vip);
            System.out.println("Ordinary: " + ordinary);
            System.out.println("Uncategorized: " + uncategorized);
            
            // step5 close the connection object
            result.close();
            con.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

