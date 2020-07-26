package Players;

import Cards.FactoryBonus;
import Cards.Good;
import Sacks.Sack;
import Strategies.Merchant.AbstractMerchant;
import Strategies.Sheriff.AbstractSheriff;
import Strategies.Merchant.IMerchantStrategy;
import Strategies.Sheriff.ISheriffStrategy;

import java.util.List;

public abstract class AbstractPlayer implements IPlayer {

    private String type;
    private int profit = 50;

    private boolean isMerchant = true;
    protected ISheriffStrategy sheriff;
    protected IMerchantStrategy merchant;


    public void setMerchantProfit(){
        this.merchant.setProfit(profit);
    }

    public void setProfit(int profit){
        this.profit = profit;
    }

    public int giveBribe(){
        int bribe = this.merchant.giveBribe();
        profit -= bribe;
        return bribe;
    }

    public Sack getSack()
    {
        return merchant.getMerchantSack();
    }

    public void setSack(Sack sack) {
        this.merchant.setMerchantSack(sack);
    }

    public int getProfit() {
        return profit;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean isMerchant() {
        return isMerchant;
    }

    public boolean isSheriff() {
        return !isMerchant();
    }


    public void setSheriffRole() {
        isMerchant = false;
    }

    public void setMerchantRole() {
        isMerchant = true;
    }

    public void declareGoods() {
        this.merchant.declareGoods();
    }

    public int checkSack(IPlayer p) {
        return this.sheriff.checkSack(p);
    }

    public ISheriffStrategy getSheriff(){
        return this.sheriff;
    }


    public void setSheriff(AbstractSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public void setMerchant(AbstractMerchant merchant) {
        this.merchant = merchant;
    }


    public void sellGoods() {
        int profit = 0;
        List<Good> goodsList = merchant.getMerchantSack().selectedGoodsList;
        for (Good good : goodsList) {
            if(good.isValid() == true){
                profit += good.getProfit();
            }
            if(good.isLegal() == false){
                System.out.println("");
                profit += FactoryBonus.factoryBonus(good);
            }
        }
        computeProfit(profit);
    }

    public abstract void verifyMerchants();


    public void verifyMerchant(IPlayer sheriff, IPlayer p) {
        if (!p.isSheriff()) {
            p.setMerchantProfit();
            p.declareGoods();
            computeProfit(sheriff.checkSack(p));
        }

    }


    public static int getRandomNumberOfGoods() {

        double randomDouble = Math.random();
        randomDouble = randomDouble * 5 + 1;

        return (int) randomDouble;
    }

    public  void initializeMerchant(IPlayer sheriff, int round){
        this.merchant.setWhoIsSheriff(sheriff.getSheriff());
        this.merchant.setRound(round);
        this.setMerchantRole();
    }

    public void computeProfit(int p) {
        profit += p;
    }


}
