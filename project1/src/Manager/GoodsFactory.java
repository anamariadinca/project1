package Manager;

import Cards.*;

public class GoodsFactory {
    public static Good createGood(int id){
        switch (id){
            case 0: return new Apple(); //break;
            case 1: return new Cheese(); //break;
            case 2: return new Bread(); //break;
            case 3: return new Chicken(); //break;
            case 10: return new Silk(); //break;
            case 11: return new Pepper(); //break;
            case 12: return new Barrel(); //break;
            default: return null;
        }
    }

}
