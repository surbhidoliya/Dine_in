package foodos;
import java.sql.*;
  
class ConnCart{
	
	String q;
	Connection con;
	
    //CONSTRUCTOR               
    ConnCart()
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
	       System.out.println(e+"1");
	   }
    }
	
	public void insert(String tableName, String itemName, int quantity, int price)
	{
		try
		{
		   if(itemName != null && !itemName.isEmpty())
		   {
			q = "insert "+tableName+"(itemName, quantity, price) values (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, itemName);
			pstmt.setInt(2, quantity);
			pstmt.setInt(3, price);
			int rowsAffected = pstmt.executeUpdate();
                        pstmt.close();
		   }
		}
		catch(Exception e)
		{
			System.out.println(e+"2");
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
			System.out.println(e+"3");
		}
	}
}