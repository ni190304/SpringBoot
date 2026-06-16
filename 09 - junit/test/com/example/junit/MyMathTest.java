package com.example.junit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath myMath = new MyMath();

	@Test
	void calculateSum_FiveMemberArray() {
		// fail("Not yet implemented");

		assertEquals(15, myMath.calculateSum(new int[] { 1, 2, 3, 4, 5 }));
	}

	@Test
	void calculateSum_EmptyArray() {
		// fail("Not yet implemented");

		assertEquals(0, myMath.calculateSum(new int[] {}));
	}

}
