package gui;

public class Rulet extends Thread {

	private Mreza mreza;
	private int[] niz;
	private int poslAnimirani;
	private boolean radi = false;
	
	public Rulet(Mreza m) {
		mreza = m;
		Generator g = new Generator();
		int n = (int)(0.3 * mreza.brojPolja() + Math.random() * mreza.brojPolja() * 0.41);
		niz = g.brojevi(0, mreza.brojPolja() - 1, n);
		start();
	}
	
	public synchronized int dohvPoslAnimirani() throws InterruptedException {
		while (!radi) wait();
		return poslAnimirani;
	}
	
	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
				for (int i = 0; i < niz.length; i++) {
					wait();
				}
			}
		} catch (InterruptedException e) {
			//bez efekta
		}
	}

}
