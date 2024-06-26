package mage.game.events;

import mage.util.CardUtil;

import java.util.UUID;

/**
 * @author TheElk801
 **/
public class CoinFlippedEvent extends GameEvent {

    private final boolean result;
    private final boolean chosen;
    private final boolean winnable;
    private final int flipCount; // Number of flips that lead to this event. see [[Krark's Thumb]]

    CoinFlippedEvent(UUID playerId, UUID sourceId, int flipCount, boolean result, boolean chosen, boolean winnable) {
        super(GameEvent.EventType.COIN_FLIPPED, playerId, sourceId, playerId);
        this.result = result;
        this.chosen = chosen;
        this.winnable = winnable;
        this.flipCount = flipCount;
    }

    public boolean getResult() {
        return result;
    }

    public int getFlipCount() {
        return flipCount;
    }

    public String getResultName() {
        return CardUtil.booleanToFlipName(result);
    }

    public boolean getChosen() {
        return chosen;
    }

    public String getChosenName() {
        return CardUtil.booleanToFlipName(chosen);
    }

    public boolean isWinnable() {
        return winnable;
    }

    public boolean wasWon() {
        return result == chosen;
    }
}
