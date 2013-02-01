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

	ActorRef queue;
	
	public void onReceive(Object arg0) throws Exception {
		
	}
	
	public void sendPersonToQueue(Person person, ActorRef security){
		int check = (int) (Math.random() * 100);
		ActorRef queue;
		if(check <= 20) {
			rejectPerson(person);
		}
		else {
			for(int i = 0; i < 4; i++) {
				queue = actorOf(Queue.class).start();
				security = actorOf(Security.class).start();
				queue.tell(person, security);
			}
		}
		
	}
	
	public void rejectPerson(Person person){
		System.out.println("Person: " + person.getPersonId() + " has been turned away.");
	}
}
