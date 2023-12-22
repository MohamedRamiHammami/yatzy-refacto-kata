package com.kata.yatzy;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DiceRoll {
	private static final List<Integer> LARGE_STRAIGHT = Arrays.asList(2, 3, 4, 5, 6);
	private static final List<Integer> SMALL_STRAIGHT = Arrays.asList(1, 2, 3, 4, 5);
	private final List<Integer> dices;

	public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
		this.dices = Arrays.asList(d1, d2, d3, d4, d5);
	}

	public int sum() {
		return dices.stream().mapToInt(Integer::intValue).sum();
	}

	public Optional<Long> matchYatzy() {
		return occurenceByDice().values().stream().filter(count -> count == 5).findFirst();
	}

	public int getOccurence(int value) {
		return occurenceByDice().getOrDefault(value, 0L).intValue();
	}

	public Optional<Integer> findMaxByOccurenceGTE(int numberOfOccurences) {
		return occurenceByDice().entrySet().stream().filter(o -> o.getValue() >= numberOfOccurences)
				.map(Map.Entry::getKey).max(Comparator.naturalOrder());
	}

	public Optional<Integer> getRemainingPair(int excluded) {
		return occurenceByDice().entrySet().stream().filter(o -> o.getKey() != excluded && o.getValue() >= 2)
				.map(Map.Entry::getKey).max(Comparator.naturalOrder());
	}

	public boolean isSmallStraight() {
		return getSortedDices().equals(SMALL_STRAIGHT);
	}

	public boolean isLargeStraight() {
		return getSortedDices().equals(LARGE_STRAIGHT);
	}

	private List<Integer> getSortedDices() {
		return dices.stream().sorted().toList();
	}

	private Map<Integer, Long> occurenceByDice() {
		return dices.stream().collect(java.util.stream.Collectors.groupingBy(identity(), counting()));
	}

}
