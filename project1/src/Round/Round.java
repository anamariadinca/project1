package Round;

import Players.AbstractPlayer;
import Players.IPlayer;
import Players.PlayerManager;
import java.util.List;

public class Round {

    public void play(int i) {

        List<IPlayer> playerList = PlayerManager.getPlayerList();

        System.out.println("\n**** ROUND " + i + " ****");
        IPlayer sheriffPlayer = playerList.get(i);
        sheriffPlayer.setSheriffRole();
        System.out.println("Player " + i + " is " + sheriffPlayer.getType().toUpperCase() + " Sheriff");
        for (int j = 0; j < playerList.size(); j++) {

            if (j != i) {
                playerList.get(j).initializeMerchant(sheriffPlayer, i);
            }
        }

        sheriffPlayer.verifyMerchants();

        for (int j = 0; j < playerList.size(); j++) {
            if (!(playerList.get(j).equals(sheriffPlayer))) {
                playerList.get(j).sellGoods();
            }
            PrintLog.printProfit(playerList.get(j));
        }

    }


}
