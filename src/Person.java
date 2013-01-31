/**
 * Stub
 * 
 * @author Chris
 * @author Carol
 *
 */
public class Person {
	private final int personId;
	private final int queueId;
	private final int numberOfBags;
	private boolean sendToJail = false;
  
    public Person(int personId, int queueId, int numberOfBags) {
            this.personId = personId;
            this.queueId = queueId;
            this.numberOfBags = numberOfBags;
    }
    
    public int getPersonId() {
            return personId;
    }
    
    public int getQueueId(){
    		return queueId;
    }

    public int getNumberOfBags() {
            return numberOfBags;
    }
    
    public boolean getSendToJail(){
    	return sendToJail;
    }
    
    public void setSendToJail(boolean sendToJail) {
    	this.sendToJail = sendToJail;
    }
}
