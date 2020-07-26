package Players;

import Sacks.Sack;

public interface IMerchantBehaviour {
    void setMerchantProfit();
    int giveBribe();
    Sack getSack();
    void setSack(Sack sack);
    void declareGoods();
    void sellGoods();
    void initializeMerchant(IPlayer sheriff, int round);
}
