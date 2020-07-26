package Sacks;

import Cards.Good;

import java.util.List;

public class Sack {

    public Sack(){
    }
    public List<Good> selectedGoodsList;
    public Sack(List<Good> selectedGoodsList){
        this.selectedGoodsList = selectedGoodsList;
    }

}
