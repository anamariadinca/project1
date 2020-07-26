package Players;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private static List<IPlayer> playersList =  new ArrayList<>();


    public static List<IPlayer> createPlayers(List<String> playerTypes){

        for(int i = 0; i< playerTypes.size(); i++){
            playersList.add(PlayerFactory.createPlayer(playerTypes.get(i)));
        }
        return playersList;
    }

    public static List<IPlayer> getPlayerList(){
        return playersList;
    }
}
