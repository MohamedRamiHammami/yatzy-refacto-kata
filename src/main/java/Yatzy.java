public class Yatzy {

	private Yatzy() {
		throw new IllegalStateException("Utility class");
	}

	public static int chance(DiceRoll roll) {
		return roll.sum();
	}

	public static int yatzy(DiceRoll roll) {
		return roll.counts().values().stream().filter(count -> count == 5).findFirst().map(o -> 50).orElse(0);
	}

	public static int ones(DiceRoll roll) {
		return number(roll, 1);
	}

	public static int twos(DiceRoll roll) {
		return number(roll, 2);

	}

	public static int threes(DiceRoll roll) {
		return number(roll, 3);

	}

	public static int fours(DiceRoll roll) {
		return number(roll, 4);
	}

	public static int fives(DiceRoll roll) {
		return number(roll, 5);
	}

	public static int sixes(DiceRoll roll) {
		return number(roll, 6);
	}

	private static int number(DiceRoll roll, int value) {
		return roll.counts().getOrDefault(value, 0L).intValue() * value;
	}

	public static int onePair(int d1, int d2, int d3, int d4, int d5) {
		int[] counts = new int[6];
		counts[d1 - 1]++;
		counts[d2 - 1]++;
		counts[d3 - 1]++;
		counts[d4 - 1]++;
		counts[d5 - 1]++;
		int at;
		for (at = 0; at != 6; at++)
			if (counts[6 - at - 1] >= 2)
				return (6 - at) * 2;
		return 0;
	}

	public static int twoPair(int d1, int d2, int d3, int d4, int d5) {
		int[] counts = new int[6];
		counts[d1 - 1]++;
		counts[d2 - 1]++;
		counts[d3 - 1]++;
		counts[d4 - 1]++;
		counts[d5 - 1]++;
		int n = 0;
		int score = 0;
		for (int i = 0; i < 6; i += 1)
			if (counts[6 - i - 1] >= 2) {
				n++;
				score += (6 - i);
			}
		if (n == 2)
			return score * 2;
		else
			return 0;
	}

	public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
		int[] tallies;
		tallies = new int[6];
		tallies[d1 - 1]++;
		tallies[d2 - 1]++;
		tallies[d3 - 1]++;
		tallies[d4 - 1]++;
		tallies[d5 - 1]++;
		for (int i = 0; i < 6; i++)
			if (tallies[i] >= 4)
				return (i + 1) * 4;
		return 0;
	}

	public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
		int[] t;
		t = new int[6];
		t[d1 - 1]++;
		t[d2 - 1]++;
		t[d3 - 1]++;
		t[d4 - 1]++;
		t[d5 - 1]++;
		for (int i = 0; i < 6; i++)
			if (t[i] >= 3)
				return (i + 1) * 3;
		return 0;
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
