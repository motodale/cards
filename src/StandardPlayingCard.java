import java.nio.channels.AlreadyConnectedException;

/**
 * Created by Dale.
 */
public class StandardPlayingCard implements IPlayingCard{
    private Suit cardSuit;
    private Rank cardRank;

    public StandardPlayingCard(){
        cardSuit = Suit.SPADE;
        cardRank = Rank.ACE;
    }

    //default
    public StandardPlayingCard(Suit aSuit, Rank aRank){
        cardSuit = aSuit;
        cardRank = aRank;
    }
    @Override
    public int compareTo(IPlayingCard ipc) {
        if (ipc.getClass() == this.getClass()) {
            StandardPlayingCard anotherCard = (StandardPlayingCard) ipc;

            if (this.cardRank.getNumVal() < anotherCard.cardRank.getNumVal())
                return -1;
            else if (this.cardRank.getNumVal() > anotherCard.cardRank.getNumVal())
                return 1;
            else
                return 0;

        }
        else {
            return -1;
        }
    }
}




