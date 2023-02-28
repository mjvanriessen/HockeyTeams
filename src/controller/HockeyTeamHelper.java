/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Feb 13, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.HockeyTeam;

public class HockeyTeamHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebHockeyTeams");
	
	public void insertTeam(HockeyTeam ht) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ht);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<HockeyTeam> showAllHockeyTeams(){
		EntityManager em = emfactory.createEntityManager();
		List<HockeyTeam> allHockeyTeams = em.createQuery("SELECT t FROM HockeyTeam t").getResultList();
		return allHockeyTeams;
	}
	
	public void deleteTeam(HockeyTeam toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HockeyTeam> typedQuery = em.createQuery("select ht from HockeyTeam ht where ht.teamName = :selectedTeamName and ht.teamCity = :selectedTeamCity and ht.teamWins = :selectedTeamWins", HockeyTeam.class);
		typedQuery.setParameter("selectedTeamName", toDelete.getTeamName());
		typedQuery.setParameter("selectedTeamCity", toDelete.getTeamCity());
		typedQuery.setParameter("selectedTeamWins", toDelete.getTeamWins());
		typedQuery.setMaxResults(1);
		HockeyTeam result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<HockeyTeam> searchForTeamByTeam(String teamName){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HockeyTeam> typedQuery = em.createQuery("select ht from HockeyTeam ht where ht.teamName = :selectedTeamName", HockeyTeam.class);
		typedQuery.setParameter("selectedTeamName", teamName);
		List<HockeyTeam> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}
	
	public List<HockeyTeam> searchForTeamByCity(String teamCity){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HockeyTeam> typedQuery = em.createQuery("select ht from HockeyTeam ht where ht.teamCity = :selectedTeamCity", HockeyTeam.class);
		typedQuery.setParameter("selectedTeamCity", teamCity);
		List<HockeyTeam> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}
	
	public HockeyTeam searchForTeamById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		HockeyTeam foundTeam = em.find(HockeyTeam.class, idToEdit);
		em.close();
		return foundTeam;
	}
	
	public void updateTeam(HockeyTeam toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
