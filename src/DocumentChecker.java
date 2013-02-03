import akka.actor.UntypedActor;
import akka.actor.ActorRef;
import static akka.actor.Actors.actorOf;

/**
 * Stub
 * 
 * 
 * @author Chris
 * @author Carol
 *
 */
public class DocumentChecker extends UntypedActor {
	
	public void sendPersonToQueue(Person person, ActorRef security) throws InterruptedException{
		int check = (int) (Math.random() * 100);
		ActorRef queue;
		if(check <= 20){
			rejectPerson(person);
		}else{		
			for(int i = 1; i < 4; i ++){
				queue = actorOf(Queue.class).start();
				security = actorOf(Queue.class).start());
				queue.tell(person, security);
			}
		}
		
	ActorRef queue;
	
	public void onReceive(Object arg0) throws Exception {

		
	}

	public void rejectPerson(Person person){
		System.out.println("Person: " + person.getPersonId() + " has been turned away.");
	}

	public void sendPersonToQueue(Person person, ActorRef security){
		int check = (int) (Math.random() * 100);
		ActorRef queue;
		if(check <= 20) {
			rejectPerson(person);
		}
		else {
			/*
			 * Upon building the queues, we need to construct a
			 * configure object which possesses all the parameters
			 * needed to build queues, bag and body scans, and
			 * security.
			 * 
			 * Thus, each actor will need to compare (instanceof)
			 * on the incoming message to determine if it
			 * is a configure object and process accordingly
			 * 
			 */
			for(int i = 0; i < 4; i++) {
				queue = actorOf(Queue.class).start();
				queue.tell(person, security);
			}
		}
	}

	
	public void rejectPerson(Person person){
		System.out.println("Person: " + person.getPersonId() + " has been turned away.");
	}
}
