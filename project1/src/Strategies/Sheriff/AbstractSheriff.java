package Strategies.Sheriff;

import Cards.*;
import Manager.GoodsManager;
import Players.IPlayer;
import Players.PlayerManager;
import Sacks.Sack;

import java.util.Iterator;
import java.util.List;

public abstract class AbstractSheriff implements ISheriffStrategy {

    public boolean isBribeable(){
        return false;
    }

    List<IPlayer> playerList = PlayerManager.getPlayerList();

    public List<IPlayer> getPlayerList(){
        return playerList;
    }

    void putBack(IPlayer player, Good g) {
        player.setProfit(player.getProfit() - g.getPenalty());
        g.notValid();
        GoodsManager.initialGoodsList.add(g);
    }

    public int basicCheckSack(IPlayer player){

        int penaltyMoney = 0;
        if (player.isSheriff()) {
            return 0;
        }

        Sack merchantSack = player.getSack();
        System.out.println();
        for (Good good : merchantSack.selectedGoodsList) {
            System.out.println("Player: " + player.toString() + "good: " + good.getName(good.getId()) + " declared as " + good.getName() + " ");
        }
        penaltyMoney = 0;
        for (Iterator<Good> iterator = merchantSack.selectedGoodsList.iterator(); iterator.hasNext(); ) {
            Good good = iterator.next();
            System.out.println("\nChecking " + good.getName());
            penaltyMoney += checkGood(player, good);
        }

        int refund = payPenalty(penaltyMoney, merchantSack);

        if (refund == 0) {
            return penaltyMoney;
        } else {
            return refund * -1;
        }
    }

    public abstract int checkSack(IPlayer player);

    public int checkGood(IPlayer player, Good good) {
        if ((good instanceof IllegalGood) || (!(checkGoodType(good)))) {
            System.out.println("\nSheriff found " + good.getName(good.getId())+ " instead of " + good.getName() + " and the penalty was " + good.getPenalty());
            putBack(player, good);
            return good.getPenalty();
        }
        return 0;
    }

    public boolean checkGoodType(Good good) {
        switch (good.getName()) {
            case "Apple":
                if (good instanceof Apple) return true;
                break;
            case "Bread":
                if (good instanceof Bread) return true;
                break;
            case "Cheese":
                if (good instanceof Cheese) return true;
                break;
            case "Chicken":
                if (good instanceof Chicken) return true;
                break;
            case "null":
                break;
            default:
                return false;
        }
        return false;
    }


    public abstract boolean receiveBribe(int bribe);

    public int payPenalty(int penaltyMoney, Sack merchantSack) {
        int refund = 0;
        if (penaltyMoney == 0) {
            for (int i = 0; i < merchantSack.selectedGoodsList.size(); i++) {
                if(merchantSack.selectedGoodsList.get(i).getName() != null)
                refund += merchantSack.selectedGoodsList.get(i).getPenalty();
            }
        }
        return refund;
    }

}
