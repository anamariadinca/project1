package Strategies.Sheriff;

import Cards.Good;
import Players.IPlayer;
import Sacks.Sack;

public class GreedySheriff extends AbstractSheriff {

    @Override
    public boolean isBribeable() {
        return true;
    }

    public boolean receiveBribe(int bribe) {
        if (bribe > 0) {
            return true;
        }
        return false;
    }

    public int checkSack(IPlayer player) {
        if (!receiveBribe(player.giveBribe())) {
            System.out.println("\n*****This player did not give bribe");
            return super.basicCheckSack(player);
        } else {
            System.out.println("\n*****This player did give bribe");
            Sack merchantSack = player.getSack();
            for (Good good : merchantSack.selectedGoodsList) {
                System.out.println("Player: " + player.toString() + "good: " + good.getName(good.getId()) + " declared as " + good.getName() + " ");
            }
        }
        return 0;
    }

}
