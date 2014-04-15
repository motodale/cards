import java.util.ArrayList;

/**
 * Created by daletibbetts.
 */
public class WarHand extends WarDeck implements IHand {
    public WarHand(){

    }

    @Override
    public int compareTo(IHand arg0){
        if(arg0.getClass() == this.getClass()){
            WarHand otherHand = (WarHand) arg0;

            if(this.myCards.size() < otherHand.myCards.size())
                return -1;
            else if(this.myCards.size() > otherHand.myCards.size())
                return 1;
            else
                return 0;
        }
        return 0;
    }
    @Override
    public void reset(){
        myCards.clear();
    }
}
