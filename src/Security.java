import java.util.ArrayList;
import java.util.List;

/**
 * Stub
 * 
 * @author Chris
 * @author Carol
 *
 */
public class Security {
    List<Person> jail = new ArrayList<Person>();
    List<Person> awaiting = new ArrayList<Person>();
	
	public void onRecieve(Object message){
		if (message instanceof Person){
			if (awaiting.contains(((Person) message).getPersonId())){
				
			}	
		}
	}
	
	public void sendToJail(Person person){
		jail.add(person);
	}
}
