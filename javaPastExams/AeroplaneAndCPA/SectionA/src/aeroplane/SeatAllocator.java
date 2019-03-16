package aeroplane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SeatAllocator {

	private Map<Seat, Passenger> allocation;

	private static final String CREW = "crew";
	private static final String BUSINESS = "business";
	private static final String ECONOMY = "economy";
	
	public SeatAllocator() {
		allocation = new HashMap<Seat, Passenger>();
	}

	@Override
	public String toString() {
		return allocation.toString();
	}
	
	private void allocateInRange(Passenger passenger,
			Seat first, Seat last) throws AeroplaneFullException {
		Seat currentSeat = first;

		while (!currentSeat.equals(last)) {
				if (!allocation.containsKey(currentSeat)) {
					if (AeroplaneInfo.emergencyRows.contains(currentSeat.getRow())) {
						if (passenger.isAdult()) {
							allocation.put(currentSeat, passenger);
							break;
						}
					} else {
						allocation.put(currentSeat, passenger);
						break;
					}
				}
			if (currentSeat.hasNext()){
				currentSeat = currentSeat.next();
			}
		}

		if(!allocation.containsKey(currentSeat)) {
			throw new AeroplaneFullException();
		}



		System.out.println("Passenger at Seat: " + currentSeat.toString());


	}



	private static String readStringValue(BufferedReader br) throws MalformedDataException, IOException {

		String result = br.readLine();
		
		if(result == null) {
			throw new MalformedDataException();
		}
		
		return result;
		
	}

	private static int readIntValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Integer.parseInt(readStringValue(br));
		} catch(NumberFormatException e) {
			throw new MalformedDataException();
		}
	}

	private static Luxury readLuxuryValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Luxury.valueOf(readStringValue(br));
		} catch(IllegalArgumentException e) {
			throw new MalformedDataException();
		}
	}

	
	public void allocate(String filename) throws IOException, AeroplaneFullException {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));

		String line;
		while((line = br.readLine()) != null) {
			try {
				if(line.equals(CREW)) {
					allocateCrew(br);
				} else if(line.equals(BUSINESS)) {
					allocateBusiness(br);
				} else if(line.equals(ECONOMY)) {
					allocateEconomy(br);
				} else {
					throw new MalformedDataException();
				}
			} catch(MalformedDataException e) {
				System.out.println("Skipping malformed line of input");
			}
		}
		
	}
	
	private void allocateCrew(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		Passenger crewMember = new CrewMember(firstName, lastName);
		Seat crewFirstSeat = new Seat(AeroplaneInfo.crewRow, Seat.firstSeat);
		Seat crewLastSeat = new Seat(AeroplaneInfo.crewRow, (char) (Seat.firstSeat + AeroplaneInfo.seatsPerRow - 1));
		allocateInRange(crewMember, crewFirstSeat, crewLastSeat);
	}

	private void allocateBusiness(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		Luxury luxury = readLuxuryValue(br);
		Passenger businessPassenger = new BusinessPassenger(firstName, lastName, age, luxury);
		Seat businessFirstSeat = new Seat(AeroplaneInfo.businessRowRange[0], Seat.firstSeat);
		Seat businessLastSeat = new Seat(AeroplaneInfo.businessRowRange[1], (char) (Seat.firstSeat + AeroplaneInfo.seatsPerRow - 1));
		allocateInRange(businessPassenger, businessFirstSeat, businessLastSeat);
	}

	private void allocateEconomy(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);

		Passenger economyPassenger = new EconomyPassenger(firstName, lastName, age);
		Seat firstEconSeat = new Seat(AeroplaneInfo.economyRowRange[0], Seat.firstSeat);
		Seat lastEconSeat = new Seat(AeroplaneInfo.economyRowRange[1], (char) (Seat.firstSeat + AeroplaneInfo.seatsPerRow - 1));
		allocateInRange(economyPassenger, firstEconSeat, lastEconSeat);
	}

	public void upgrade() {
		final Seat firstEconomy = new Seat(AeroplaneInfo.economyRowRange[0], Seat.firstSeat);
		Seat currentSeat = firstEconomy;
		while (currentSeat.hasNext()) {

		}
	}

	private boolean isBusinessFree() {
		Seat firstBusiness = new Seat(AeroplaneInfo.businessRowRange[0], Seat.firstSeat);
		Seat lastBusiness = new Seat(AeroplaneInfo.businessRowRange[1], (char) (Seat.firstSeat + AeroplaneInfo.seatsPerRow - 1));
		Seat current = firstBusiness;
		boolean free = false;
		while (!current.equals(lastBusiness)) {
			if (!allocation.containsKey(current)) {
				free = true;
			}
			if (current.hasNext()) {
				current = current.next();
			}
		}
		return free;
	}



	// TODO: Section A, Task 5 - add upgrade method

}
