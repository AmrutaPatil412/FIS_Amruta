import java.util.*;

import java.sql.*;


public class StudentService {
	
	public static void insertStudentRecord() throws ClassNotFoundException, SQLException
	{
		
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstat =null;
		ResultSet rs=null;
		//write code for inserting record
		int id,m1,m2;
		String name;
		System.out.println("Enter Id: ");
		id=sc.nextInt();
		System.out.println("Enter name of student: ");
		name=sc.next();
		System.out.println("Enter Marks for English: ");
		m1=sc.nextInt();
		System.out.println("Enter Marks for Maths: ");
		m2=sc.nextInt();
		String sql="insert into Student"+"(Stud_Id,Stud_name,Mark1,Mark2)"+"values(?,?,?,?)";
		pstat = con.prepareStatement(sql);
		pstat.setInt(1,id);
		pstat.setString(2, name);
		pstat.setInt(3, m1);
		pstat.setInt(4, m2);
		int isInserted = pstat.executeUpdate();
		if(isInserted==1)
		{
			System.out.println("Data is inserted successfully!!");
		}
		
	}
	
	public static void deleteStudentRecord() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Amruta","root", "rps@12345");
	
		PreparedStatement pstat =null;
		ResultSet rs=null;
		int id;
		System.out.println("Enter Id: ");
		id=sc.nextInt();
		String sql = "delete from Student where Stud_id=?";
		pstat = con.prepareStatement(sql);
		pstat.setInt(1, id);
		int isDelted = pstat.executeUpdate();
		if(isDelted == 1)
			System.out.println("Record Deleted Succesfully!!");
	}
	
	public static void searchStudentRecord() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Amruta","root", "rps@12345");
	
		PreparedStatement pstat =null;
		ResultSet rs=null;
		int id;
		System.out.println("Enter Id: ");
		id=sc.nextInt();
		String sql = "select * from Student where Stud_id=?";
		pstat = con.prepareStatement(sql);
		pstat.setInt(1, id);
		rs=pstat.executeQuery();  
		while(rs.next())  
		{
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4));  
		}
	}
	
	public static void updateStudentRecord() throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Amruta","root", "rps@12345");
	
		PreparedStatement pstat =null;
		ResultSet rs=null;
		int id;
		String upadted_name;
		System.out.println("Enter Id: ");
		id=sc.nextInt();
		System.out.println("Enter new Name: ");
		upadted_name = sc.next();
		
		String sql = "update Student set Stud_name=? where Stud_id=?";
		pstat = con.prepareStatement(sql);
		
		pstat.setString(1, upadted_name);
		pstat.setInt(2, id);
		int isUpdated = pstat.executeUpdate();
		if(isUpdated == 1)
			System.out.println("Record Updated Succesfully!!");
	}
	
	public static void searchStudentRecord1() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Amruta","root", "rps@12345");
	
		PreparedStatement pstat =null;
		ResultSet rs=null;
		Statement stmt=con.createStatement();  
		rs=stmt.executeQuery("select * from Student");  
		while(rs.next())  
		{
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4));  
		}
	}
}
