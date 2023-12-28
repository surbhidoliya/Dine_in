package foodos;
import java.sql.*;
  
class CartTable{
	
	String tableName, q;
        Connection con;
	
    //CONSTRUCTOR               
    CartTable()
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
    public String createTable(int orderId)
	{
		try
		{
			tableName = "orderId" + orderId;
		    q = "create table "+tableName+"(itemNo int(20) primary key auto_increment, itemName varchar(200) not null, quantity int(20) not null, price int(20) not null)";
		
		    Statement stmt = con.createStatement();
		    stmt.executeUpdate(q);
		    System.out.println("Table created successfully: " + tableName);
		}
		catch(Exception e)
		{
			System.out.println(e + "#2");
		}
		finally
		{
			return tableName;
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