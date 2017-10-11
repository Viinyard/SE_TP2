package main;
/**
 * 
 */

import java.util.Random;

import main.state.ClientState;

/**
 * @author Antoine Leval
 *
 */
public class Client extends Thread implements Strategy {
	
	private final Ville v;
	private int position;
	private ClientState state;
	
	public Client(Ville v) {
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
		
	}

	/* (non-Javadoc)
	 * @see main.Strategy#traitement(main.Site)
	 */
	@Override
	public void traitement(Site s) {
		// TODO Auto-generated method stub
		
	}
}
