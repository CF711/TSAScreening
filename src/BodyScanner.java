/**
 * Stub
 * 
 * @author Chris
 * @author Carol
 *
 */
public class BodyScanner {
	
	public void onRecieve(Object message){
		if (message instanceof Person){
			try {sendPersonToSecurity((Person) message);} 
			catch (InterruptedException e) {}
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
	
	public void sendPersonToSecurity(Person person) throws InterruptedException{
		boolean passFail = checkPerson(person);
	}
	
}
