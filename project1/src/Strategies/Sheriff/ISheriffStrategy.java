package Strategies.Sheriff;

import Players.IPlayer;

import java.util.List;

public interface ISheriffStrategy {
    int checkSack(IPlayer player);
    boolean receiveBribe(int bribe);
    List<IPlayer> getPlayerList();
    boolean isBribeable();
}
