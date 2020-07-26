package Players;
import Strategies.Merchant.GreedyMerchant;
import Strategies.Sheriff.GreedySheriff;

public class GreedyPlayer extends AbstractPlayer {

    public GreedyPlayer(){
        setType("greedy");
        setMerchant(new GreedyMerchant());
        setSheriff(new GreedySheriff());
    }

    @Override
    public void verifyMerchants(){
        for(IPlayer merchant : this.sheriff.getPlayerList()){
            verifyMerchant(this,merchant);
        }
    }

    @Override
    public void initializeMerchant(IPlayer sheriff, int round) {

        super.initializeMerchant(sheriff, round);

        setSack(this.merchant.createSack());
    }

}
