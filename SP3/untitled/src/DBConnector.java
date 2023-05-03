import javax.xml.namespace.QName;
import java.sql.*;
import java.util.List;

public class DBConnector {

    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/sp3";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "G5no394E!";


    public void readData() {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT id, name, catagories FROM sp3.film ";

            stmt = conn.prepareStatement(sql);


            ResultSet rs = stmt.executeQuery();


            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                String id = rs.getString("Id");
                String name = rs.getString("Name");
                String catagories = rs.getString("Catagories");
                System.out.println(id + " " + name + " " + catagories);

            }
            //STEP 5: Clean-up environment
            rs.close();

            stmt.close();

            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }



    /*
    public void readId(String film) {

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
            String sql = "SELECT id FROM sp3.film";
            stmt = conn.prepareStatement(sql);



            ResultSet rs = stmt.executeQuery();

            //STEP 4: Extract data from result set
            while(rs.next()){
                //Retrieve by column name

                String id = rs.getString( "ID");
                System.out.println(id);

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



    }*/
    }
