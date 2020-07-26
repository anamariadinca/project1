package Players;

public interface IPlayer extends IMerchantBehaviour, ISheriffBehaviour {
    boolean isMerchant();
    boolean isSheriff();
    void setSheriffRole();
    void setMerchantRole();
    void setProfit(int profit);
    int getProfit();
    String getType();
    void setType(String type);
}
