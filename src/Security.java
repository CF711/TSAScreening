import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Security extends UntypedActor {
	
	int personId;
	boolean passCheck;
	Person person;
	
	HashMap<Integer, Boolean> awaiting= new HashMap<Integer, Boolean>();
	
    List<Person> jail = new ArrayList<Person>();
    List<Object> checkList = new ArrayList<Object>();
    //HashMap<Integer, Boolean> securityCheck = new HashMap<Integer, Boolean>();
	
    /*
     * This will need to be reworked as actors cannot receive messages
     * simultaneously. Instead, Security will accept a message formed
     * as a struct which points to the references of the Person (sent
     * from BodyScanner) and the Person's bags (sent from BagScanner)
     */
	public void onReceive(Object message) throws Exception{
		
		if (message instanceof ArrayList) {
			checkList = (ArrayList)message;
			passCheck = (boolean) checkList.get(1);
			person = (Person) checkList.get(0);
			personId = person.getPersonId();
		}	
			if (awaiting.containsKey(personId)){
				check(awaiting.get(personId), passCheck);
			}else{
				awaiting.put(personId, passCheck);
			}	

	}
	
	public void check(boolean value1, boolean value2){
			if(value1 && value2){
				System.out.println("Person: " + personId + " has passed security.");
			}
			else{
				sendToJail(person);
			}		
		
	}
	
	public void sendToJail(Person person){
		jail.add(person);
		System.out.println("Person: " + personId + " has been sent to jail.");
	}
}
