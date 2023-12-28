package foodos;
import java.sql.*;


public class connReg {
     //CONSTRUCTOR 
    Connection con;
    int orderId;
    String n;
    connReg()
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
	//METHOD TO INSERT DATA IN VARIABLE
    public void insert(String name, String contact, int tableNo)
	{
	   
           try
           {
               if (name != null && !name.isEmpty() && contact != null && !contact.isEmpty() && tableNo > 0)
           {
               String q = "INSERT INTO login1 (name, tableNo, contactNo) VALUES (?, ?, ?)";
               PreparedStatement stmt = con.prepareStatement(q);
               stmt.setString(1, name);
               stmt.setInt(2, tableNo);
               stmt.setString(3, contact);
               
               int rowsAffected = stmt.executeUpdate();
               stmt.close();
           }
           }
           catch(Exception e)
	   {
	       System.out.println(e+"2");
	   }
	}
	
	//To fetch data
	public int getOrderId(String name)
	{
		try
                {
                    String q = "select * from login1 where name = name ";
		 	
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(q);
			
		while(set.next())
		orderId = set.getInt(1);
		
		
                }
            catch(Exception e)
	   {
	       System.out.println(e+"4");
	   }
                return orderId;
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