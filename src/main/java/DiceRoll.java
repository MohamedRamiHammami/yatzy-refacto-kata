import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DiceRoll {
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

	public int numberCategoryScore(DiceRoll roll, int value) {
		return roll.occurenceByDice().getOrDefault(value, 0L).intValue() * value;
	}

	public Optional<Integer> getMaxPair() {
		return occurenceByDice().entrySet().stream().filter(o -> o.getValue() >= 2).map(Map.Entry::getKey)
				.max(Comparator.naturalOrder());
	}

	public Optional<Integer> getRemainingPair(Integer excluded) {
		return occurenceByDice().entrySet().stream()
				.filter(o -> o.getKey().intValue() != excluded.intValue() && o.getValue() >= 2).map(Map.Entry::getKey)
				.max(Comparator.naturalOrder());
	}

	public Optional<Integer> getTriple() {
		return occurenceByDice().entrySet().stream().filter(o -> o.getValue() >= 3).map(Map.Entry::getKey)
				.max(Comparator.naturalOrder());
	}

	public Optional<Integer> getQuadruple() {
		return occurenceByDice().entrySet().stream().filter(o -> o.getValue() >= 4).map(Map.Entry::getKey)
				.max(Comparator.naturalOrder());
	}

	private Map<Integer, Long> occurenceByDice() {
		return dices.stream().collect(java.util.stream.Collectors.groupingBy(identity(), counting()));
	}

}
