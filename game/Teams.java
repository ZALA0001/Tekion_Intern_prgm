package cricket.game;

import java.util.ArrayList;
import java.util.List;

public class Teams {
    private String name;
    public Integer numberOfPlayers;
    private List<Player> player_list;
    public Integer totalTeamRuns;
    public Integer totalWickets;

    Util util = new Util();

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void setPlayerList() {
        List<Player> squad = new ArrayList<>();
        for (int i = 0; i <= numberOfPlayers - 1; i++) {
            //get input variables;
            System.out.println("Enter Player " + (i + 1) + " and his/her skill set: ");
            String name = util.takeInputString();
            System.out.println("1:Batsman 2:Bowler ");
            String skill_set = util.takeInputString();
            Player p1 = new Player(name,skill_set,0,0);
            squad.add(p1);
        }
        player_list = new ArrayList<>(squad);
    }

    public void setTeamRuns(int totalTeamRuns) {
        this.totalTeamRuns = totalTeamRuns;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    public List<Player> getPlayerList() {
        return this.player_list;
    }

    public void getPlayerListName() {
        List<Player> players = this.player_list;
        List<String> squad = new ArrayList<>();
        for (Player player_search : players) {
            squad.add(player_search.getName());
        }
        System.out.println(squad);
    }

    public void getPlayerSkillSet() {
        List<Player> players = this.player_list;
        List<String> skill_list = new ArrayList<>();
        for (Player player_search : players) {
            skill_list.add(player_search.getSkillSet());
        }
        System.out.println(skill_list);
    }

    public Integer getTeamScore() {
        return this.totalTeamRuns;
    }

}

