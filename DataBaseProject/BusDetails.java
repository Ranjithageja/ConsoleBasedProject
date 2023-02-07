package Bus;

import java.util.Scanner;
//* Red Bus Management*/
/*driver name,
 * driverNo,
 * busNo,
 * busType.
 * StartingPoint
 * EndingPoint
 */

public class BusDetails{
	private static Scanner scan=new Scanner(System.in);
	private String StartingPoint;
	private String EndingPoint;
	private String driverName;
	private long driverNo;
	private String busNo;
	private String busType;

	/*get the login userName and Password from the user for BusDetails*/
	public BusDetails() {
		System.out.println("***Login***");
		System.out.print("Enter username");
		String userName=scan.nextLine();
		System.out.print("Enter password");
		String password=scan.nextLine();
		toLogin(userName,password);
	}

	/* to access private attributes we do encapsulation*/
	public String getStartingpoint() {
		return StartingPoint;
	}

	public void setStartingPoint(String StartingPoint) {
		this.StartingPoint = StartingPoint;
	}

	public String getEndingPoint() {
		return EndingPoint;
	}

	public void setEndingPoint(String EndingPoint) {
		this.EndingPoint = EndingPoint;
	}

	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public long getDriverNo() {
		return driverNo;
	}
	public void setDriverNo(long driverNo) {
		this.driverNo = driverNo;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}

	/*  to check  the Login password and userName*/
	public  static void toLogin (String username, String password) {
		if(username.equals("SRN") && password.equals("672030")) {
			System.out.println("Successfully login");
		}

	}

	/*to logout */
	public static void tologout() {
		System.out.println("Thank you visit again");

	}
}




