package foodos;
import java.sql.*;
  
class FetchCartAdmin{
	
	String q;
	Connection con;
	static int c;
	static String[] itemName;
	static int []itemNo; 
        static int quantity[], price[];
        ResultSet set;
	
    //CONSTRUCTOR               
    FetchCartAdmin()
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
	
public int getTotalItems(int tableName)
{
    try
    {
        q = "select * from orderid"+tableName; // add space after "from"
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

public void fetchCartDetails(int tableName)
{
    try
    {
        int i = 0;
        itemNo = new int[c];
        quantity = new int[c];
        price = new int[c];
        itemName =new String[c];
        q = "select * from orderid"+tableName; // add space after "from"
        Statement stmt = con.createStatement();
        set = stmt.executeQuery(q);
        while(set.next())
        {
            itemNo[i] = set.getInt(1);
            itemName[i] = set.getString(2);
            quantity[i] = set.getInt(3);
            price[i] = set.getInt(4);
            i++;
        }
        for(i=0;i<c;i++)
        {
            System.out.println(""+itemNo[i]+" "+itemName[i]+" "+quantity[i]+" "+price[i]);
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
