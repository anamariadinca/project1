package Strategies.Merchant;

import Cards.Good;
import Players.AbstractPlayer;
import Sacks.Sack;
import Strategies.Merchant.AbstractMerchant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BribeMerchant extends AbstractMerchant {
    public Sack createSack() {
        goodsList = createGoodsList();
        int noOfGoodsToAddToSack = AbstractPlayer.getRandomNumberOfGoods();
        List<Good> selectedGoodsList = new ArrayList<>();
        if (((NO_OF_GOODS - countNumberOfLegalGoods()) > 0 && profit < 5) || ((NO_OF_GOODS - countNumberOfLegalGoods()) > 2 && profit < 10 || (NO_OF_GOODS == countNumberOfLegalGoods()))) {
            selectedGoodsList = createLegalGoodsList();
        } else {
            for (Iterator<Good> it = goodsList.iterator(); it.hasNext() && selectedGoodsList.size() < noOfGoodsToAddToSack;) {
                Good good = it.next();
                if (!good.isLegal()){
                    selectedGoodsList.add(good);
                    it.remove();
                }
            }
        }

        return new Sack(selectedGoodsList);
    }

    int countIllegalGoods(){
        int counter = 0;
        for(int i=0; i< getMerchantSack().selectedGoodsList.size();i++){
            if (!getMerchantSack().selectedGoodsList.get(i).isLegal()){
                counter++;
            }
        }
        return counter;
    }

    public int giveBribe() {
        if(whoIsSheriff.isBribeable()){
            if(countIllegalGoods() > 2){
                return 10;
            }
            else if(countIllegalGoods() >= 1){
                return 5;
            }
        }
        return 0;
    }

}
