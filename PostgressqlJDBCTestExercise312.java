import java.io.Console;
import java.sql.*;

/**
 * Class that executes our solutions for 3.12
 *
 * @author Brett Dale
 * @author Chris Brown
 * @version 1.0 (5/7/2021)
 */
class PostgresqlJDBCTestExercise312 {

   /**
    * Main method that executes solutions for Exercises 3.12
    * @param args command line arguments
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
                "select * from course " ); 
            System.out.println("\n3.12a Before Insert");
           System.out.println("Create a new course \"CS-001\", titled " +
                   "\"Weekly Seminar\", with one credit.");
           ResultSetMetaData rsetMeta = rset.getMetaData();
           String tName = rsetMeta.getTableName(1);
           System.out.println("Table name is: " + tName);
           System.out.println("course_id\ttitle\tdept_name\tcredits");
            while( rset.next( ) ) { 
                System.out.print( rset.getString( 1 ) + "\t"); 
                System.out.print( rset.getString( 2 ) + "\t"); 
                System.out.print( rset.getString( 3 ) + "\t"); 
                System.out.print( rset.getInt( 4 ) ); 
                System.out.print("\n");
            } 
            stmt.close(); 
            rset.close();

            PreparedStatement pstmt = 
                conn.prepareStatement(
                    "Insert into course values (?, ?, ?, ?)");
           pstmt.setString(1, "CS-001");
           pstmt.setString(2, "Weekly Seminar");
           pstmt.setString(3, "Comp. Sci.");
           pstmt.setInt(4, 1);
           pstmt.execute();
           pstmt.close();
           System.out.println("course_id\ttitle\tdept_name\tcredits");
           System.out.println("\n3.12a After Insert");
            stmt = conn.createStatement( ); 
            rset = stmt.executeQuery(
                "select * from course"); 
            while( rset.next( ) ) { 
                System.out.print( rset.getString( 1 ) + "\t"); 
                System.out.print( rset.getString( 2 ) + "\t"); 
                System.out.print( rset.getString( 3 ) + "\t"); 
                System.out.print( rset.getInt( 4 ) );
                System.out.print("\n"); 
            } 
            stmt.close(); 
            //rset.close()
            ;

            System.out.println("\n3.12b Before Insert");
            System.out.println("Create a new section of this course in Fall " +
                   "2009, with sec_id of 1.");
            
            stmt = conn.createStatement( ); 
            rset = stmt.executeQuery(
                "select * from section");
           rsetMeta = rset.getMetaData();
           tName = rsetMeta.getTableName(1);
           System.out.println("Table name is: " + tName);
           System.out.println("course_id-section-id\tsemester\tyear\tbuilding" +
                   "\troom_number\ttime_slot_id");
            while( rset.next( ) ) { 
                System.out.print( rset.getString( 1 ) + "\t"); 
                System.out.print( rset.getString( 2 ) + "\t"); 
                System.out.print( rset.getString( 3 ) + "\t"); 
                System.out.print( rset.getInt( 4 ) + "\t" );
                System.out.print( rset.getString( 5 ) + "\t" );
                System.out.print( rset.getString( 6 ) + "\t" );
                System.out.print( rset.getString( 7 ));
                System.out.print("\n");
            } 
            stmt.close(); 
            rset.close();
           
            pstmt = conn.prepareStatement("insert into section values (?, ?, ?, ?)");
            pstmt.setString(1, "CS-001");
            pstmt.setString(2, "1");
            pstmt.setString(3, "Fall");
            pstmt.setInt(4, 2009);
            pstmt.execute();
            pstmt.close();
            
            System.out.println("\n3.12b After Insert");
            stmt = conn.createStatement( ); 
            rset = stmt.executeQuery(
                "select * from section");
            System.out.println("course_id-section-id\tsemester\tyear" +
                    "\tbuilding" +
                   "\troom_number\ttime_slot_id");
            while( rset.next( ) ) { 
                System.out.print( rset.getString( 1 ) + "\t"); 
                System.out.print( rset.getString( 2 ) + "\t"); 
                System.out.print( rset.getString( 3 ) + "\t"); 
                System.out.print( rset.getInt( 4 ) + "\t" );
                System.out.print( rset.getString( 5 ) + "\t" );
                System.out.print( rset.getString( 6 ) + "\t" );
                System.out.print( rset.getString( 7 ));
                System.out.print("\n"); 
 
            } 
            stmt.close(); 
            rset.close();


            System.out.println("\n3.12c Before Insert");
           System.out.println("Enroll every student in the Comp. Sci. " +
                   "department in the above section");
            stmt = conn.createStatement( ); 
            rset = stmt.executeQuery(
                "select * from takes");
           rsetMeta = rset.getMetaData();
           tName = rsetMeta.getTableName(1);
           System.out.println("Table name is: " + tName);
           System.out.println("ID\tcourse_id\tsec_id\tsemester\tyear\tgrade\t");
            while( rset.next( ) ) { 
                System.out.print( rset.getString( 1 ) + "\t"); 
                System.out.print( rset.getString( 2 ) + "\t"); 
                System.out.print( rset.getString( 3 ) + "\t"); 
                System.out.print( rset.getString( 4 ) + "\t" );
                System.out.print( rset.getInt( 5 ) + "\t" );
                System.out.print( rset.getString( 6 ) + "\t" );
                System.out.print("\n"); 
            } 
           stmt.close(); 
           rset.close();

                        
           System.out.println("\n3.12c After Insert");
           Statement stmt2 = conn.createStatement( ); 
                     int rowsAdd = stmt2.executeUpdate("INSERT INTO takes(ID,course_id, sec_id, semester, year)" +
           " SELECT ID, 'CS-001', '1', 'Fall', 2009 FROM student WHERE dept_name = 'Comp. Sci.'");  
            ResultSet rset2 = stmt2.executeQuery(
                "select * from takes");
           System.out.println("ID\tcourse_id\tsec_id\tsemester\tyear\tgrade\t");
           while( rset2.next( ) ) { 
               System.out.print( rset2.getString( 1 ) + "\t"); 
               System.out.print( rset2.getString( 2 ) + "\t"); 
               System.out.print( rset2.getString( 3 ) + "\t"); 
               System.out.print( rset2.getString( 4 ) + "\t" );
               System.out.print( rset2.getInt( 5 ) + "\t" );
               System.out.print( rset2.getString( 6 ) + "\t" );
               System.out.print("\n"); 
           } 
           stmt2.close(); 
           rset2.close();
        
            System.out.println("\n3.12d Before Insert");
           System.out.println("Delete enrollments in the above section where" +
                   " " +
                   "the student's name is Chavez");
            stmt = conn.createStatement( ); 
            rset = stmt.executeQuery(
                "select * from takes");
            rsetMeta = rset.getMetaData();
            tName = rsetMeta.getTableName(1);
            System.out.println("Table name is: " + tName);
           System.out.println("ID\tcourse_id\tsec_id\tsemester\tyear\tgrade\t");
           while( rset.next( ) ) {
                System.out.print( rset.getString( 1 ) + "\t"); 
                System.out.print( rset.getString( 2 ) + "\t"); 
                System.out.print( rset.getString( 3 ) + "\t"); 
                System.out.print( rset.getString( 4 ) + "\t" );
                System.out.print( rset.getInt( 5 ) + "\t" );
                System.out.print( rset.getString( 6 ) + "\t" );
                System.out.print("\n"); 
            } 
           stmt.close(); 
           rset.close();

                        
           System.out.println("\n3.12d After Insert");
           stmt2 = conn.createStatement( ); 
                     rowsAdd = stmt2.executeUpdate("DELETE FROM takes" + 
                        " WHERE (course_id = 'CS-001') AND (sec_id = '1') AND" +
                        " (semester = 'Fall') AND (year = 2009) AND" +
                        " (ID IN ( SELECT ID FROM student WHERE name = 'Chavez'))" );  
            rset2 = stmt2.executeQuery(
                "select * from takes");
           System.out.println("ID\tcourse_id\tsec_id\tsemester\tyear\tgrade\t");
           while( rset2.next( ) ) { 
               System.out.print( rset2.getString( 1 ) + "\t"); 
               System.out.print( rset2.getString( 2 ) + "\t"); 
               System.out.print( rset2.getString( 3 ) + "\t"); 
               System.out.print( rset2.getString( 4 ) + "\t" );
               System.out.print( rset2.getInt( 5 ) + "\t" );
               System.out.print( rset2.getString( 6 ) + "\t" );
               System.out.print("\n"); 
           } 
           stmt2.close(); 
           rset2.close();

        } catch (SQLException e) { 
           System.out.println("Exception: " + e.toString()); 
           System.exit(0); 
       }
   } // end of main 
   }
