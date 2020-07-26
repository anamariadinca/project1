package Players;

import Strategies.Merchant.BribeMerchant;
import Strategies.Sheriff.BribeSheriff;

import java.util.ArrayList;
import java.util.List;

public class BribePlayer extends AbstractPlayer {

    public BribePlayer() {
        setType("bribe");
        setMerchant(new BribeMerchant());
        setSheriff(new BribeSheriff());
    }


    @Override
    public void verifyMerchants() {
        List<IPlayer> playersList = this.sheriff.getPlayerList();
        List<IPlayer> merchantsToBeVerifiecList = new ArrayList<>();
        int noOfPlayers = playersList.size()-1;
        for (int i = 0; i < playersList.size(); i++) {
            if (playersList.get(i).isSheriff()) {
                if(i == 0){
                    merchantsToBeVerifiecList.add(playersList.get(i+1));
                    merchantsToBeVerifiecList.add(playersList.get(noOfPlayers));
                }
                else if(i == noOfPlayers){
                    merchantsToBeVerifiecList.add(playersList.get(0));
                    merchantsToBeVerifiecList.add(playersList.get(noOfPlayers-1));
                }
                else {
                    merchantsToBeVerifiecList.add(playersList.get(i-1));
                    merchantsToBeVerifiecList.add(playersList.get(i+1));
                }
            }
        }

        for(IPlayer merchant : merchantsToBeVerifiecList){
            verifyMerchant(this,merchant);
        }
    }

    @Override
    public void initializeMerchant(IPlayer sheriff, int runda) {

        super.initializeMerchant(sheriff, runda);

        setSack(merchant.createSack());
    }
}
