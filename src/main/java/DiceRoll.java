import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DiceRoll {
	private final List<Integer> dices;

	public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
		this.dices = Arrays.asList(d1, d2, d3, d4, d5);
	}

	public Map<Integer, Long> counts() {
		return dices.stream().collect(java.util.stream.Collectors.groupingBy(identity(), counting()));
	}

	public int sum() {
		return dices.stream().mapToInt(Integer::intValue).sum();
	}
}
