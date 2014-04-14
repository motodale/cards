/**
 * Created by Dale.
 */
public class StandardPlayingCard implements IPlayingCard{
    private Suit cardSuit;
    private Rank cardRank;

    //default
    public StandardPlayingCard(){
        cardSuit = Suit.SPADE;
        cardRank = Rank.ACE;
    }


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


    @Override
    public String toString() {

        return  getRankStr(cardRank) + " of " + getSuitStr(cardSuit);
    }
    private String getSuitStr(Suit cardSuit) {

        if (cardSuit.equals(Suit.HEART)) {
            return "Hearts";
        }
        if (cardSuit.equals(Suit.DIAMOND)) {
            return "Diamonds";
        }
        if (cardSuit.equals(Suit.SPADE)) {
            return "Spades";
        }
        if (cardSuit.equals(Suit.CLUB)) {
            return "Clubs";
        }
        else
            return "This is not the card you're looking for.";
    }

    private String getRankStr(Rank cardRank) {

        if (cardRank.equals(Rank.ACE)) {
            return "ACE";
        }
        if (cardRank.equals(Rank.TWO)) {
            return "TWO";
        }
        if (cardRank.equals(Rank.THREE)) {
            return "THREE";
        }
        if (cardRank.equals(Rank.FOUR)) {
            return "FOUR";
        }
        if (cardRank.equals(Rank.FIVE)) {
            return "FIVE";
        }
        if (cardRank.equals(Rank.SIX)) {
            return "SIX";
        }
        if (cardRank.equals(Rank.SEVEN)) {
            return "SEVEN";
        }
        if (cardRank.equals(Rank.EIGHT)) {
            return "EIGHT";
        }
        if (cardRank.equals(Rank.NINE)) {
            return "NINE";
        }
        if (cardRank.equals(Rank.TEN)) {
            return "TEN";
        }
        if (cardRank.equals(Rank.JACK)) {
            return "JACK";
        }
        if (cardRank.equals(Rank.QUEEN)) {
            return "QUEEN";
        }
        if (cardRank.equals(Rank.KING)) {
            return "KING";
        }
        else {
            return "ACE";
        }

    }






}
