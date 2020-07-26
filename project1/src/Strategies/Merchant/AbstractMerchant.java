package Strategies.Merchant;

import Cards.Good;
import Cards.LegalGood;
import Manager.GoodsFactory;
import Manager.GoodsManager;
import Players.AbstractPlayer;
import Sacks.Sack;
import Strategies.Sheriff.ISheriffStrategy;

import java.util.*;

public abstract class AbstractMerchant implements IMerchantStrategy {

    public static final int NO_OF_GOODS = 6;
    int round;
    int profit;
    ISheriffStrategy whoIsSheriff;

    public void setWhoIsSheriff(ISheriffStrategy sheriff){
        this.whoIsSheriff = sheriff;
    }

        public ISheriffStrategy currentSheriff(){
        return this.whoIsSheriff;
    }

    List<Good> createGoodsList() {

        List<Good> goodsList = new ArrayList<>();
        while (goodsList.size() < 6) {
            getGoods(goodsList);
        }
        return goodsList;
    }

    protected List<Good> goodsList;

    private Sack merchantSack;

    public void setProfit(int profit){
        this.profit = profit;
    }

    protected List<Good> extractLegalGoods(int noOfGoodsToAddToSack, int noOfLegalGoods) {

        List<Good> selectedGoods = new LinkedList<>();
        for (Iterator<Good> it = goodsList.iterator(); it.hasNext() && selectedGoods.size() < noOfGoodsToAddToSack && selectedGoods.size() < noOfLegalGoods; ) {

            Good good = it.next();

            if (good.isLegal()) {
                selectedGoods.add(good);
                it.remove();
            }
        }

        return selectedGoods;
    }

    protected int countNumberOfLegalGoods() {
        int noOfLegalGoods = 0;
        for (Good currentGood : goodsList) {
            if (currentGood.isLegal()) {
                noOfLegalGoods++;
            }
        }
        return noOfLegalGoods;
    }

    protected List<Good> createLegalGoodsList(){
        List<Good> selectedGoods = null;
        goodsList = createGoodsList();
        int noOfGoodsToAddToSack = AbstractPlayer.getRandomNumberOfGoods();
        int noOfLegalGoods = countNumberOfLegalGoods();

        if (noOfLegalGoods == 0) {
            selectedGoods.add(extractGoodWithMaxProfit());
            return selectedGoods;

        } else {

            selectedGoods = extractLegalGoods(noOfGoodsToAddToSack, noOfLegalGoods);
        }
        return selectedGoods;
    }


    public void setRound(int round){
        this.round = round;
    }


    Map<Integer, Integer> createInventory() {
        Map<Integer, Integer> inventory = new HashMap<>();
        for (Good currentGood : getMerchantSack().selectedGoodsList) {
            Integer key = currentGood.getId();
            if (currentGood.isLegal()) {
                if (inventory.containsKey(key) == true) {
                    inventory.put(currentGood.getId(), inventory.get(currentGood.getId()) + 1);
                } else {
                    inventory.put(currentGood.getId(), 1);
                }
            }
        }
        return inventory;
    }

    public String getName(int id) {
        for (Good currentGood : getMerchantSack().selectedGoodsList) {
            if (currentGood.getId() == id) return currentGood.getName();
        }
        return null;
    }

    String countFrequency(Map<Integer, Integer> inventory) {
        int mostEncountered = 0;
        String nameMostEncountered = null;
        for (Integer key : inventory.keySet()){
            if(inventory.get(key) > mostEncountered){
                mostEncountered = inventory.get(key);
                nameMostEncountered = getName(key);
            }
            else if( mostEncountered == inventory.get(key)){
                if(GoodsFactory.createGood(key).getProfit() >= GoodsFactory.createGood(mostEncountered).getProfit()){
                    mostEncountered = inventory.get(key);
                    nameMostEncountered = getName(key);
                }
            }
        }

        return nameMostEncountered;

    }

    protected Good extractGoodWithMaxProfit() {
        int max = 0;
        Good goodWithMaxProfit = null;
        for (Good currentGood : goodsList) {
            if (currentGood.getProfit() > max) {
                max = currentGood.getProfit();
                goodWithMaxProfit = currentGood;
            }
        }

        goodsList.remove(goodWithMaxProfit);

        return goodWithMaxProfit;
    }

    public void setMerchantSack(Sack merchantSack){
        this.merchantSack = merchantSack;
    }

    public Sack getMerchantSack() {
        return merchantSack;

    }

    public void getGoods(List<Good> goodsList) {
        goodsList.add(GoodsManager.getNextAvailableGood());
    }

    public void declareGoods() {
        Map<Integer, Integer> inventory = createInventory();
        String frequentName = countFrequency(inventory);
        for (int i = 0; i < getMerchantSack().selectedGoodsList.size(); i++) {
            if (getMerchantSack().selectedGoodsList.get(i) instanceof LegalGood) {
                getMerchantSack().selectedGoodsList.get(i).setName(frequentName);
            } else {
                getMerchantSack().selectedGoodsList.get(i).setName("Apple");
            }
        }

    }

    public abstract Sack createSack();

    public abstract int giveBribe();

}
