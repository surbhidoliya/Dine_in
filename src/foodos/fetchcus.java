package foodos;
import java.sql.*;
  
class fetchcus{
	
	String q;
	Connection con;
	int c;
        ResultSet set;
	
    //CONSTRUCTOR               
    fetchcus()
    {
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           String url = "jdbc:mysql://localhost:3306/fooddb";
           String username = "root";
           String password = "root";
           con = DriverManager.getConnection(url,username,password);
		   c = 0;
       }   
       catch(Exception e)
	   {
	       System.out.println(e+"1");
	   }
    }
	
public int getCus()
{
    try
    {
        q = "select * from login1"; // add space after "from"
        Statement stmt = con.createStatement();
        set = stmt.executeQuery(q);
        while(set.next())
        {
            c++;
        }
    }
    catch(Exception e)
    {
        System.out.println(e+"4");
    }
    return c;                
}

public void fetchCustomer()
{
    try
    {
        int i = 0;
        customer.tableNo= new int[c];
        customer.orderId = new int[c];
        customer.Name =new String[c];
        customer.contact=new String[c];
        q = "select * from login1"; // add space after "from"
        Statement stmt = con.createStatement();
        set = stmt.executeQuery(q);
        while(set.next())
        {
            customer.orderId[i] = set.getInt(1);
            customer.Name[i] = set.getString(2);
            customer.tableNo[i] = set.getInt(3);
            customer.contact[i] = set.getString(4);
            i++;
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
