package main;
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
	
	public Site(int num, int stockMax, int stockInit, int uBound, int lBound) {
		if(stockInit > stockMax && stockInit < 0) throw new IllegalArgumentException("stock init > stock max");
		this.stockMax = stockMax;
		this.stock = this.stockInit = stockInit;
		this.num = num;
		this.uBound = uBound;
		this.lBound = lBound;
	}
	
	@Override
	public String toString() {
		return "Site [stockMax=" + stockMax + ", stockInit=" + stockInit + ", stock=" + stock + ", uBound=" + uBound
				+ ", lBound=" + lBound + ", num=" + num + "]";
	}

	public synchronized void accept(Strategy s) {
		System.out.println(s+" entre ["+this.num+"]");
		System.out.println(this);
		s.traitement(this);
		System.out.println(this);
		System.out.println(s+" sort ["+this.num+"]");
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
	
	public synchronized void emprunt() {
		while(this.stock <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.stock--;
	}
	
	public synchronized void restitution() {
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
