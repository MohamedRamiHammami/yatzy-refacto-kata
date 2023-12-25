package com.kata.yatzy;

import java.util.Arrays;
import java.util.List;

public final class YatziContant {

	private YatziContant() {
		throw new IllegalStateException("Static class");
	}

	public static final int LARGE_STRAIGHT_CONSTANT = 20;
	public static final int SMALL_STRAIGHT_SCORE = 15;
	public static final int ZERO_SCORE = 0;
	public static final int YATZI_SCORE = 50;

	protected static final List<Integer> LARGE_STRAIGHT = Arrays.asList(2, 3, 4, 5, 6);
	protected static final List<Integer> SMALL_STRAIGHT = Arrays.asList(1, 2, 3, 4, 5);
}
