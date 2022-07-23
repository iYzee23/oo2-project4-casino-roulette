package gui;

import java.util.HashSet;

public class Jedinstveni extends Generator {

	@Override
	public int[] brojevi(int dg, int gg, int n) {
		HashSet<Integer> br = new HashSet<>();
		int[] niz = new int[n];
		for (int i = 0; i < n; i++) {
			int broj = broj(dg, gg);
			if (br.contains(broj)) {
				i--;
				continue;
			}
			niz[i] = broj;
			br.add(broj);
		}
		return niz;
	}

}
