import java.nio.channels.AlreadyConnectedException;

/**
 * Created by Dale.
 */
public class StandardPlayingCard implements IPlayingCard{
    private Suit cardSuit;
    private Rank cardRank;

    public StandardPlayingCard(Rank aRank, Suit aSuit){
        aSuit = SPADE;
        aRank = ACE;
    }

    //default
    public StandardPlayingCard(Suit aSuit, Rank aRank){
        suit = aSuit;
        rank = aRank;
    }
    @Override
    public int compareTo(IPlayingCard it) {
        if (it.getClass() == this.getClass()) {
            StandardPlayingCard anotherCard = (StandardPlayingCard) it;

            if (this.cardRank < anotherCard.cardRank)
                return -1;
            else if (this.cardRank > anotherCard.cardRank)
                return 1;
            else
                return 0;

        }
        else {
            return -1;
        }
    }
}




