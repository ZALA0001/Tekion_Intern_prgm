package cricket.game;

public class Player {
    //VARIABLES
    private String name;
    private int individualRuns;
    private int individualBalls;
    private String skillSet;

    //Constructor
    Player(String name, String skill_set, int individual_runs, int individual_balls) {
        this.name = name;
        this.skillSet = skill_set;
        this.individualRuns = individual_runs;
        this.individualBalls = individual_balls;
    }

    //Setters
//    public void setName(String name) {
//        this.name = name;
//    }

    public void setRuns(int runs) {
        this.individualRuns = runs;
    }

    public void setBalls(int balls) {
        this.individualBalls = balls;
    }

    public void setSkillSet(String skill_set) {
        this.skillSet = skill_set;
    }

    //Getters
    public String getName() {
        return this.name;
    }

    public int getIndividualRuns() {
        return this.individualRuns;
    }

    public int getIndividualBalls() {
        return this.individualBalls;
    }

    public String getSkillSet() {
        return this.skillSet;
    }


}
