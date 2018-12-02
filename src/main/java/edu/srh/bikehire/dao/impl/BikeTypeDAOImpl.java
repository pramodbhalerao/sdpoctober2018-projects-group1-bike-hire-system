package edu.srh.bikehire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.BikeTypeDAO;
import edu.srh.bikehire.daoimpl.util.PersistenceManager;
import edu.srh.bikehire.dto.BikeTypeDTOImpl;
import edu.srh.bikehire.dtointerface.BikeTypeDTO;
import edu.srh.bikehire.util.Util;

public class BikeTypeDAOImpl implements BikeTypeDAO {

	public BikeTypeDTOImpl getBikeType(String pBikeType)
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from BikeType where BikeTypeId = :typeId ");
		lQuery.setParameter("typeId", pBikeType);
		
		List<BikeTypeDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}
	
	public List<BikeTypeDTO> getBikeTypes() {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("SELECT a FROM BikeType a");
		
		List<BikeTypeDTO> results = lQuery.getResultList();
		return results;
	}

	public String saveBikeType(BikeTypeDTO bikeType) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		//Generate random bike type id.
		String lstrBikeTypeId = Util.getRandomAlphaNumericId();
		em.getTransaction().begin();
		
		BikeTypeDTOImpl lBikeTypeDTOImpl = new BikeTypeDTOImpl();
		lBikeTypeDTOImpl.setBikeTypeId(lstrBikeTypeId);
		em.persist(lBikeTypeDTOImpl);
		em.getTransaction().commit();
		return lstrBikeTypeId;
	}

}