import java.util.Optional;

public class Yatzy {

	private Yatzy() {
		throw new IllegalStateException("Utility class");
	}

	public static int chance(DiceRoll roll) {
		return roll.sum();
	}

	public static int yatzy(DiceRoll roll) {
		return roll.matchYatzy().map(o -> 50).orElse(0);
	}

	public static int ones(DiceRoll roll) {
		return roll.numberCategoryScore(roll, 1);
	}

	public static int twos(DiceRoll roll) {
		return roll.numberCategoryScore(roll, 2);

	}

	public static int threes(DiceRoll roll) {
		return roll.numberCategoryScore(roll, 3);

	}

	public static int fours(DiceRoll roll) {
		return roll.numberCategoryScore(roll, 4);
	}

	public static int fives(DiceRoll roll) {
		return roll.numberCategoryScore(roll, 5);
	}

	public static int sixes(DiceRoll roll) {
		return roll.numberCategoryScore(roll, 6);
	}

	public static int onePair(DiceRoll roll) {
		return roll.getMaxPair().map(value -> 2 * value).orElse(0);
	}

	public static int twoPairs(DiceRoll roll) {
		Optional<Integer> firstPairScore = roll.getMaxPair();
		if (firstPairScore.isEmpty())
			return 0;
		Optional<Integer> secondPairScore = roll.getRemainingPair(firstPairScore.get());
		if (secondPairScore.isEmpty())
			return 0;
		return 2 * firstPairScore.get() + 2 * secondPairScore.get();
	}

	public static int threeOfAKind(DiceRoll roll) {
		return roll.getTriple().map(value -> 3 * value).orElse(0);
	}

	public static int fourOfAKind(DiceRoll roll) {
		return roll.getQuadruple().map(value -> 4 * value).orElse(0);
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

	public static int fullHouse(DiceRoll roll) {
		Optional<Integer> threeOfAKind = roll.getTriple();
		if (threeOfAKind.isEmpty())
			return 0;
		Optional<Integer> pair = roll.getRemainingPair(threeOfAKind.get());
		if (pair.isEmpty())
			return 0;
		return 3 * threeOfAKind.get() + 2 * pair.get();
	}
}
