/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodos;
import java.sql.*;
  
class UpdateCart{
    
    String tableName, q;
        Connection con;
    
    //CONSTRUCTOR               
    UpdateCart()
    {
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           String url = "jdbc:mysql://localhost:3306/fooddb";
           String username = "root";
           String password = "root";
           con = DriverManager.getConnection(url,username,password);
       }   
       catch(Exception e)
       {
           System.out.println(e+"#1");
       }
    }
    //Create order Table
    public void updateTable(int orderId, String itemName, int newQuantity)
    {
        try
        {
            tableName = "orderId" + orderId;

            if(newQuantity!=0){
            q = "UPDATE " + tableName + " SET quantity = ? WHERE itemName = ?";
            PreparedStatement updateStatement = con.prepareStatement(q);
            updateStatement.setInt(1, newQuantity);
            updateStatement.setString(2, itemName);
            updateStatement.executeUpdate();
            System.out.println("Table updated successfully: " + tableName);
            }
            else{
            q = "DELETE FROM " + tableName + " WHERE itemName = ?";
            PreparedStatement deleteStatement = con.prepareStatement(q);
            deleteStatement.setString(1, itemName);
            deleteStatement.executeUpdate();
            System.out.println("Table delete successfully: " + tableName);
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e + "#2");
        }

    }
    public void close()
    {
        try
        {
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e + "#3");
        }
    }   
}