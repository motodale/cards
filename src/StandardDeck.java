
import java.util.ArrayList;

/**
 * Created by Dale.
 */
public class StandardDeck implements IDeckOfCards {
    ArrayList<IPlayingCard> myCards;

    public StandardDeck(){
        myCards = new ArrayList<IPlayingCard>();

        for(int j = 0; j<4; j++){
            for(int i = 1; i <= 13; i++){
                myCards.add(new StandardPlayingCard());
            }
        }
        for(int i = 0; i < 52; i++){
            myCards.add(new StandardPlayingCard());
        }
    }


    @Override
    public IPlayingCard drawCard(){
        IPlayingCard topCard = myCards.get(0);
        myCards.remove(0);

        return topCard;
    }

    @Override
    public void addCard(IPlayingCard cardToAdd){
        myCards.add(cardToAdd);
    }

    @Override
    public void shuffle(){
        java.util.Collections.shuffle(myCards);
    }

    @Override
    public void sort(){
        java.util.Collections.sort(myCards);
    }

    @Override
    public String toString(){
        StringBuffer output = new StringBuffer();

        for(IPlayingCard aCard: myCards){
            output.append(aCard.toString() + " ");
        }

        return output.toString();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void reset(){
        myCards = new ArrayList<IPlayingCard>();

        for(int j = 0; j < 5; j++){
            for(int i = 0; i <= 12; i++)
                myCards.add(new StandardPlayingCard(String.valueOf(i)));
        }
        for(int i = 0; i < 20; i++)
            myCards.add(new StandardPlayingCard(Rank.ACE, Suit.SPADE));
    }

    @Override
    public void add(IPlayingCard[] cardsToAdd){

    }

    @Override
    public void add(IDeckOfCards cardsToAdd){

    }



}