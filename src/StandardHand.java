/**
 * Created by Dale.
 */
public class StandardHand extends StandardDeck implements IHand{
    @Override
    public int compareTo(IHand arg0){
        if(arg0.getClass() == this.getClass()){
            StandardHand otherHand = (StandardHand) arg0;

            if(this.myCards.size() < otherHand.myCards.size())
                return -1;
            else if(this.myCards.size() > otherHand.myCards.size())
                return 1;
            else
                return -;
        }
        return 0;
    }
}
