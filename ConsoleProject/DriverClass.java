package RedBus;

import java.util.Scanner;

public class DriverClass{
	public static void main(String args[]) {
		BusDetails bus = new BusDetails();

		Scanner scan = new Scanner(System.in);
		byte userInput;
		do {
			userInput = scan.nextByte();

			/* method calling using object Name*/

			switch(userInput) {
			case 1:
				bus.toInsertBusInfo();
				break;
			case 2:
				bus.toDisplayBusInfo();
				break;
			case 3:
				bus.toSearchBusInfo(bus);
				break;
			case 4:
				bus.toUpdateBusInfo(bus);
				break;
			case 5:
				bus.toDeleteBusInfo(bus);
				break;
			case 6:
				break;
			}
		}while(userInput!=6);
	}
}