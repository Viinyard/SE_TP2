/**
 * 
 */

/**
 * @author VinYarD
 *
 * SE_TP2//Sites.java
 * 10 oct. 2017
 */

public class Site {
	
	private final int stockMax, stockInit;
	private int stock;
	private int uBound, lBound;
	private final int num;
	
	private boolean inTraitement = false;
	
	public Site(int num, int stockMax, int stockInit, int uBound, int lBound) {
		if(stockInit > stockMax && stockInit < 0) throw new IllegalArgumentException("stock init > stock max");
		this.stockMax = stockMax;
		this.stock = this.stockInit = stockInit;
		this.num = num;
		this.uBound = uBound;
		this.lBound = lBound;
	}
	
	public boolean isInTraitement() {
		return this.inTraitement;
	}
	
	public void setInTraitement(boolean inTraitement) {
		this.inTraitement = inTraitement;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public int getStockMax() {
		return this.stockMax;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public int getStockInit() {
		return this.stockInit;
	}
	
	public int getLBound() {
		return this.lBound;
	}
	
	public int getUBound() {
		return this.uBound;
	}
	
	public void emprunt() {
		while(this.stock <= 0 || this.inTraitement) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.stock--;
	}
	
	public void prendre() {
		while(this.stock <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.stock--;
	}

	public void restitution() {
		while(this.stockMax - this.stock <= 0 || this.inTraitement) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.stock++;
	}
	
	public void deposer() {
		while(this.stockMax - this.stock <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.stock++;
	}
}
