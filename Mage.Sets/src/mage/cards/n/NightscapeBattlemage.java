
package mage.cards.n;

import java.util.UUID;
import mage.MageInt;
import mage.ObjectColor;
import mage.abilities.TriggeredAbility;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.condition.common.KickedCostCondition;
import mage.abilities.decorator.ConditionalTriggeredAbility;
import mage.abilities.effects.common.DestroyTargetEffect;
import mage.abilities.effects.common.ReturnToHandTargetEffect;
import mage.abilities.keyword.KickerAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.ColorPredicate;
import mage.target.common.TargetCreaturePermanent;
import mage.target.common.TargetLandPermanent;

/**
 *
 * @author LoneFox

 */
public final class NightscapeBattlemage extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("up to two nonblack creatures");

    static {
        filter.add(Predicates.not(new ColorPredicate(ObjectColor.BLACK)));
    }

    public NightscapeBattlemage(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{B}");
        this.subtype.add(SubType.ZOMBIE);
        this.subtype.add(SubType.WIZARD);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Kicker {2}{U} and/or {2}{R}
        KickerAbility kickerAbility = new KickerAbility("{2}{U}");
        kickerAbility.addKickerCost("{2}{R}");
        this.addAbility(kickerAbility);
        // When Nightscape Battlemage enters the battlefield, if it was kicked with its {2}{U} kicker, return up to two target nonblack creatures to their owners' hands.
        TriggeredAbility ability = new EntersBattlefieldTriggeredAbility(new ReturnToHandTargetEffect(), false);
        ability.addTarget(new TargetCreaturePermanent(0, 2, filter, false));
        this.addAbility(new ConditionalTriggeredAbility(ability, new KickedCostCondition("{2}{U}"),
            "When {this} enters the battlefield, if it was kicked with its {2}{U} kicker, return up to two target nonblack creatures to their owners' hands."));
        // When Nightscape Battlemage enters the battlefield, if it was kicked with its {2}{R} kicker, destroy target land.
        ability = new EntersBattlefieldTriggeredAbility(new DestroyTargetEffect(), false);
        ability.addTarget(new TargetLandPermanent());
        this.addAbility(new ConditionalTriggeredAbility(ability, new KickedCostCondition("{2}{R}"),
            "When {this} enters the battlefield, if it was kicked with its {2}{R} kicker, destroy target land."));
    }

    public NightscapeBattlemage(final NightscapeBattlemage card) {
        super(card);
    }

    @Override
    public NightscapeBattlemage copy() {
        return new NightscapeBattlemage(this);
    }
}
