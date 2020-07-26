package Cards;

public abstract class IllegalGood extends Good {
//    public int getBonus(){
//        return FactoryBonus.factoryBonus(this);
//    }

    public boolean isLegal(){

        return false;
    }
}
