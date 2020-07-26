package Strategies.Merchant;

import Cards.Good;
import Sacks.Sack;
import Strategies.Sheriff.ISheriffStrategy;

import java.util.List;

public interface IMerchantStrategy {
    Sack createSack();

    int giveBribe();
    void declareGoods();
    Sack getMerchantSack();
    void getGoods(List<Good> goodsList);
    void setMerchantSack(Sack merchantSack);
    void setRound(int round);
    void setProfit(int profit);
    void setWhoIsSheriff(ISheriffStrategy sheriff);


}
