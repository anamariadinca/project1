package Round;
import Players.IPlayer;

public class PrintLog {

    public static void printProfit(IPlayer player) {
        String type = player.getType().toUpperCase();
        System.out.println(type + ": " + player.getProfit());
    }
}

