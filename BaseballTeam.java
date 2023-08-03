package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class BaseballTeam {

    private String teamName;
    private List<BaseballPlayer> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public BaseballTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(BaseballPlayer player) {
        if(!teamMembers.contains(player)) {
            teamMembers.add(player);
        }
    }

    public void listTeamMembers() {
        System.out.println(teamName + " Roster:");
        System.out.println(teamMembers);
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
