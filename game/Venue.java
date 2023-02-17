package cricket.game;

public class Venue {
    public void showVenue() {
        System.out.println("Venues in India:");
        System.out.println("1:Motera Stadium    2:Wankhede Stadium    3:Eden Gardens Stadium    4:Chinnaswamy Stadium");
    }

    public void chooseStadium(int option_chose) {
        if (option_chose == 1)
            System.out.println("Welcome to Motera Stadium");
        else if (option_chose == 2)
            System.out.println("Welcome to Wankhede Stadium");
        else if (option_chose == 3)
            System.out.println("Welcome to Eden Gardens Stadium");
        else if (option_chose == 4)
            System.out.println("Welcome to Chinnaswamy Stadium");
        else
            System.out.println("Choose from the above given stadiums");
    }
}
