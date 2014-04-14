import java.util.ArrayList;

/**
 * Created by Dale.
 */
public class StandardHand extends StandardDeck implements IHand{

    public StandardHand(){
        //StandardHan;
    }




    @Override
    public int compareTo(IHand arg0){
        if(arg0.getClass() == this.getClass()){
            StandardHand otherHand = (StandardHand) arg0;

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
