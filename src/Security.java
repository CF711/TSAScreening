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
	
	public void onRecieve(Object message){
		
	}
	
	public void sendToJail(Person person){
		jail.add(person);
	}
}
