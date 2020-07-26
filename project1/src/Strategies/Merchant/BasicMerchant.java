package Strategies.Merchant;
import Cards.Good;
import Sacks.Sack;
import Strategies.Merchant.AbstractMerchant;


import java.util.*;

public class BasicMerchant extends AbstractMerchant {

    @Override
    public Sack createSack() {

        List<Good> selectedGoods = createLegalGoodsList();

        return new Sack(selectedGoods);

    }

    @Override
    public int giveBribe() {
        return 0;
    }

}
