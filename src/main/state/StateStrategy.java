/**
 * 
 */
package main.state;

import java.util.Random;

import main.Client;

/**
 * @author Antoine Leval
 *
 */
public enum StateStrategy implements ClientState {
	EMPRUNT() {

		@Override
		public void doSomething(Client c) {
			c.getVille().getSite(c.getPosition()).emprunt();
			c.setState(DEPLACEMENT);
		}
		
	},
	RESTITUTION() {

		@Override
		public void doSomething(Client c) {
			c.getVille().getSite(c.getPosition()).emprunt();
			c.setState(EMPRUNT);
		}
		
	},
	DEPLACEMENT() {

		@Override
		public void doSomething(Client c) {
			int pos = c.getPosition();
			c.setPosition(new Random().nextInt(c.getVille().getNbSites()));
			
			try {
				Thread.sleep(100 * Math.abs(pos - c.getPosition()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			c.setState(RESTITUTION);
		}
		
	},
	TRANSITION() {

		@Override
		public void doSomething(Client c) {
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			c.setState(EMPRUNT);
		}
		
	};	
}
