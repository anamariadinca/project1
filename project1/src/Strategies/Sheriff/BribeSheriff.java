package Strategies.Sheriff;
import Players.IPlayer;

public class BribeSheriff extends AbstractSheriff {

    public boolean receiveBribe(int bribe){
        return false;
    }

    public int checkSack(IPlayer player){
        return super.basicCheckSack(player);
    }
}
