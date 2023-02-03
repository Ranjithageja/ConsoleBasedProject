package RedBus;
import java.util.*;

/* Red Bus Management*/
/*driver name,
 * driverNo,
 * busNo,
 * busType.
 * from,
 * to
 */
public class BusDetails{
	private String from;
	private String to;
	private String driverName;
	private long driverNo;
	private String busNo;
	private String busType;
	private static Scanner scan =  new Scanner(System.in);

	List <BusDetails> busList = new ArrayList<BusDetails>();
	BusDetails(){
		System.out.println("**WELCOME TO REDBUS**");
		System.out.println("Enter 1 to insert Bus Information");
		System.out.println("Enter 2 to display Bus Information");
		System.out.println("Enter 3 to Search Bus Information");
		System.out.println("Enter 4 to Update Bus Information");
		System.out.println("Enter 5 For Delete Bus Information");


	}

	/* to access private attributes we do encapsulation*/
	/*this keyword is used to access current class attributes */
	/*toString is used to convert all the dataTypes into String and toString is from object class*/

	BusDetails(String from,String to,String driverName,long driverNo,String busNo,String busType){
		this.from=from;
		this.to=to;
		this.driverName=driverName;
		this.driverNo=driverNo;
		this.busNo=busNo;
		this.busType=busType;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
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

	public String toString() {
		return  from+" "+to+" "+driverName+" "+driverNo+" "+busNo+" "+busType;
	}

	/*to add the BusDetails*/
	/*enter the driverName,DriverNo,busNo,busType and ticket has been booked*/


	public void toInsertBusInfo() {
		System.out.println("*Insert Bus Information*");
		System.out.print("Enter the from :");
		String from =scan.next();
		System.out.print("Enter the to :");
		String to=scan.next();
		System.out.print("Enter Driver Name :");
		String driverName=scan.next();
		System.out.print("Enter DriverNo :");
		long driverNo=scan.nextLong();
		System.out.print("Enter BusNo :");
		String busNo=scan.next();
		System.out.print("Enter Bus Type :");
		String busType=scan.next();
		busList.add(new BusDetails( from,to,driverName,driverNo,busNo,busType));
		System.out.println("Bus Information  "+from+" "+to+" "+driverName+"  "+driverNo+"  "+busNo+"  "+busType);
		System.out.println("Your Ticket has been Booked");
	}

	/* to Display the  insert BusDetails*/
	/* hasNext() is boolean if true it contain number*/ 
	/*next() is used to return next number*/

	public void toDisplayBusInfo() {
		System.out.println("*Display Insert Bus Information*");

		Iterator<BusDetails> busRef = busList.iterator();
		while(busRef.hasNext()) { 
			System.out.println(busRef.next()); 
		}
	}

	/* to search the BusDetails*/
	/*search the BusDetails by using busNo*/

	public void toSearchBusInfo(BusDetails bus) {
		System.out.println("*Search Bus Information*");
		boolean flag=false;
		System.out.print("Enter the BusNo to search: ");
		String searchedBusNo = scan.next();
		Iterator<BusDetails> searchBus = busList.iterator();
		while (searchBus.hasNext()){
			bus=searchBus.next();
			if(bus.getBusNo() .equals(searchedBusNo)) {
				flag = true;
				System.out.println("Searched BusNo found");
				break;
			}
		}
		if(flag == false) {
			System.out.println("Searched BusNo is Not Found");
		}

	}

	/*to Update the BusDetails*/
	/*update the BusDetails by using the busNo*/

	public void toUpdateBusInfo(BusDetails bus) {
		System.out.println("*Update Bus Information*");
		boolean flag = false;
		System.out.println("Enter BusNo to Update: ");
		String updateBusNo = scan.next();
		Iterator<BusDetails> updateBus = busList.iterator();
		int ctr = -1;
		while(updateBus.hasNext()) {
			ctr++;
			bus = updateBus.next(); 
			if(bus.getBusNo(). equals( updateBusNo)) {
				flag = true;
				System.out.print("Enter the from :");
				String from =scan.next();
				System.out.print("Enter the to :");
				String to=scan.next();
				System.out.println("Enter updated Driver Name");
				String driverName = scan.next();
				System.out.println("Enter updated driverNo");
				long driverNo = scan.nextLong();
				System.out.println("Enter updated busType");
				String busType = scan.next();
				busList.set(ctr,new BusDetails(from,to,driverName,driverNo,updateBusNo,busType));	
				System.out.println("Update successfully");
				toDisplayBusInfo();
				break;
			}
		}
		if(flag == false) {
			System.out.println("BusNO not found");
		}
	}

	/*toDelete the BusDetails*/
	/*delete the BusDetails by using busNo*/

	public void toDeleteBusInfo(BusDetails bus) {
		System.out.println("Delete Bus Information*");
		boolean Flag = false;
		System.out.print("Enter busNo to delete ");
		String  deleteBusNo = scan.next();
		Iterator<BusDetails> deleteBus = busList.iterator();
		while(deleteBus.hasNext()) {
			bus = deleteBus.next();  
			if(bus.getBusNo().equals(deleteBusNo)) {
				Flag = true;
				busList.remove(bus);
				System.out.println("deleted succesfully");
				toDisplayBusInfo();
				break;
			}
		}
		if(Flag == false) {
			System.out.println("Not deleted successfully");
		}

	}
}
