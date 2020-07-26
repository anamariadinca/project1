package Cards;

public class FactoryBonus {
    public static int factoryBonus(Good g) {
        if (g instanceof Silk)
        {
            Good cheese = new Cheese();
            return 3 * cheese.profit;
        }
        if (g instanceof Pepper)
        {
            Good chicken = new Chicken();
            return 2 * chicken.profit;
        }
        if (g instanceof Barrel){
            Good bread = new Bread();
            return 2 * bread.profit;
        }
        return 0;
    }
}
