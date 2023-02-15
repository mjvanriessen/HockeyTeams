import java.util.List;
import java.util.Scanner;

import controller.HockeyTeamHelper;
import model.HockeyTeam;

/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Feb 7, 2023
 */


public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static HockeyTeamHelper hth = new HockeyTeamHelper();

	private static void addATeam() {
		System.out.print("Enter a team name: ");
		String teamName = in.nextLine();
		System.out.print("Enter the team's city: ");
		String teamCity = in.nextLine();
		System.out.println("Enter the team's wins: ");
		int teamWins = in.nextInt();
		HockeyTeam toAdd = new HockeyTeam(teamName, teamCity, teamWins);
		hth.insertTeam(toAdd);
	}

	private static void deleteATeam() {
		System.out.print("Enter the team name to delete: ");
		String teamName = in.nextLine();
		System.out.print("Enter the team city to delete: ");
		String teamCity = in.nextLine();
		System.out.println("Enter the team wins amount to delete: ");
		int teamWins = in.nextInt();
		HockeyTeam toDelete = new HockeyTeam(teamName, teamCity, teamWins);
		hth.deleteTeam(toDelete);
	}

	private static void editATeam() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by team name");
		System.out.println("2 : Search by team city");
		int searchBy = in.nextInt();
		in.nextLine();
		List<HockeyTeam> foundTeams;
		if (searchBy == 1) {
			System.out.print("Enter the team name: ");
			String teamName = in.nextLine();
			foundTeams = hth.searchForTeamByTeam(teamName);
		} else {
			System.out.print("Enter the team city: ");
			String teamCity = in.nextLine();
			foundTeams = hth.searchForTeamByCity(teamCity);
		}

		if (!foundTeams.isEmpty()) {
			System.out.println("Found Results.");
			for (HockeyTeam t : foundTeams) {
				System.out.println(t.getTeamId() + " : " + t.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			HockeyTeam toEdit = hth.searchForTeamById(idToEdit);
			System.out.println("Retrieved " + toEdit.getTeamName() + " from " + toEdit.getTeamCity());
			System.out.println("1 : Update team name");
			System.out.println("2 : Update team city");
			System.out.println("3 : Update team wins");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New team name: ");
				String newTeamName = in.nextLine();
				toEdit.setTeamName(newTeamName);
			} else if (update == 2) {
				System.out.print("New team city: ");
				String newTeamCity = in.nextLine();
				toEdit.setTeamCity(newTeamCity);
			} else if (update == 3) {
				System.out.println("New team win count: ");
				int newTeamWins = in.nextInt();
				toEdit.setTeamWins(newTeamWins);
			}

			hth.updateTeam(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Edit an item");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the team list");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addATeam();
			} else if (selection == 2) {
				editATeam();
			} else if (selection == 3) {
				deleteATeam();
			} else if (selection == 4) {
				viewTheList();
			} else {
				//hth.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<HockeyTeam> allHockeyTeams = hth.showAllHockeyTeams();
		for(HockeyTeam singleTeam : allHockeyTeams) {
			System.out.println(singleTeam.returnHockeyTeamDetails());
		}

	}

}
