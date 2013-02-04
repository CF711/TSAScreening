import java.util.ArrayList;
import java.util.HashMap;

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

	Person person;
	boolean personCheck;
	ArrayList<Object> bodyList = new ArrayList<Object>();
	
	public void onReceive(Object message) throws Exception {
		
		if (message instanceof Configure){
			// Andy do your schwag here!
		}
		
		if (message instanceof Person){
			person = (Person)message;
			personCheck = checkPerson(person);
			bodyList.add(person);
			bodyList.add(personCheck);
			sendPersonToSecurity(bodyList);
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
	
	public void sendPersonToSecurity(ArrayList bodyList) throws InterruptedException{
		security.tell(bodyList);
	}
	
}
