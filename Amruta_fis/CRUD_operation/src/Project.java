import java.util.*;

import java.sql.*;
public class Project {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int ch;
		do
		{
			int choice;
			
			System.out.println("************ WELCOME************");
			System.out.println("Select Menu:");
			System.out.println("1.INSERT");
			System.out.println("2.DELETE");
			System.out.println("3.SEARCH");
			System.out.println("4.UPDATE");
			System.out.println("5.SHOW");
			choice=sc.nextInt();
			//StudentService obj = new StudentService();
			switch(choice)
			{
			
				//Insert data
				case 1:
				{
					StudentService.insertStudentRecord();
				}
					
				break;
				
				//Delete data
				case 2:
				{
					StudentService.deleteStudentRecord();
				}
						
				break;	
				
				case 3:
				{
					StudentService.searchStudentRecord();
				}
					
					
				break;
				
				case 4:
				{
					StudentService.updateStudentRecord();
				}
					
					
				break;
				
				//Show data
				case 5:
				{
					StudentService.searchStudentRecord1();
						
					
				}	
				break;
				
				default:
					System.out.println("You have selected wrong Menu!!!!Try again!!!");
			}
			System.out.println("Do you want to continue?(1/0):  ");
			ch = sc.nextInt();
			
			
		}while(ch==1);

		  
	}

}
