package main;
/**
 * 
 */

/**
 * @author VinYarD
 *
 * SE_TP2//Camion.java
 * 10 oct. 2017
 */

public class Camion extends Thread implements Strategy {
	
	private int stock = 0;
	private Ville v;
	
	private int pos = 0;
	
	public Camion(Ville v) {
		this.v = v;
	}
	
	@Override
	public void run() {
		while(true) {
			Site s = this.v.getSite(this.pos);
			
			s.accept(this);
			
			int precPos = this.pos;
			this.pos = (this.pos + 1) % this.v.getNbSites();
			
			try {
				Thread.sleep(Math.abs(precPos - this.pos) * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see main.Strategy#traitement(main.Site)
	 */
	@Override
	public void traitement(Site s) {
		System.out.print(" ----");
		while(s.getStock() < s.getLBound() && this.stock > 0) {
			s.restitution(); this.stock--; System.out.print("R");
		}
		
		while(s.getStock() > s.getUBound()) {
			s.emprunt(); this.stock++; System.out.print("E");
		}
		System.out.println(" ----");
	}
	
	@Override
	public String toString() {
		return "<Camion> "+this.getName()+" ["+this.stock+"];";
	}
}
