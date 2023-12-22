package com.kata.yatzy;

import java.util.Optional;
import static com.kata.yatzy.YatziContant.*;

public final class YatzyScoring {

	private YatzyScoring() {
		throw new IllegalStateException("Static class");
	}

	public static int chance(DiceRoll roll) {
		return roll.sum();
	}

	public static int yatzy(DiceRoll roll) {
		return roll.matchYatzy().map(o -> YATZI_SCORE).orElse(ZERO_SCORE);
	}

	public static int ones(DiceRoll roll) {
		return roll.getOccurence(1) * 1;
	}

	public static int twos(DiceRoll roll) {
		return roll.getOccurence(2) * 2;

	}

	public static int threes(DiceRoll roll) {
		return roll.getOccurence(3) * 3;

	}

	public static int fours(DiceRoll roll) {
		return roll.getOccurence(4) * 4;
	}

	public static int fives(DiceRoll roll) {
		return roll.getOccurence(5) * 5;
	}

	public static int sixes(DiceRoll roll) {
		return roll.getOccurence(6) * 6;
	}

	public static int onePair(DiceRoll roll) {
		return roll.findMaxByOccurenceGTE(2).map(value -> 2 * value).orElse(ZERO_SCORE);
	}

	public static int twoPairs(DiceRoll roll) {
		Optional<Integer> firstPairScore = roll.findMaxByOccurenceGTE(2);
		if (firstPairScore.isEmpty())
			return ZERO_SCORE;
		Optional<Integer> secondPairScore = roll.getRemainingPair(firstPairScore.get());
		if (secondPairScore.isEmpty())
			return ZERO_SCORE;
		return 2 * firstPairScore.get() + 2 * secondPairScore.get();
	}

	public static int threeOfAKind(DiceRoll roll) {
		return roll.findMaxByOccurenceGTE(3).map(value -> 3 * value).orElse(ZERO_SCORE);
	}

	public static int fourOfAKind(DiceRoll roll) {
		return roll.findMaxByOccurenceGTE(4).map(value -> 4 * value).orElse(ZERO_SCORE);
	}

	public static int smallStraight(DiceRoll roll) {
		return roll.isSmallStraight() ? SMALL_STRAIGHT_SCORE : ZERO_SCORE;
	}

	public static int largeStraight(DiceRoll roll) {
		return roll.isLargeStraight() ? LARGE_STRAIGHT_CONSTANT : ZERO_SCORE;
	}

	public static int fullHouse(DiceRoll roll) {
		Optional<Integer> threeOfAKind = roll.findMaxByOccurenceGTE(3);
		if (threeOfAKind.isEmpty())
			return ZERO_SCORE;
		Optional<Integer> pair = roll.getRemainingPair(threeOfAKind.get());
		if (pair.isEmpty())
			return ZERO_SCORE;
		return 3 * threeOfAKind.get() + 2 * pair.get();
	}
}
