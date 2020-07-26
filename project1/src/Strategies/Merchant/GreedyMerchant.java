package Strategies.Merchant;

import Cards.Good;
import Sacks.Sack;
import Strategies.Merchant.AbstractMerchant;

import java.util.List;

public class GreedyMerchant extends AbstractMerchant {

    @Override
    public Sack createSack(){

        List<Good> selectedGoodsList = createLegalGoodsList();
        if((round % 2 != 0) && (selectedGoodsList.size() < 5)){
            selectedGoodsList.add(extractGoodWithMaxProfit());
        }
        return new Sack(selectedGoodsList);
    }

    @Override
    public int giveBribe(){
        return 0;
    }

}
