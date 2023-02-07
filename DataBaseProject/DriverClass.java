package Bus;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

/*  connection ,try,and catch are used in class*/
/*give the userName and password of MySql to connect the database to eclipse*/
public class DriverClass {
	static Connection connection=null;
	static Connection createConnection() {

		try {
			String userName="root";
			String passWord="root";
			Class.forName("com.mysql.jdbc.Driver");
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/BusInfo",userName,passWord);

		}
		catch(Exception object) {
			System.out.println(object);
		}
		return connection;
	}

	/*to create object of the class busDetails and DataBaseBus*/
	/* using scanner get the input from the scanner to 
	  /*to insert
	  /*to display
	 * to search
	 * to update
	 * to delete
	 */
	public static void main(String args[]) throws Exception{
		BusDetails busObject= new BusDetails();
		DataBaseBus bus=new DataBaseBus();
		Connection connect =createConnection();
		Scanner scan=new Scanner(System.in);
		System.out.println("**WELCOME TO REDBUS**");
		System.out.println("Enter 1 to insert Bus Information");
		System.out.println("Enter 2 to display Bus Information");
		System.out.println("Enter 3 to Search Bus Information");
		System.out.println("Enter 4 to Update Bus Information");
		System.out.println("Enter 5 For Delete Bus Information");
		System.out.println("Enter 6 for Logout Bus Information");

		byte userInput;
		do {
			userInput=scan.nextByte();

			/* method calling using object Name*/
			switch(userInput) {
			case 1: 
				bus.toInsertBusInfo(connect);
				break;

			case 2:
				bus.toDisplayBusInfo(connect);
				break;
			case 3:
				bus.toSearchBusInfo(connect);
				break;
			case 4:

				bus.toUpdateBusInfo(connect);
				bus.toDisplayBusInfo(connect);
				break;
			case 5:
				bus.toDeleteBusInfo(connect);
				break;
			case 6:
				BusDetails.tologout();
				connection.close();
				scan.close();
				break;
			}
		}while(userInput!=6);


	}

}
