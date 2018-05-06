package Connection;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Siddharth
 */
public class conn {
    private static Connection con;
    public static Connection getCon(){
            try{
                System.out.println("Before Connection");
                Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/major_3?zeroDateTimeBehavior=convertToNull","root","");
                System.out.println("After Connection");
        }catch(Exception e){
            System.out.println("Database Connectivity Exception: "+e);
                System.out.println("Not connected");
        }
        return con;
    }
}
