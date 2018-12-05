package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.UserAccountDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.UserAccountDTO;
import edu.srh.bikehire.dto.impl.UserAccountDTOImpl;

public class UserAccountDAOImpl implements UserAccountDAO{

	public UserAccountDTOImpl getUserAccount(int pUserId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from UserAccount where ID = :typeId ");
		lQuery.setParameter("typeId", pUserId);
		List<UserAccountDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public UserAccountDTOImpl getUserAccountUsingUserName(String pUserName)
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from UserAccount where UserName = :typeId ");
		lQuery.setParameter("typeId", pUserName);
		List<UserAccountDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}
	
	public boolean addUserAccount(UserAccountDTO pUserAccountDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pUserAccountDTO);
		em.getTransaction().commit();
		return true;
	}

	public boolean updateUserAccount(UserAccountDTO pUserAccountDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		UserAccountDTOImpl lUserAccountDTOImpl = getUserAccount(pUserAccountDTO.getId());
		em.getTransaction().begin();
		
		if(pUserAccountDTO.getAccountStatus() != null)
		{
			lUserAccountDTOImpl.setAccountStatus(pUserAccountDTO.getAccountStatus());
		}
		lUserAccountDTOImpl.setLastModifiedTimeStamp(Calendar.getInstance());
		em.getTransaction().commit();
		return true;
	}

}