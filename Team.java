package dev.lpa;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String CountryCode) {

    @Override
    public String toString() {
        return name + " (" + type + " in " + CountryCode + ")";
    }
}

public class Team<T extends Player, S> {
    
    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t) {
        if(!teamMembers.contains(t)) {
            teamMembers.add(t);
        }
    }

    public void listTeamMembers() {
        System.out.print(teamName + " Roster:");
        System.out.println(affiliation == null ? "" : " AFFILIATION: " + affiliation);
        for (T t : teamMembers) {
            System.out.println(t.name());
        }
    }

    public int ranking() {
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        String msg = "lost";
        if(ourScore > theirScore) {
            totalWins += 1;
            msg = "Win!";
        } else if (ourScore == theirScore) {
            totalTies += 1;
            msg = "Tie!";
        } else {
            totalLosses += 1;
            msg = "Lost!";
        }
        return msg;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
