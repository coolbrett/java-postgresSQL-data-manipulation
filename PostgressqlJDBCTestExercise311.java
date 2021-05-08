import java.io.Console;
import java.sql.*;

/**
 * Class that contains our solutions for exercises 3.11
 *
 * @author Brett Dale
 * @author Chris Brown
 * @version 1.0 (5/7/2021
 */
class PostgresqlJDBCTestExercise311 {

   /**
    * Main method that gives solutions for exercises in 3.11
    * @param args command line args
    */
    public static void main( String args[] ) { 
       try {
            Class.forName(
                "org.postgresql.Driver").newInstance(); 
            } catch (Exception e) { 
            System.out.println("Exception: " + e.toString()); 
            System.exit(0); 
            }

            Console userEntry = System.console();
            System.out.println("Please enter your username: ");
            String username = userEntry.readLine();
            System.out.println("Please enter your password: ");
            String password = new String(userEntry.readPassword());
            String serverIp = "localhost:5435";
            System.out.println("Please enter the database name: ");
            String databasename = userEntry.readLine();
            Connection conn = null; 
            Statement stmt = null; 
            ResultSet rset = null;
            String cs = "jdbc:postgresql://" +
            serverIp + "/" + databasename + "?user=" + username 
            + "&password=" + password; 
        try { 
            conn = DriverManager.getConnection(cs); 
            stmt = conn.createStatement( ); 
            rset = stmt.executeQuery(
                "select * from student");
            while( rset.next( ) ) { 
                System.out.print( rset.getString( 1 ) + "\t"); 
                System.out.print( rset.getString( 2 ) + "\t"); 
                System.out.print( rset.getString( 3 ) + "\t"); 
                System.out.println( rset.getDouble( 4 ) ); 
            } 
            stmt.close(); 
            rset.close(); 
            stmt = conn.createStatement( ); 
            rset = stmt.executeQuery(
                "SELECT DISTINCT(name) FROM student NATURAL JOIN" + 
                    " takes NATURAL JOIN course WHERE dept_name = 'Comp. Sci.'"); 
            System.out.println("3.11a");
            System.out.println("Find the names of all students who have taken" +
                    " at least one Comp. Sci. course; make sure there are no " +
                    "duplicate names in the result.");
            ResultSetMetaData rsetMeta = rset.getMetaData();
            String tName = rsetMeta.getTableName(1);
            System.out.println("Table name is: " + tName);
            System.out.println("\nName");
            while( rset.next( ) ) { 
                System.out.print( rset.getString( 1 ) + "\n"); 
            } 
            stmt.close(); 
            rset.close();
            stmt = conn.createStatement();
            rset = stmt.executeQuery(
                "(SELECT ID, name FROM student NATURAL JOIN takes) EXCEPT" +
                " (SELECT ID, name FROM student NATURAL JOIN takes WHERE year < 2009)"); 
            System.out.print("\n3.11b.\n");
           System.out.println("Find the ID's and names of all students who " +
                   "have not taken any course offering before Spring 2009.");
           rsetMeta = rset.getMetaData();
           tName = rsetMeta.getTableName(1);
           System.out.println("Table name is: " + tName);
            System.out.print("ID\tName\n");
            while( rset.next( ) ) { 
                System.out.print( rset.getString( 1 ) + "\t"); 
                System.out.print( rset.getString( 2 ) + "\t");
                System.out.print( "\n");  
            }
            stmt.close();
            rset.close();
        } catch (SQLException e) { 
            System.out.println("Exception: " + e.toString()); 
            System.exit(0); 
        }
    } // end of main 
}
