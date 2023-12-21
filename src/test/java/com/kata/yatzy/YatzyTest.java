package com.kata.yatzy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class YatzyTest {

	@Test
	void chance() {
		assertEquals(15, Yatzy.chance(new DiceRoll(2, 3, 4, 5, 1)));
		assertEquals(16, Yatzy.chance(new DiceRoll(3, 3, 4, 5, 1)));
	}

	@Test
	void yatzy() {
		assertEquals(50, Yatzy.yatzy(new DiceRoll(4, 4, 4, 4, 4)));
		assertEquals(50, Yatzy.yatzy(new DiceRoll(6, 6, 6, 6, 6)));
		assertEquals(0, Yatzy.yatzy(new DiceRoll(6, 6, 6, 6, 3)));
	}

	@Test
	void ones() {
		assertEquals(1, Yatzy.ones(new DiceRoll(1, 2, 3, 4, 5)));
		assertEquals(2, Yatzy.ones(new DiceRoll(1, 2, 1, 4, 5)));
		assertEquals(0, Yatzy.ones(new DiceRoll(6, 2, 2, 4, 5)));
		assertEquals(4, Yatzy.ones(new DiceRoll(1, 2, 1, 1, 1)));
	}

	@Test
	void twos() {
		assertEquals(4, Yatzy.twos(new DiceRoll(1, 2, 3, 2, 6)));
		assertEquals(10, Yatzy.twos(new DiceRoll(2, 2, 2, 2, 2)));
	}

	@Test
	void threes() {
		assertEquals(6, Yatzy.threes(new DiceRoll(1, 2, 3, 2, 3)));
		assertEquals(12, Yatzy.threes(new DiceRoll(2, 3, 3, 3, 3)));
	}

	@Test
	void fours() {
		assertEquals(12, Yatzy.fours(new DiceRoll(4, 4, 4, 5, 5)));
		assertEquals(8, Yatzy.fours(new DiceRoll(4, 4, 5, 5, 5)));
		assertEquals(4, Yatzy.fours(new DiceRoll(4, 5, 5, 5, 5)));
	}

	@Test
	void fives() {
		assertEquals(10, Yatzy.fives(new DiceRoll(4, 4, 4, 5, 5)));
		assertEquals(15, Yatzy.fives(new DiceRoll(4, 4, 5, 5, 5)));
		assertEquals(20, Yatzy.fives(new DiceRoll(4, 5, 5, 5, 5)));
	}

	@Test
	void sixes() {
		assertEquals(0, Yatzy.sixes(new DiceRoll(4, 4, 4, 5, 5)));
		assertEquals(6, Yatzy.sixes(new DiceRoll(4, 4, 6, 5, 5)));
		assertEquals(18, Yatzy.sixes(new DiceRoll(6, 5, 6, 6, 5)));
	}

	@Test
	void onePair() {
		assertEquals(6, Yatzy.onePair(new DiceRoll(3, 4, 3, 5, 6)));
		assertEquals(10, Yatzy.onePair(new DiceRoll(5, 3, 3, 3, 5)));
		assertEquals(12, Yatzy.onePair(new DiceRoll(5, 3, 6, 6, 5)));

		assertEquals(8, Yatzy.onePair(new DiceRoll(3, 3, 3, 4, 4)));
		assertEquals(12, Yatzy.onePair(new DiceRoll(1, 1, 6, 2, 6)));
		assertEquals(6, Yatzy.onePair(new DiceRoll(3, 3, 3, 4, 1)));
		assertEquals(6, Yatzy.onePair(new DiceRoll(3, 3, 3, 3, 1)));

	}

	@Test
	void twoPairs() {
		assertEquals(16, Yatzy.twoPairs(new DiceRoll(3, 3, 5, 4, 5)));
		assertEquals(16, Yatzy.twoPairs(new DiceRoll(3, 3, 5, 5, 5)));

		assertEquals(8, Yatzy.twoPairs(new DiceRoll(1, 1, 2, 3, 3)));
		assertEquals(0, Yatzy.twoPairs(new DiceRoll(1, 1, 2, 3, 4)));
		assertEquals(6, Yatzy.twoPairs(new DiceRoll(1, 1, 2, 2, 2)));
		assertEquals(0, Yatzy.twoPairs(new DiceRoll(1, 1, 1, 1, 2)));
	}

	@Test
	void threeOfAKind() {
		assertEquals(9, Yatzy.threeOfAKind(new DiceRoll(3, 3, 3, 4, 5)));
		assertEquals(15, Yatzy.threeOfAKind(new DiceRoll(5, 3, 5, 4, 5)));
		assertEquals(9, Yatzy.threeOfAKind(new DiceRoll(3, 3, 3, 3, 5)));
		assertEquals(9, Yatzy.threeOfAKind(new DiceRoll(3, 3, 3, 3, 3)));
	}

	@Test
	void fourOfAKind() {
		assertEquals(12, Yatzy.fourOfAKind(new DiceRoll(3, 3, 3, 3, 5)));
		assertEquals(20, Yatzy.fourOfAKind(new DiceRoll(5, 5, 5, 4, 5)));
	}

	@Test
	void smallStraight() {
		assertEquals(15, Yatzy.smallStraight(new DiceRoll(1, 2, 3, 4, 5)));
		assertEquals(15, Yatzy.smallStraight(new DiceRoll(2, 3, 4, 5, 1)));
		assertEquals(0, Yatzy.smallStraight(new DiceRoll(1, 2, 2, 4, 5)));
	}

	@Test
	void largeStraight() {
		assertEquals(20, Yatzy.largeStraight(new DiceRoll(6, 2, 3, 4, 5)));
		assertEquals(20, Yatzy.largeStraight(new DiceRoll(2, 3, 4, 5, 6)));
		assertEquals(0, Yatzy.largeStraight(new DiceRoll(1, 2, 2, 4, 5)));
	}

	@Test
	void fullHouse() {
		assertEquals(18, Yatzy.fullHouse(new DiceRoll(6, 2, 2, 2, 6)));
		assertEquals(0, Yatzy.fullHouse(new DiceRoll(2, 3, 4, 5, 6)));

		assertEquals(7, Yatzy.fullHouse(new DiceRoll(1, 2, 1, 2, 1)));
		assertEquals(8, Yatzy.fullHouse(new DiceRoll(1, 1, 2, 2, 2)));
		assertEquals(0, Yatzy.fullHouse(new DiceRoll(2, 2, 3, 3, 4)));
		assertEquals(0, Yatzy.fullHouse(new DiceRoll(4, 4, 4, 4, 4)));

	}
}