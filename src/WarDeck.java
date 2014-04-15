import java.util.ArrayList;

/**
 * Created by daletibbetts.
 */
public class WarDeck extends StandardDeck {
    protected ArrayList<IPlayingCard> warCards;
    private ArrayList<Suit> suitList = new ArrayList<Suit>();
    private ArrayList<Rank> rankList = new ArrayList<Rank>();

    public WarDeck(){

        warCards = new ArrayList<IPlayingCard>();
        suitList = getListOfSuits();
        rankList = getListOfRanks();
        for(int j = 0; j<4; j++){
            for(int i = 0; i <= 12; i++){
                warCards.add(new WarCard(suitList.get(j), rankList.get(i)));
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
    public IHand[] dealCards(int numOfHands){
        WarHand[] someHand = new WarHand[numOfHands];

        this.shuffle();
        for(int i = 0; i<=25; i++){
            someHand[0].add(this.drawCard());
        }
        for(int j =26; j <= 51; j++){
            someHand[1].add(this.drawCard());
        }

        return someHand;
    }


}
