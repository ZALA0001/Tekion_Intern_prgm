package cricket.game;

public class Innings {
    public void playInnings(Teams teams, int overs) {
        Scorecard play_game = new Scorecard();
        PlayService playService = new PlayService();
        Teams simulationObject;
        System.out.println("Team name: " + teams.getName() + " bats first");
        teams.getPlayerListName();
        teams.getPlayerSkillSet();

        simulationObject = playService.matchSimulate(overs, Integer.MAX_VALUE, teams.getPlayerList(), teams.getNumberOfPlayers());
        teams.setTeamRuns(simulationObject.totalTeamRuns);
        play_game.displayTeamScoreCard(teams.getPlayerList(), teams.getNumberOfPlayers(), simulationObject.totalWickets);
        System.out.println(teams.getName() + " scored " + teams.getTeamScore() + " runs");
        System.out.println(" ");
    }
}
