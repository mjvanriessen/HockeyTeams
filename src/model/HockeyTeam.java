/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Feb 13, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class HockeyTeam {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int teamId;
	@Column(name="NAME")
	private String teamName;
	@Column(name="CITY")
	private String teamCity;
	@Column(name="WINS")
	private String teamWins;
	
	public HockeyTeam() {
		super();
	}
	
	public HockeyTeam(String teamName, String teamCity, String teamWins) {
		super();
		this.teamName = teamName;
		this.teamCity = teamCity;
		this.teamWins = teamWins;
	}
	
	public int getTeamId() {
		return teamId;
	}
	
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamCity() {
		return teamCity;
	}

	public void setTeamCity(String teamCity) {
		this.teamCity = teamCity;
	}

	public String getTeamWins() {
		return teamWins;
	}

	public void setTeamWins(String teamWins) {
		this.teamWins = teamWins;
	}
	
	public String returnHockeyTeamDetails() {
		return "Name: " + this.teamName + " / City: " + this.teamCity + " / Wins: " + this.teamWins;
	}

}
