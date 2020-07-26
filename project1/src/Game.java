import Players.IPlayer;
import Players.PlayerManager;
import Round.Round;
import Sacks.Sack;
import Strategies.Sheriff.AbstractSheriff;
import Strategies.Sheriff.ISheriffStrategy;

public class Game  {

    /**
     *
     */
    public void play() {

        Round round = new Round();

        for (int i = 0; i < PlayerManager.getPlayerList().size(); i++) {

            round.play(i);
        }
    }
}



