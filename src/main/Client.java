package main;
/**
 * 
 */

import java.util.Random;

import main.state.ClientState;
import main.state.StateStrategy;

/**
 * @author Antoine Leval
 *
 */
public class Client extends Thread implements Strategy {
	
	private final Ville v;
	private int position;
	private ClientState state;
	private final int num;
	public static int inst = 1;
	
	public Client(Ville v) {
		this.num = Client.inst++;
		this.state = StateStrategy.EMPRUNT;
		this.v = v;
		this.position = new Random().nextInt(this.v.getNbSites());
	}
	
	public void setState(ClientState state) {
		this.state = state;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public Ville getVille() {
		return this.v;
	}
	
	@Override
	public void run() {
		while(true) {
			Site s = this.v.getSite(this.position);
			if(this.state == StateStrategy.EMPRUNT || this.state == StateStrategy.RESTITUTION) {
				s.accept(this);
			} else {
				this.state.doSomething(this, s);
			}
		}
	}
	

	/* (non-Javadoc)
	 * @see main.Strategy#traitement(main.Site)
	 */
	@Override
	public void traitement(Site s) {
		this.state.doSomething(this, s);
	}
	
	@Override
	public String toString() {
		return "<Client - "+num+"> "+this.getName()+" ["+this.state.toString()+"];";
	}
}
