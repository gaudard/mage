
package mage.cards.t;

import java.util.UUID;
import mage.abilities.effects.common.continuous.GainAbilityControlledEffect;
import mage.abilities.keyword.ShroudAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.filter.common.FilterCreaturePermanent;

/**
 *
 * @author North
 */
public final class TortoiseFormation extends CardImpl {

    public TortoiseFormation(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.INSTANT},"{3}{U}");


        // Creatures you control gain shroud until end of turn.
        this.getSpellAbility().addEffect(new GainAbilityControlledEffect(ShroudAbility.getInstance(), Duration.EndOfTurn, new FilterCreaturePermanent()));
    }

    public TortoiseFormation(final TortoiseFormation card) {
        super(card);
    }

    @Override
    public TortoiseFormation copy() {
        return new TortoiseFormation(this);
    }
}
