package com.pixated.crm.generic.databaseUtility;
/**
 * This is used for store all database related reusable method
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class DataBaseUtility {
       Connection conn;
       /**
        * this method contain connect to database code
        * @param url
        * @param username
        * @param password
        * @throws Exception
        */
       public void getDbConnection(String url,String username,String password)throws Exception{
    	   try{
    		   conn=DriverManager.getConnection(url,username,password);
    	   }catch (Exception e) {
		}
    }
       /**
        * This method is for connect by hardcoding data
        * @throws Exception
        */
       public void getDbConnection()throws Exception{
    	   try{
    		   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
    	   }catch (Exception e) {
		}
    }
    /**
     * This method is for executing select query   
     * @param query
     * @return
     * @throws Exception
     */
   public ResultSet executeSelectQuery(String query)throws Exception{
	   ResultSet result =null;
	  try {
		  Statement stat=conn.createStatement();
		  result=stat.executeQuery(query);
	  }catch (Exception e) {
			}
	  return result;
   }
   /**
    * This method is for executing non select query
    * @param query
    * @return
    * @throws Exception
    */
   public int  executeNonSelectQuery(String query)throws Exception {
	int result=0;
	try {
		Statement stat=conn.createStatement();
		  result=stat.executeUpdate(query);
	} catch (Exception e) {
		}
	return result;
 }
   /**
    * This method is for close the database connection
    * @throws Exception
    */
   public void closeDbconnection()throws Exception{
	   try {
		
	} finally {
		conn.close();
	}
   }
   
}
