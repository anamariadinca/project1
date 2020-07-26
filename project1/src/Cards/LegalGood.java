package Cards;

public abstract class LegalGood extends Good {

    public int getBonus(){
        return 0;
    }

    public boolean isLegal(){

        return true;
    }
}
