package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Polje extends Canvas {
	public static final int SLOBODNO = 0;
	public static final int IZABRANO = 1;
	public static final int OZNACENO = 2;
	public static final int POGODJENO = 3;
	public static final int PROMASENO = 4;
	private static final long serialVersionUID = 1L;
	private int broj;
	private int status = SLOBODNO;
	public Polje(Mreza mreza, int broj) {
		this.broj = broj;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				status = Math.abs(1 - status);
				mreza.pritisnut(Polje.this);
				repaint();
			}
		});
	}
	public int dohvBroj() {
		return broj;
	}
	public int dohvStatus() {
		return status;
	}
	public void postStatus(int status) {
		this.status = status;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, width, height);
		if (status == IZABRANO) {
			g.setColor(Color.BLUE);
			g.fillOval(0, 0, width, height);
			g.setColor(Color.WHITE);
		} else if (status == SLOBODNO) {
			g.setColor(Color.BLACK);
		} else if (status == OZNACENO) {
			g.setColor(Color.WHITE);
			g.fillOval(0, 0, width, height);
			g.setColor(Color.BLACK);
		} else if (status == POGODJENO) {
			g.setColor(Color.GREEN);
			g.fillOval(0, 0, width, height);
			g.setColor(Color.BLACK);
		} else if (status == PROMASENO) {
			g.setColor(Color.RED);
			g.fillOval(0, 0, width, height);
			g.setColor(Color.BLACK);
		}
		int refDimenzija = (width < height) ? width : height;
		double fontSize = refDimenzija / 75.0 * Toolkit.getDefaultToolkit().getScreenResolution() / 3;
		g.setFont(new Font("Comic Sans MS", Font.BOLD, (int)Math.floor(fontSize)));
		String brojStr = String.valueOf(broj);
		FontMetrics fm = g.getFontMetrics();
		g.drawString(brojStr, (width - fm.stringWidth(brojStr)) / 2, (height - fm.getHeight()) / 2 + fm.getAscent());
	}
}