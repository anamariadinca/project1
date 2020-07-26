package Players;

import Strategies.Sheriff.AbstractSheriff;
import Strategies.Sheriff.ISheriffStrategy;

public interface ISheriffBehaviour {
    int checkSack(IPlayer p);
    ISheriffStrategy getSheriff();
    void setSheriff(AbstractSheriff sheriff);
    void verifyMerchants();
    void verifyMerchant(IPlayer sheriff, IPlayer p);

}
