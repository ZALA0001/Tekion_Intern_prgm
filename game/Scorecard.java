package cricket.game;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Scorecard
{
    public void displayTeamScoreCard(List<Player> player_list,int numberOfPlayers,int wickets_left)
    {
        int total_team_runs=0;
        int total_balls=0;
        System.out.println(" ");
        System.out.println("Individual runs scored by players is as follows: ");
        System.out.println(" ");
        for(int i=0;i<=numberOfPlayers-1;i++)
        {
            System.out.println(getSummary(player_list, i));
            total_balls+=player_list.get(i).getIndividualBalls();
            total_team_runs+=player_list.get(i).getIndividualRuns();
        }
        System.out.println(" ");
        System.out.println(getSummary(numberOfPlayers, total_team_runs, total_balls, wickets_left));
    }

    @NotNull
    private static String getSummary(int numberOfPlayers, int total_team_runs, int total_balls, int wickets_left) {
        return "Final Score : "+ total_team_runs + "-" +(numberOfPlayers - wickets_left - 1)+" ("+(total_balls /6)+"."+(total_balls %6)+")";
    }

    @NotNull
    private static String getSummary(List<Player> player_list, int i) {
        return player_list.get(i).getName() + ":" + player_list.get(i).getIndividualRuns() + "(" + player_list.get(i).getIndividualBalls() + ")";
    }



}
