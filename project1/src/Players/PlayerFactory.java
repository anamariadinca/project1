package Players;

public class PlayerFactory {

    String type;
    public static AbstractPlayer createPlayer(String type){
        switch(type){
            case "basic": return new BasicPlayer();
            case "greedy": return new GreedyPlayer();
            case "bribed": return new BribePlayer();
        }

        return null;
    }
}
