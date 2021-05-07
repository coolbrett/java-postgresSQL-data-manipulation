import java.sql.*;
class PostgresqlJDBCTestExercise312 { 
    public static void main( String args[] ) { 
            try { 
            Class.forName(
                "org.postgresql.Driver").newInstance(); 
            } catch (Exception e) { 
            System.out.println("Exception: " + e.toString()); 
            System.exit(0); 
            }
        // CHANGE THESE ENTRIES TO SUIT YOUR INSTALLATION 
            String serverIp = "localhost:5435"; 
            String databasename = "badale2";
            // you need to change this (mh) 
            String username = "badale2";
            // you need to change this (mh) 
            String password = "chris";
            // you need to change this (mh) 
            String tablename = "studen"; // Make sure this table exists
                                            // in your database
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
            
            stmt = conn.createStatement( ); 
            rset = stmt.executeQuery(
                "select * from section"); 
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
            stmt = conn.createStatement( ); 
            rset = stmt.executeQuery(
                "select * from takes"); 
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
            stmt = conn.createStatement( ); 
            rset = stmt.executeQuery(
                "select * from takes"); 
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
