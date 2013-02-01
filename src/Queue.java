import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import static akka.actor.Actors.actorOf;

/**
 * Stub
 * 
 * @author Chris
 * @author Carol
 * 
 */
public class Queue extends UntypedActor {

	LinkedList<Person> queue = new LinkedList<Person>();
	boolean scannerClear = true;

	ActorRef queueBag = actorOf(BagScanner.class).start();
	ActorRef queueBody = actorOf(BodyScanner.class).start();
	ActorRef security = actorOf(Security.class).start();

	public void onReceive(Object message) {
		if (message instanceof Person) {
			if (!queue.contains((Person) message)) {
				if (scannerClear && queue.isEmpty()) {
					queue.add((Person) message);
					
					// Does this need to be executed as atomic operation?
					sendToBagScan();
					sendToBodyScan();
					
				} 
				else {
					queue.add((Person) message);
				}
			}
		}
	}

	/**
	 * Sends a person object to the bag scanner
	 */
	public void sendToBagScan(){
		queueBag.tell(queue.getFirst(), security);
	}
	
	/**
	 * Sends a person object to the body scanner
	 */
	public void sendToBodyScan() {
		queueBody.tell(queue.pop(), security);
	}
}
