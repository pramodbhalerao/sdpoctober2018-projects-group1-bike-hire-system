package edu.srh.bikehire.dto;

import java.util.Calendar;

public interface WareHouseDTO {
	
	public String getWarehouseId();
	public String getName();
	public String getLocation();
	public int getStorageCapacity();
	public Calendar getCreationTimeStamp();
	public Calendar getLastmodifiedTimeStamp();

}
