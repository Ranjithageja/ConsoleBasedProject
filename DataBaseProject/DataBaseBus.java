package Bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Scanner;

public class DataBaseBus {
	private static Scanner scan=new Scanner(System.in);

	/*to InsertBusInfo to the BusInfo*/
	/*Insert is a DML query*/
	/*PreparedStatement  is used to executeUpdate is used to Insert the values and count the Insert BusInfo*/
	/*enter the startingPoint,EndingPoint,driverName,DriverNo,busNo,busType*/
	void toInsertBusInfo(Connection connection) throws SQLException {
		PreparedStatement addAll=connection.prepareStatement("INSERT INTO BusInfo_Table values(?,?,?,?,?,?)");
		System.out.println("Enter the StartingPoint ");
		addAll.setString(1, scan.next());
		System.out.println("Enter the EndingPoint ");
		addAll.setString(2, scan.next());
		System.out.println("Enter the DriverName ");
		addAll.setString(3, scan.next());
		System.out.println("Enter the DriverNo ");
		addAll.setLong(4, scan.nextLong());
		System.out.println("Enter the BusNo ");
		addAll.setString(5, scan.next());
		System.out.println("Enter the BusType ");
		addAll.setString(6, scan.next());
		int addValues=addAll.executeUpdate();
		System.out.println(addValues +"AddedValues");
	}

	/*to Display the  insert BusDetails*/
	/*displayBusInfo by using busNo*/
	/*to DisplayBusInfo we can use resultSet and Execute Query*/ 
	void toDisplayBusInfo(Connection connection)  throws SQLException,Exception{
		Statement stmt=connection.createStatement();
		ResultSet result=stmt.executeQuery("SELECT * FROM BusInfo_Table");
		while(result.next()) {
			System.out.println("Starting POINT: "+result.getString(1)+" "+"Ending POINT: "+result.getString(2)+" "+"Driver Name: "+result.getString(3)+" "+"Driver Number: "+result.getLong(4)+" "+"Bus Number: " +result.getString(5)+" "+"Bus type: "+result.getString(6));
		}
	}

	/* to search the BusDetails*/
	/*searchBusInfo by using busNo*/
	/* preparedStatement is used to executeQuerry and display the Searched busDetails */
	/*to SearchBusInfo we can use resultSet and Execute Query*/ 
	void toSearchBusInfo(Connection connection)throws SQLException, Exception{ 
		PreparedStatement prepareStmt=connection.prepareStatement("SELECT * FROM BusInfo_Table where Bus_No=?");
		System.out.println("Enter the busno to search: ");
		String search_busNo=scan.nextLine();
		prepareStmt.setString(1,search_busNo);
		ResultSet search=prepareStmt.executeQuery();
		while(search.next()) {
			System.out.println("Starting POINT: "+search.getString(1)+" "+"Ending POINT: "+search.getString(2)+" "+"Driver Name: "+search.getString(3)+" "+"Driver Number: "+search.getLong(4)+" "+"Bus Number: "+search.getString(5)+" "+"Bus type: "+search.getString(6));

		}
	}

	/* to update the BusDetails*/
	/*update is a DML query*/
	/*updateBusInfo by using busNo*/
	/* preparedStatement is used to executeUpdate and count the recorded updated */
	/*to updateBusInfo we can use resultSet and ExecuteUpdate*/ 
	void toUpdateBusInfo(Connection connection) throws SQLException ,Exception{
		PreparedStatement prepareStmt=connection.prepareStatement("update BusInfo_Table set Bus_Type=?, Starting_point = ? where Bus_No=?");
		System.out.println("ENter the bus no to update");
		prepareStmt.setString(3,scan.next());
		System.out.println("Enter the Bus_Type");
		prepareStmt.setString(1,scan.next());
		System.out.println("Enter the StartingPoint");
		prepareStmt.setString(2,scan.next());
		int update=prepareStmt.executeUpdate();
		System.out.println(update +"Record updated");

	}

	/* to delete the BusDetails*/
	/*deleteBusInfo by using busNo*/
	/*delete is a DML query*/
	/* preparedStatement is used to executeUpdate and display the count of the record deleted */
	/*to SearchBusInfo we can use resultSet and Execute Query*/
	void toDeleteBusInfo(Connection connection)throws SQLException,Exception {
		PreparedStatement prepareStmt=connection.prepareStatement("DELETE FROM BusInfo_Table where Bus_No=?");
		System.out.println("Enter the busno to delete: ");
		String delete_busNo=scan.nextLine();
		prepareStmt.setString(1,delete_busNo);
		int deleterecord = prepareStmt.executeUpdate();
		System.out.println(deleterecord +"Record deleted");
	}

}









