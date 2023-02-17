package cricket.game;

import static cricket.game.Constants.HEADS;
import static cricket.game.Constants.TAILS;
import static cricket.game.Util.freq_outcome;
import static cricket.game.Util.toss_outcome;

public class Toss {
    Util util = new Util();

    public boolean choose_toss() {
        System.out.println("Heads or Tails");
        String toss = util.takeInputString();
        System.out.println("Team 1 Captain chose " + toss);
        int n = toss_outcome.length;
        int ans = Util.myRand(toss_outcome, freq_outcome, n);
        String outcome;
        if (ans == 0)
            outcome = HEADS;
        else
            outcome = TAILS;

        System.out.println("The outcome is: " + outcome);

        return outcome.equals(toss);
    }

}
