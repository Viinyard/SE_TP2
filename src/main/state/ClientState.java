/**
 * 
 */
package main.state;

import main.Client;
import main.Site;

/**
 * @author Antoine Leval
 *
 */
public interface ClientState {
	public void doSomething(Client c, Site s);
}
