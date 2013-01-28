import java.util.regex.Pattern;


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
}
