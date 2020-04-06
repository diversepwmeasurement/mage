package mage.cards.g;

import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.FightTargetsEffect;
import mage.abilities.keyword.CyclingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.TargetController;
import mage.filter.common.FilterCreaturePermanent;
import mage.target.common.TargetControlledCreaturePermanent;
import mage.target.common.TargetCreaturePermanent;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class GoForBlood extends CardImpl {

    private static final FilterCreaturePermanent filter
            = new FilterCreaturePermanent("creature you don't control");

    static {
        filter.add(TargetController.NOT_YOU.getControllerPredicate());
    }

    public GoForBlood(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{1}{R}");

        // Target creature you control fights target creature you don't control.
        this.getSpellAbility().addEffect(new FightTargetsEffect());
        this.getSpellAbility().addTarget(new TargetControlledCreaturePermanent());
        this.getSpellAbility().addTarget(new TargetCreaturePermanent(filter));

        // Cycling {1}
        this.addAbility(new CyclingAbility(new ManaCostsImpl("{1}")));
    }

    private GoForBlood(final GoForBlood card) {
        super(card);
    }

    @Override
    public GoForBlood copy() {
        return new GoForBlood(this);
    }
}
