/**
 * 
 */

/**
 * @author VinYarD
 *
 * SE_TP2//Ville.java
 * 10 oct. 2017
 */

public class Ville {
	
	public static void main(String[] args) {
		Ville v = new Ville(5);
	}

	private Site[]  sites;
	
	public Ville(int nbSites) {
		this.sites = new Site[nbSites];
		
		for(int i = 0; i < nbSites; i ++) {
			this.sites[i] = new Site(
					i+1 /* numSite */, 
					10 /* stockMax */, 
					6 /* stockInit */,
					8 /* UBound */,
					2 /* LBound */);
		}
	}
	
	public int getNbSites() {
		return this.sites.length;
	}
	
	public Site getSite(int ind) {
		return this.sites[ind];
	}
}
