
import java.util.ArrayList;

/**
 * Created by Dale.
 */
public class StandardDeck implements IDeckOfCards {
    protected ArrayList<IPlayingCard> myCards;
    private ArrayList<Suit> suitList = new ArrayList<Suit>();
    private ArrayList<Rank> rankList = new ArrayList<Rank>();



    public StandardDeck(){
       myCards = new ArrayList<IPlayingCard>();
       suitList = getListOfSuits();
       rankList = getListOfRanks();
        for(int j = 0; j<4; j++){
            for(int i = 0; i <= 12; i++){
                myCards.add(new StandardPlayingCard(suitList.get(j), rankList.get(i)));
            }
        }
    }
    private ArrayList<Suit> getListOfSuits() {
        suitList.add(0, Suit.HEART);
        suitList.add(1, Suit.DIAMOND);
        suitList.add(2, Suit.SPADE);
        suitList.add(3, Suit.CLUB);
        return suitList;
    }

    private ArrayList<Rank> getListOfRanks(){
        rankList.add(0, Rank.ACE);
        rankList.add(1, Rank.TWO);
        rankList.add(2, Rank.THREE);
        rankList.add(3, Rank.FOUR);
        rankList.add(4, Rank.FIVE);
        rankList.add(5, Rank.SIX);
        rankList.add(6, Rank.SEVEN);
        rankList.add(7, Rank.EIGHT);
        rankList.add(8, Rank.NINE);
        rankList.add(9, Rank.TEN);
        rankList.add(10, Rank.JACK);
        rankList.add(11, Rank.QUEEN);
        rankList.add(12, Rank.KING);
        return rankList;
    }


    @Override
    public IPlayingCard drawCard(){
        IPlayingCard topCard = myCards.get(0);
//        try {
//            myCards.remove(0);
//            return topCard;
//        }catch (ArrayIndexOutOfBoundsException e){
//            return ;
//        }
        myCards.remove(0);
        return topCard;
    }

    @Override
    public IHand[] dealCards(int numOfHands){
        StandardHand[] someHand = new StandardHand[numOfHands];
        int counter = 0;
        while (!this.isEmpty()) {
            someHand[counter].add(this.drawCard());
            counter += 1;
            if (counter >= numOfHands){
                counter = 0;
            }
        }
        return someHand;
    }

    @Override
    public IHand[] dealCards(int numOfHands, int numOfCards){
        StandardHand[] someHand = new StandardHand[numOfHands];
        int totalCards= 0;
        int counter = 0;
        while (!this.isEmpty() && (totalCards <= (numOfCards * numOfHands))) {
            someHand[counter].add(this.drawCard());
            counter += 1;
            if (counter >= numOfHands){
                counter = 0;
                totalCards = 0;
            }
        }
        return someHand;

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

        for(int j = 0; j < 4; j++){
            for(int i = 0; i <= 12; i++)
                myCards.add(new StandardPlayingCard(suitList.get(j), rankList.get(i)));
        }

    }

    @Override
    public void add(IPlayingCard[] cardsToAdd){
        for(IPlayingCard aCard : cardsToAdd){
            add(aCard);
        }

    }
    @Override
    public void add(IPlayingCard cardToAdd){
        myCards.add(cardToAdd);
    }

    @Override
    public void add(IDeckOfCards cardsToAdd){
        while (!cardsToAdd.isEmpty()){
            add(cardsToAdd.drawCard());
        }
    }



}