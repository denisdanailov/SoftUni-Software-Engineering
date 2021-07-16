package WorkWithAbstraction_Exercise.CardWithPower;

public class Card {
    private SuitPower suitPower;
    private RankPower rankPower;
    private int power;

    public Card(SuitPower suitPower, RankPower rankPower) {
        this.suitPower = suitPower;
        this.rankPower = rankPower;

    }

    public int getPower() {
        return this.suitPower.getSuitPower() + this.rankPower.getPowerRank();
    }

    public SuitPower getSuitPower() {
        return this.suitPower;
    }

    public RankPower getRankPower() {
        return this.rankPower;
    }
}
