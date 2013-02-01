import akka.actor.UntypedActor;

/**
 * Stub
 * 
 * @author Chris
 * @author Carol
 *
 */
public class BagScanner extends UntypedActor {

	public void onReceive(Object message){
		if (message instanceof Person){
			try {sendBagToSecurity((Person) message);} 
			catch (InterruptedException e) {}
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
	
	public void sendBagToSecurity(Person person) throws InterruptedException{
		boolean passFail = checkBag(person);
	}
}
