package edu.srh.bikehire.service.impl;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.srh.bikehire.dashboard.BikeStatusType;
import edu.srh.bikehire.exception.BikeHireSystemException;

public class DashboardServiceImplTest {

	DashboardServiceImpl dashboardTest = new DashboardServiceImpl();

	@Test
	public void testGetBikeCountAvail() throws BikeHireSystemException {
		//add bike type id 1
		int bikeTypeId = 1;

		long getBikeCount = dashboardTest.getBikeCount(BikeStatusType.AVALIABLE_BIKE, bikeTypeId);
		assertTrue(getBikeCount > 0 );
	}
	
	@Test
	public void testGetBikeCountUnderMaint() throws BikeHireSystemException {
		//add bike type id 2
		int bikeTypeId = 2;

		long getBikeCount = dashboardTest.getBikeCount(BikeStatusType.UNDERMAINTAINCE_BIKE, bikeTypeId);
		assertTrue(getBikeCount >= 0 );
	}
	
	@Test
	public void testGetBikeCountUnderHired() throws BikeHireSystemException {
		//add bike type id 3
		int bikeTypeId = 3;

		long getBikeCount = dashboardTest.getBikeCount(BikeStatusType.RENTED_BIKE, bikeTypeId);
		assertTrue(getBikeCount >= 0 );
	}
	
	@Test
	public void testGetBikeCountInvalidIdAvail() throws BikeHireSystemException {
		//add bike type id -1
		int bikeTypeId = -1;

		long getBikeCount = dashboardTest.getBikeCount(BikeStatusType.AVALIABLE_BIKE, bikeTypeId);
		assertTrue(getBikeCount == 0 );
	}
	
	@Test
	public void testGetBikeCountInvalidIdMaint() throws BikeHireSystemException {
		//add bike type id -2
		int bikeTypeId = -2;

		long getBikeCount = dashboardTest.getBikeCount(BikeStatusType.UNDERMAINTAINCE_BIKE, bikeTypeId);
		assertTrue(getBikeCount == 0 );
	}
	
	@Test
	public void testGetBikeCountInvalidIdHired() throws BikeHireSystemException {
		//add bike type id -3
		int bikeTypeId = -3;

		long getBikeCount = dashboardTest.getBikeCount(BikeStatusType.RENTED_BIKE, bikeTypeId);
		assertTrue(getBikeCount == 0 );
	}

	@Test
	public void testGetUpcomingAppointments() throws BikeHireSystemException {
		Calendar cal = Calendar.getInstance();
		boolean isAppointment = true;
		List upcomingAppList = dashboardTest.getUpcomingAppointments(cal, isAppointment);
		assertTrue(upcomingAppList.size() >= 0) ;
		
	}
	
	@Test
	public void testGetUpcomingAppointmentsNoApp() throws BikeHireSystemException {
		Calendar cal = Calendar.getInstance();
		boolean isAppointment = false;
		List upcomingAppList = dashboardTest.getUpcomingAppointments(cal, isAppointment);
		assertTrue(upcomingAppList.size() == 0) ;
		
	}

}
