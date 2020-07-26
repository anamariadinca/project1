import Manager.GoodsManager;
import Players.PlayerManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private static final int NO_OF_GAMES = 2;


    public static void main(String[] args) {

        Tournament t = new Tournament("resources/input.txt");
        t.play();
    }


    public Tournament(String filePath){

        try {

            File file = new File(filePath);
            List<Integer> goodsIds = new ArrayList<>();
            List<String> playerTypes = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = br.readLine();

            String newline = line.replaceAll("[ \\[ \\] ]", "");
            String[] lineIds = newline.split(",");
            for (String s : lineIds) {
                goodsIds.add(Integer.parseInt(s));
            }

            line = br.readLine();

            line = line.replace('[', ' ').replace(']', ' ').replace('\"',' ').replaceAll("\\s","");

            String[] types = line.split(",");
            for (String s : types) {
                playerTypes.add(s);
            }


            GoodsManager.createGoodsQueue(goodsIds);
            PlayerManager.createPlayers(playerTypes);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void play(){

        Game game = new Game();

        for (int gameNumber = 0; gameNumber < NO_OF_GAMES; gameNumber ++) {

            game.play();
        }
    }
}
