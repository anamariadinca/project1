package Manager;

import Cards.Good;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GoodsManager {

    public static Queue<Good> initialGoodsList = new LinkedList<>();


    public static void createGoodsQueue(List<Integer> goodsIds) {

        for (int i = 0; i < goodsIds.size(); i++) {
            initialGoodsList.add(GoodsFactory.createGood(goodsIds.get(i)));
        }
    }

    public static Good getNextAvailableGood() {

        Good g = initialGoodsList.poll();

        return g;
    }

}
