package gui;

public class Generator {
	
	public int broj(int dg, int gg) {
		return (int)(dg + Math.random() * (gg - dg + 1));
	}
	
	public int[] brojevi(int dg, int gg, int n) {
		int[] niz = new int[n];
		for (int i = 0; i < n; i++)
			niz[i] = broj(dg, gg);
		return niz;
	}
	
}