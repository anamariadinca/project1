package Strategies.Sheriff;
import Players.IPlayer;

public class BasicSheriff extends AbstractSheriff {

    @Override
    public int checkSack(IPlayer player) {
        return super.basicCheckSack(player);
    }

    @Override
    public boolean receiveBribe(int bribe) {
        return false;
    }


}
