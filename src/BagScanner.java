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
public class BagScanner extends UntypedActor {
	
	ActorRef security;
	Person person;
	boolean bagCheck = false;
	ArrayList<Object> bagList = new ArrayList<Object>();

	public BagScanner(ActorRef securityGuard){
		security = securityGuard;
	}

	public void onReceive(Object message){

		if (message instanceof Person){
			
			try {
				person = (Person)message;
				bagCheck = checkBag(person);
				bagList.add((Person)person);
				bagList.add((Boolean)checkBag(person));
				sendBagToSecurity(bagList);
			} 
			
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean checkBag(Person person) throws InterruptedException{
		int check = (int) (Math.random() * 100);
		wait(person.getNumberOfBags()*1000);

		if(check <= 20){
			return false;

		}else{
			return true;
		}
		
	}
	
	public void sendBagToSecurity(ArrayList bagArray) throws InterruptedException{
		security.tell(bagList);
		//get from configure
	}

}
