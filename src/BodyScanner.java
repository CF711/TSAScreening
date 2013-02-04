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
 * @author Stephan
 */
public class BodyScanner extends UntypedActor {

	ActorRef security;
	Person person;
	boolean personCheck;
	ArrayList<Object> bodyList = new ArrayList<Object>();
	
	public BodyScanner(ActorRef securityGuard) {
		security = securityGuard;
	}
	
	public void onReceive(Object message) throws Exception {
		
		if (message instanceof Person){			

			try {
				person = (Person)message;
				personCheck = checkPerson(person);
				bodyList.add(person);
				bodyList.add(personCheck);
				sendPersonToSecurity(bodyList);
			}
			
			catch (InterruptedException e) {
				e.printStackTrace();
			}
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
