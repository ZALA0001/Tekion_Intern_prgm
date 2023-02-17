package cricket.game;

public class MainMethod {
    public static void main(String[] args) {
        Util util = new Util();  //object for util Class

        //The below code is for choosing venue
        Venue venueCall = new Venue();
        venueCall.showVenue(); //This line shows the available venue
        System.out.println("Choose the option");
        int option = util.takeInputInteger();
        venueCall.chooseStadium(option);
        //The below code is for choosing the number of Overs
        PlayService playService = new PlayService();
        System.out.println("Enter number of overs");
        int overs = util.takeInputInteger();
        playService.startGame(overs);
    }
}
