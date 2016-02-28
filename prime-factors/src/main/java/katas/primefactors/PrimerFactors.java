package katas.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimerFactors {

	public List<Integer> generate(int number) {
		List<Integer> primeValues = new ArrayList<Integer>();

		if (number <= 1) {
			return primeValues;
		}

		for (int candidate = 2; number > 1; candidate++) {
			while (number % candidate == 0) {
				number = number / candidate;
				primeValues.add(candidate);
			}
		}

		return primeValues;
	}

}
