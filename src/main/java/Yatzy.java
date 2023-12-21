import java.util.Comparator;
import java.util.Map;

public class Yatzy {

	private Yatzy() {
		throw new IllegalStateException("Utility class");
	}

	public static int chance(DiceRoll roll) {
		return roll.sum();
	}

	public static int yatzy(DiceRoll roll) {
		return roll.occurenceByDice().values().stream().filter(count -> count == 5).findFirst().map(o -> 50).orElse(0);
	}

	public static int ones(DiceRoll roll) {
		return numberCategoryScore(roll, 1);
	}

	public static int twos(DiceRoll roll) {
		return numberCategoryScore(roll, 2);

	}

	public static int threes(DiceRoll roll) {
		return numberCategoryScore(roll, 3);

	}

	public static int fours(DiceRoll roll) {
		return numberCategoryScore(roll, 4);
	}

	public static int fives(DiceRoll roll) {
		return numberCategoryScore(roll, 5);
	}

	public static int sixes(DiceRoll roll) {
		return numberCategoryScore(roll, 6);
	}

	private static int numberCategoryScore(DiceRoll roll, int value) {
		return roll.occurenceByDice().getOrDefault(value, 0L).intValue() * value;
	}

	public static int onePair(DiceRoll roll) {
		return getMaxPair(roll);
	}

	private static Integer getMaxPair(DiceRoll roll) {
		return roll.occurenceByDice().entrySet().stream().filter(o -> o.getValue() >= 2).map(Map.Entry::getKey)
				.max(Comparator.naturalOrder()).map(value -> 2 * value).orElse(0);
	}

	public static int twoPairs(DiceRoll roll) {
		Integer firstPairScore = getMaxPair(roll);
		if (firstPairScore == 0)
			return 0;
		Integer secondPairScore = getMaxPair(roll, firstPairScore / 2);
		if (secondPairScore == 0)
			return 0;
		return firstPairScore + secondPairScore;
	}

	private static Integer getMaxPair(DiceRoll roll, Integer excluded) {
		return roll.occurenceByDice(excluded).entrySet().stream().filter(o -> o.getValue() >= 2).map(Map.Entry::getKey)
				.max(Comparator.naturalOrder()).map(value -> 2 * value).orElse(0);
	}

	public static int threeOfAKind(DiceRoll roll) {
		return getTriple(roll);
	}

	private static Integer getTriple(DiceRoll roll) {
		return roll.occurenceByDice().entrySet().stream().filter(o -> o.getValue() >= 3).map(Map.Entry::getKey)
				.max(Comparator.naturalOrder()).map(value -> 3 * value).orElse(0);
	}

	public static int fourOfAKind(DiceRoll roll) {
		return getQuadruple(roll);
	}

	private static Integer getQuadruple(DiceRoll roll) {
		return roll.occurenceByDice().entrySet().stream().filter(o -> o.getValue() >= 4).map(Map.Entry::getKey)
				.max(Comparator.naturalOrder()).map(value -> 4 * value).orElse(0);
	}

	public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
		int[] tallies;
		tallies = new int[6];
		tallies[d1 - 1] += 1;
		tallies[d2 - 1] += 1;
		tallies[d3 - 1] += 1;
		tallies[d4 - 1] += 1;
		tallies[d5 - 1] += 1;
		if (tallies[0] == 1 && tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1)
			return 15;
		return 0;
	}

	public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
		int[] tallies;
		tallies = new int[6];
		tallies[d1 - 1] += 1;
		tallies[d2 - 1] += 1;
		tallies[d3 - 1] += 1;
		tallies[d4 - 1] += 1;
		tallies[d5 - 1] += 1;
		if (tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1 && tallies[5] == 1)
			return 20;
		return 0;
	}

	public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
		int[] tallies;
		boolean _2 = false;
		int i;
		int _2_at = 0;
		boolean _3 = false;
		int _3_at = 0;

		tallies = new int[6];
		tallies[d1 - 1] += 1;
		tallies[d2 - 1] += 1;
		tallies[d3 - 1] += 1;
		tallies[d4 - 1] += 1;
		tallies[d5 - 1] += 1;

		for (i = 0; i != 6; i += 1)
			if (tallies[i] == 2) {
				_2 = true;
				_2_at = i + 1;
			}

		for (i = 0; i != 6; i += 1)
			if (tallies[i] == 3) {
				_3 = true;
				_3_at = i + 1;
			}

		if (_2 && _3)
			return _2_at * 2 + _3_at * 3;
		else
			return 0;
	}
}
