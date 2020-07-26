package Cards;

public abstract class Good {

    protected int id;
    protected String name;
    protected int profit;
    protected int penalty;
    protected boolean isValid = true;

    public int getProfit(){
        return profit;
    }

    public int getPenalty(){
        return penalty;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void notValid(){
        this.isValid = false;
    }

    public boolean isValid(){
        return isValid;
    }

    public String getName() {
        return this.name;
    }

    public String getName(int id){
        switch (id){
            case 0: return "Apple"; //break;
            case 1: return "Cheese"; //break;
            case 2: return "Bread"; //break;
            case 3: return "Chicken"; //break;
            case 10: return "Silk"; //break;
            case 11: return "Pepper"; //break;
            case 12: return "Barrel"; //break;
            default: return null;
        }
    }

//    abstract int getBonus();

    public abstract boolean isLegal();
}
