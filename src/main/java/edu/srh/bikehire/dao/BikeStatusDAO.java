package edu.srh.bikehire.dao;

import java.util.List;

import edu.srh.bikehire.dto.BikeStatusDTO;

public interface BikeStatusDAO {
	public BikeStatusDTO getBikeStatus(String pBikeId);
	
	public boolean addBikeStatus(BikeStatusDTO pBikeStatus);
	
	public boolean updateBikeStatus(BikeStatusDTO pBikeStatus);
	
	public List<BikeStatusDTO> getAllBikesBasedOnStatus(String pStatus);
	
	public long getBikeCount(String pStatus, String pBikeTypeId);
}
