import java.sql.*;
class PostgresqlJDBCTestExercise311 { 
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
            String tablename = "student"; // Make sure this table exists
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
                "select * from " + tablename ); 
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
