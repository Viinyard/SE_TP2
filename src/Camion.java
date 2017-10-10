/**
 * 
 */

/**
 * @author VinYarD
 *
 * SE_TP2//Camion.java
 * 10 oct. 2017
 */

public class Camion extends Thread {
	
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
			
			s.setInTraitement(true);
			
			while(s.getStock() < s.getLBound() && this.stock > 0) {
				s.restitution(); this.stock--;
			}
			
			while(s.getStock() > s.getUBound()) {
				s.emprunt(); this.stock++;
			}
			
			s.setInTraitement(false);
			
			this.pos = (this.pos + 1) % this.v.getNbSites();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
