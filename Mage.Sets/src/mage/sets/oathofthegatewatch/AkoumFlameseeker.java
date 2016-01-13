/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.oathofthegatewatch;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.DiscardCardCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.common.TapTargetCost;
import mage.abilities.effects.common.DoIfCostPaid;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.cards.CardImpl;
import mage.constants.AbilityWord;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.filter.common.FilterControlledPermanent;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.filter.predicate.permanent.TappedPredicate;
import mage.target.common.TargetControlledPermanent;

/**
 *
 * @author fireshoes
 */
public class AkoumFlameseeker extends CardImpl {

    private static final FilterControlledPermanent filter = new FilterControlledPermanent("an untapped Ally you control");

    static {
        filter.add(new SubtypePredicate("Ally"));
        filter.add(Predicates.not(new TappedPredicate()));
    }

    public AkoumFlameseeker(UUID ownerId) {
        super(ownerId, 101, "Akoum Flameseeker", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{2}{R}");
        this.expansionSetCode = "OGW";
        this.subtype.add("Human");
        this.subtype.add("Shaman");
        this.subtype.add("Ally");
        this.power = new MageInt(3);
        this.toughness = new MageInt(2);

        // <i>Cohort</i> &mdash; {T}, Tap an untapped Ally you control: Discard a card. If you do, draw a card.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, (new DoIfCostPaid(new DrawCardSourceControllerEffect(1), new DiscardCardCost())), new TapSourceCost());
        ability.addCost(new TapTargetCost(new TargetControlledPermanent(filter)));
        ability.setAbilityWord(AbilityWord.COHORT);
        this.addAbility(ability);
    }

    public AkoumFlameseeker(final AkoumFlameseeker card) {
        super(card);
    }

    @Override
    public AkoumFlameseeker copy() {
        return new AkoumFlameseeker(this);
    }
}