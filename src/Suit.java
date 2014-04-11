public enum Suit {
    HEART(1), DIAMOND(2), SPADE(3), CLUB(4);

    private int suitVal;

    Suit(int suitVal) {
        this.suitVal = suitVal;
    }

    public int getSuitVal() {
        return suitVal;
    }
}
