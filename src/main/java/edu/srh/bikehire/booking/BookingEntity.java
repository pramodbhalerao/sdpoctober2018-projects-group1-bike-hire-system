package edu.srh.bikehire.booking;

import java.math.BigInteger;
import java.security.Timestamp;

public interface BookingEntity {
	
	public BigInteger OrderID();
	
	public String FirstName();
	
	public String Lastname();
	
	public String phoneNumber();
	
	public BigInteger BikeID();
	
	public Timestamp PickupTimestamp();
	
	public Timestamp DropoffTimestamp();
	
	public Timestamp ReturnedTimeStamp();
	
	public String OrderMode();
	
}
