package dev.lpa;

interface Player {
    String name();
}

record BaseballPlayer(String name, String position) implements Player{}

record FootballPlayer(String name, String position) implements Player{}

record VolleyBallPlayer(String name, String position) implements Player{}

public class Main {

    public static void main(String[] args) {

        var philly = new Affiliation("city","Philadephia, PA","US");

        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Huston Astros");
        scoreResult(phillies1,3,astros1,5);

        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Huston Astros");
        scoreResult(phillies2,3,astros2,5);

        Team<BaseballPlayer, Affiliation> phillies = new Team<>("Philadelphia Phillies", philly);
        Team<BaseballPlayer, Affiliation> astros = new Team<>("Huston Astros");
        scoreResult(phillies,3,astros,5);

        var harper = new BaseballPlayer("B Harper","Right Fielder");
        var marsh = new BaseballPlayer("B Marsh","Right Fielder");
        var guthrie = new BaseballPlayer("Mirel Radoi","Central Midfielder");
        phillies.addTeamMember(guthrie);
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();

        SportsTeam afc1 = new SportsTeam("Otelul Galati");
        Team<FootballPlayer, String> afc = new Team<>("Otelul Galati","City of Adelaide, South Austrialia, in AU");
        var tex = new FootballPlayer("Ion Viorel","Central Forward");
        afc.addTeamMember(tex);
        var rory = new FootballPlayer("Catalin Munteanu","Goalkeeper");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team<VolleyBallPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyBallPlayer("N Roberts","Jumper"));
        adelaide.listTeamMembers();

        var canberra = new Team<VolleyBallPlayer, Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VolleyBallPlayer("B Black","Jumper, but closer to the net"));
        canberra.listTeamMembers();
        scoreResult(canberra,0,adelaide,1);

//        Team<Integer> melbourneVB = new Team<>("Melbourne Vipers");


    }

    public static void scoreResult(BaseballTeam team1, int t1_score,
                                   BaseballTeam team2, int t2_score) {
        String msg = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,msg,team2);
    }

    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score) {
        String msg = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,msg,team2);
    }

    public static void scoreResult(Team team1, int t1_score,
                                   Team team2, int t2_score) {
        String msg = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,msg,team2);
    }
}
