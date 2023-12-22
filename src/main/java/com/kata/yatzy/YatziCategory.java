package com.kata.yatzy;

import java.util.function.Function;

public enum YatziCategory {
	CHANCE(YatzyScoring::chance), YATZY(YatzyScoring::yatzy), ONES(YatzyScoring::ones), TWOS(YatzyScoring::twos),
	THREES(YatzyScoring::threes), FOURS(YatzyScoring::fours), FIVES(YatzyScoring::fives), SIXES(YatzyScoring::sixes),
	ONE_PAIR(YatzyScoring::onePair), TWO_PAIRS(YatzyScoring::twoPairs), THREE_OF_KIND(YatzyScoring::threeOfAKind),
	FOUR_OF_KIND(YatzyScoring::fourOfAKind), SMALL_STRAIGHT(YatzyScoring::smallStraight),
	LARGE_STRAIGHT(YatzyScoring::largeStraight), FULL_HOUSE(YatzyScoring::fullHouse);

	private final Function<DiceRoll, Integer> scoringFunction;

	YatziCategory(Function<DiceRoll, Integer> scoreFunction) {
		this.scoringFunction = scoreFunction;
	}

	public int score(DiceRoll roll) {
		return this.scoringFunction.apply(roll);
	}
}