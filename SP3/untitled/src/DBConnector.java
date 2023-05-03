import java.sql.*;

public class DBConnector {

    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/sp3";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "16Jan1983.";



    public void readData() {

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT ID FROM sp3.film";
            String sql1 = "SELECT Name FROM sp3.film";
            String sql2 = "SELECT Year FROM sp3.film";
            String sql3 = "SELECT Categories FROM sp3.film";
            String sql4 = "SELECT Rating FROM sp3.film";
            String sql5 = "SELECT * FROM sp3.film";  /// Den her måde kan læse alle kolonner kaldt "Full List"


            stmt = conn.prepareStatement(sql);
            stmt = conn.prepareStatement(sql1);
            stmt = conn.prepareStatement(sql2);
            stmt = conn.prepareStatement(sql3);
            stmt = conn.prepareStatement(sql4);
            stmt = conn.prepareStatement(sql5); /// Til alle kolonner


            ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs1 = stmt.executeQuery(sql1);
            ResultSet rs2 = stmt.executeQuery(sql2);
            ResultSet rs3 = stmt.executeQuery(sql3);
            ResultSet rs4 = stmt.executeQuery(sql4);
            ResultSet rs5 = stmt.executeQuery(sql5); /// Til alle kolonner

            //STEP 4: Extract data from result set
            while(rs.next()){
                //Retrieve by column ID

                String ID = rs.getString("ID");
                // int population = rs.getInt("");
                System.out.println(ID);
            }
            while(rs1.next()){
                //Retrieve by column Name

                String name = rs.getString("Name");
                // int population = rs.getInt("");
                System.out.println(name);
            }
            while(rs2.next()){
                //Retrieve by column Year

                String year = rs.getString("Year");
                // int population = rs.getInt("");
                System.out.println(year);
            }
            while(rs3.next()){
                //Retrieve by column Categories

                String categories = rs.getString("Categories");
                // int population = rs.getInt("");
                System.out.println(categories);
            }
            while(rs4.next()){
                //Retrieve by column Rate

                String rate = rs.getString("Rate");
                // int population = rs.getInt("");
                System.out.println(rate);
            }
            while(rs5.next()){
                //Retrieve all columns

                String fullList = rs.getString("Full List");
                // int population = rs.getInt("");
                System.out.println(fullList);
            }



            //STEP 5: Clean-up environment
            rs.close();
            rs1.close();
            rs2.close();
            rs3.close();
            rs4.close();
            rs5.close();

            stmt.close();
            conn.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try



    }

    /*

    public int readPopulation(String city) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT population FROM world.city WHERE name = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, city);

            ResultSet rs = stmt.executeQuery();

            //STEP 4: Extract data from result set
            while(rs.next()){
                //Retrieve by column name

                return rs.getInt("Population");


            }
            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return 0;


    }

     */
}