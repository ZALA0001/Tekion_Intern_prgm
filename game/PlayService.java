package cricket.game;

import java.util.List;

public class PlayService {
    Util util = new Util();

    //Method 1
    public void startGame(int overs) {

        PlayService playService = new PlayService();
        Teams objTeam1, objTeam2;
        System.out.println("Enter number of players in Team 1");
        objTeam1 = playService.setDetails();
        System.out.println("Enter number of players in Team 2");
        objTeam2 = playService.setDetails();

        Toss resultOfToss = new Toss();                   //Toss before the match happens here
        boolean outcome = resultOfToss.choose_toss();     //Based on the outcome of the toss team1 bats first or team2

        if (outcome) {
            batFirst(objTeam1, objTeam2, overs);
        } else {
            batFirst(objTeam2, objTeam1, overs);
        }
    }

    //Method 2
    public void batFirst(Teams objTeam1, Teams objTeam2, int overs) {
        Scorecard play_game = new Scorecard();
        PlayService objPlayService = new PlayService();

        Teams simulationObject;
        System.out.println("Team name: " + objTeam1.getName() + " bats first");
        objTeam1.getPlayerListName();
        objTeam1.getPlayerSkillSet();

        simulationObject = matchSimulate(overs, Integer.MAX_VALUE, objTeam1.getPlayerList(), objTeam1.getNumberOfPlayers());
        objTeam1.setTeamRuns(simulationObject.totalTeamRuns);
        play_game.displayTeamScoreCard(objTeam1.getPlayerList(), objTeam1.getNumberOfPlayers(), simulationObject.totalWickets);
        System.out.println(objTeam1.getName() + " scored " + objTeam1.getTeamScore() + " runs");
        System.out.println(" ");


        System.out.println("Team name: " + objTeam2.getName());
        objTeam2.getPlayerListName();
        objTeam2.getPlayerSkillSet();

        simulationObject = objPlayService.matchSimulate(overs, objTeam1.getTeamScore(), objTeam2.getPlayerList(), objTeam2.numberOfPlayers);
        play_game.displayTeamScoreCard(objTeam2.getPlayerList(), objTeam2.numberOfPlayers, simulationObject.totalWickets);
        objTeam2.setTeamRuns(simulationObject.totalTeamRuns);
        System.out.println(objTeam2.getName() + " scored " + objTeam2.getTeamScore() + " runs");
        System.out.println(" ");

        if (objTeam1.getTeamScore() > objTeam2.getTeamScore()) System.out.println(objTeam1.getName() + " wins");
        else if (objTeam1.getTeamScore() < objTeam2.getTeamScore()) System.out.println(objTeam2.getName() + " wins");
        else System.out.println("Its a tie");
    }

    //Method 3
    public Teams setDetails() {
        Teams teams = new Teams();
        int numberOfPlayers = util.takeInputInteger();
        System.out.println("Enter Team name ");
        String name = util.takeInputString();
        teams.setName(name);
        teams.setNumberOfPlayers(numberOfPlayers);
        teams.setPlayerList();
        return teams;
    }

    //Method 4
    public Teams matchSimulate(int overs, int target, List<Player> playerList, int numberOfPlayers) {
        int total_team_runs = 0;
        int wickets_left = numberOfPlayers - 1;
        int f_p = 0;
        int s_p = 1;
        int strike = f_p;
        int flag = 0;
        System.out.println(" ");
        System.out.println("The bowling summary is as follows: ");
        System.out.println(" ");
        for (int i = 1; i <= overs; i++) {
            System.out.print(i + ".0    ");
            int[] arr = Util.arr;
            int[] freq = Util.freq;
            for (int j = 1; j <= 6; j++) {
                int n = arr.length;
                int curr_ball_runs = Util.myRand(arr, freq, n);

                if (curr_ball_runs == 7) {
                    System.out.print("W ");
                    //balls faced by individual player
                    playerList.get(strike).setBalls(playerList.get(strike).getIndividualBalls() + 1);
                    if (strike == s_p) {
                        s_p = s_p + 1;
                        strike = s_p;
                    } else if (strike == f_p) {
                        f_p = s_p;
                        s_p = s_p + 1;
                        strike = s_p;
                    }
                    wickets_left--;
                } else if (curr_ball_runs % 2 == 0) {
                    total_team_runs = eachBallUpdate(playerList, total_team_runs, strike, curr_ball_runs);
                } else if (curr_ball_runs % 2 == 1) {
                    total_team_runs = eachBallUpdate(playerList, total_team_runs, strike, curr_ball_runs);
                    if (strike == f_p) strike = s_p;
                    else if (strike == s_p) strike = f_p;
                }
                if (wickets_left == 0 || total_team_runs > target) {
                    flag = 1;
                    break;
                }
            }

            System.out.println(" ");
            if (flag == 1) break;              //Line 120 is for if it's an all out case or if target is already achieved
            else {                                                 //Lines 121-123 is for strike change after every over
                if (strike == f_p) strike = s_p;
                else if (strike == s_p) strike = f_p;
            }
        }
        Teams obj_teams = new Teams();
        obj_teams.totalWickets = wickets_left;
        obj_teams.setTeamRuns(total_team_runs);
        return obj_teams;
    }

    //Method 5
    private static int eachBallUpdate(List<Player> playerList, int total_team_runs, int strike, int curr_ball_runs) {
        System.out.print(curr_ball_runs + " ");
        total_team_runs += curr_ball_runs;
        playerList.get(strike).setRuns(playerList.get(strike).getIndividualRuns() + curr_ball_runs);
        playerList.get(strike).setBalls(playerList.get(strike).getIndividualBalls() + 1);
        return total_team_runs;
    }


}
