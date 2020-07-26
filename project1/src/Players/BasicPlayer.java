package Players;
import Strategies.Sheriff.BasicSheriff;
import Strategies.Merchant.BasicMerchant;

public class BasicPlayer extends AbstractPlayer {


    public BasicPlayer(){
        setType("basic");
        setMerchant(new BasicMerchant());
        setSheriff(new BasicSheriff());
    }

    @Override
    public void verifyMerchants(){
        for(IPlayer merchant : this.sheriff.getPlayerList()){
            verifyMerchant(this,merchant);
        }
    }

    @Override
    public void initializeMerchant(IPlayer sheriff, int runda) {

        super.initializeMerchant(sheriff, runda);

        setSack(merchant.createSack());
    }
}
