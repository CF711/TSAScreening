import java.util.ArrayList;
import java.util.List;

/**
 * Stub
 * 
 * @author Chris
 * @author Carol
 *
 */
public class Queue {

	List<Person> queue = new ArrayList<Person>();
	boolean scannerClear = true;
	
	public void onRecieve(Object message){
		if (message instanceof Person){
			if (!queue.contains((Person) message)){
				if (scannerClear && queue.isEmpty()){
					queue.add((Person) message);
					sendToBagScan();
					sendToBodyScan();
				} else {
					queue.add((Person) message);									
				}
			}
		} 
	}
	
	public void sendToBodyScan(){
		
	}
	
	public void sendToBagScan(){
		
	}
	
}
