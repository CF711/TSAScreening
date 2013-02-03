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
public class BodyScanner extends UntypedActor {
	
	ActorRef security;
	Person person;
	
	public void onReceive(Object message1, Object message2) throws Exception {
		if (message1 instanceof Person){
			person = (Person)message1;
		}
		if (message2 instanceof ActorRef){
			security = (ActorRef)message2;
		}
	}
	
	public boolean checkPerson(Person person) throws InterruptedException{
		int check = (int) (Math.random() * 100);
		wait(3000);
		if(check <= 20){
			return false;

		}else{
			return true;
		}
		
	}
	
	public void sendPersonToSecurity(Person person, ActorRef security) throws InterruptedException{
		security.tell(person, checkPerson(person));
	}
	
}
