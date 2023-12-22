package com.kata.yatzy;

import static com.kata.yatzy.YatziCategory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class YatzyScoringTest {

	@ParameterizedTest
	@MethodSource("chanceCategory")
	void chance(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, CHANCE.score(roll));
	}

	private static Stream<Arguments> chanceCategory() {
		return Stream.of(Arguments.of(15, new DiceRoll(2, 3, 4, 5, 1)), Arguments.of(16, new DiceRoll(3, 3, 4, 5, 1)));
	}

	@ParameterizedTest
	@MethodSource("yatzyCategory")
	void yatzy(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, YATZY.score(roll));
	}

	private static Stream<Arguments> yatzyCategory() {
		return Stream.of(Arguments.of(50, new DiceRoll(4, 4, 4, 4, 4)), Arguments.of(50, new DiceRoll(6, 6, 6, 6, 6)),
				Arguments.of(0, new DiceRoll(6, 6, 6, 6, 3)));
	}

	@ParameterizedTest
	@MethodSource("onesCategory")
	void ones(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, ONES.score(roll));
	}

	private static Stream<Arguments> onesCategory() {
		return Stream.of(Arguments.of(1, new DiceRoll(1, 2, 3, 4, 5)), Arguments.of(2, new DiceRoll(1, 2, 1, 4, 5)),
				Arguments.of(0, new DiceRoll(6, 2, 2, 4, 5)), Arguments.of(4, new DiceRoll(1, 2, 1, 1, 1)));
	}

	@ParameterizedTest
	@MethodSource("twosCategory")
	void twos(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, TWOS.score(roll));
	}

	private static Stream<Arguments> twosCategory() {
		return Stream.of(Arguments.of(4, new DiceRoll(1, 2, 3, 2, 6)), Arguments.of(10, new DiceRoll(2, 2, 2, 2, 2)));
	}

	@ParameterizedTest
	@MethodSource("threesCategory")
	void threes(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, THREES.score(roll));
	}

	private static Stream<Arguments> threesCategory() {
		return Stream.of(Arguments.of(6, new DiceRoll(1, 2, 3, 2, 3)), Arguments.of(12, new DiceRoll(2, 3, 3, 3, 3)));
	}

	@ParameterizedTest
	@MethodSource("foursCategory")
	void fours(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, FOURS.score(roll));
	}

	private static Stream<Arguments> foursCategory() {
		return Stream.of(Arguments.of(12, new DiceRoll(4, 4, 4, 5, 5)), Arguments.of(8, new DiceRoll(4, 4, 5, 5, 5)),
				Arguments.of(4, new DiceRoll(4, 5, 5, 5, 5)));
	}

	@ParameterizedTest
	@MethodSource("fivesCategory")
	void fives(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, FIVES.score(roll));
	}

	private static Stream<Arguments> fivesCategory() {
		return Stream.of(Arguments.of(10, new DiceRoll(4, 4, 4, 5, 5)), Arguments.of(15, new DiceRoll(4, 4, 5, 5, 5)),
				Arguments.of(20, new DiceRoll(4, 5, 5, 5, 5)));
	}

	@ParameterizedTest
	@MethodSource("sixesCategory")
	void sixes(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, SIXES.score(roll));
	}

	private static Stream<Arguments> sixesCategory() {
		return Stream.of(Arguments.of(0, new DiceRoll(4, 4, 4, 5, 5)), Arguments.of(6, new DiceRoll(4, 4, 6, 5, 5)),
				Arguments.of(18, new DiceRoll(6, 5, 6, 6, 5)));
	}

	@ParameterizedTest
	@MethodSource("onePairCategory")
	void onePair(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, ONE_PAIR.score(roll));
	}

	private static Stream<Arguments> onePairCategory() {
		return Stream.of(Arguments.of(6, new DiceRoll(3, 4, 3, 5, 6)), Arguments.of(10, new DiceRoll(5, 3, 3, 3, 5)),
				Arguments.of(12, new DiceRoll(5, 3, 6, 6, 5)), Arguments.of(8, new DiceRoll(3, 3, 3, 4, 4)),
				Arguments.of(12, new DiceRoll(1, 1, 6, 2, 6)), Arguments.of(6, new DiceRoll(3, 3, 3, 4, 1)));
	}

	@ParameterizedTest
	@MethodSource("twoPairsCategory")
	void twoPairs(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, TWO_PAIRS.score(roll));
	}

	private static Stream<Arguments> twoPairsCategory() {
		return Stream.of(Arguments.of(16, new DiceRoll(3, 3, 5, 4, 5)), Arguments.of(16, new DiceRoll(3, 3, 5, 5, 5)),
				Arguments.of(8, new DiceRoll(1, 1, 2, 3, 3)), Arguments.of(0, new DiceRoll(1, 1, 2, 3, 4)),
				Arguments.of(6, new DiceRoll(1, 1, 2, 2, 2)), Arguments.of(0, new DiceRoll(1, 1, 1, 1, 2)));
	}

	@ParameterizedTest
	@MethodSource("threeOfKindCategory")
	void threeOfAKind(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, THREE_OF_KIND.score(roll));
	}

	private static Stream<Arguments> threeOfKindCategory() {
		return Stream.of(Arguments.of(9, new DiceRoll(3, 3, 3, 4, 5)), Arguments.of(15, new DiceRoll(5, 3, 5, 4, 5)),
				Arguments.of(9, new DiceRoll(3, 3, 3, 3, 5)), Arguments.of(9, new DiceRoll(3, 3, 3, 3, 3)),
				Arguments.of(0, new DiceRoll(3, 3, 4, 4, 5)));
	}

	@ParameterizedTest
	@MethodSource("fourOfKindCategory")
	void fourOfAKind(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, FOUR_OF_KIND.score(roll));
	}

	private static Stream<Arguments> fourOfKindCategory() {
		return Stream.of(Arguments.of(12, new DiceRoll(3, 3, 3, 3, 5)), Arguments.of(20, new DiceRoll(5, 5, 5, 4, 5)));
	}

	@ParameterizedTest
	@MethodSource("smallStraightCategory")
	void smallStraight(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, SMALL_STRAIGHT.score(roll));
	}

	private static Stream<Arguments> smallStraightCategory() {
		return Stream.of(Arguments.of(15, new DiceRoll(1, 2, 3, 4, 5)), Arguments.of(15, new DiceRoll(2, 3, 4, 5, 1)),
				Arguments.of(0, new DiceRoll(1, 2, 2, 4, 5)));
	}

	@ParameterizedTest
	@MethodSource("largeStraightCategory")
	void largeStraight(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, LARGE_STRAIGHT.score(roll));
	}

	private static Stream<Arguments> largeStraightCategory() {
		return Stream.of(Arguments.of(20, new DiceRoll(6, 2, 3, 4, 5)), Arguments.of(20, new DiceRoll(2, 3, 4, 5, 6)),
				Arguments.of(0, new DiceRoll(1, 2, 2, 4, 5)));
	}

	@ParameterizedTest
	@MethodSource("fullHouseCategory")
	void fullHouse(Integer expectedScore, DiceRoll roll) {
		assertEquals(expectedScore, FULL_HOUSE.score(roll));
	}

	private static Stream<Arguments> fullHouseCategory() {
		return Stream.of(Arguments.of(18, new DiceRoll(6, 2, 2, 2, 6)), Arguments.of(0, new DiceRoll(2, 3, 4, 5, 6)),
				Arguments.of(7, new DiceRoll(1, 2, 1, 2, 1)), Arguments.of(8, new DiceRoll(1, 1, 2, 2, 2)),
				Arguments.of(0, new DiceRoll(2, 2, 3, 3, 4)), Arguments.of(0, new DiceRoll(4, 4, 4, 4, 4)));
	}
}
