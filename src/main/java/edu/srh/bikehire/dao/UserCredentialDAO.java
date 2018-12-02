package edu.srh.bikehire.dao;

import edu.srh.bikehire.dtointerface.UserCredentialDTO;

public interface UserCredentialDAO {
	
	public UserCredentialDTO getUserCredentialByUserId(String pUserId);
	
	public UserCredentialDTO getUserCredentialByUserName(String pUserName);
	
	public boolean addUserCredential(UserCredentialDTO pUserCredentialDTO);
	
	public boolean updateUserCredential(UserCredentialDTO pUserCredentialDTO);
	
}