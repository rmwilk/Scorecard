import java.awt.List;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author CTStudent
 *
 */
public class Email {
	private String name;
	private String domain;
	
	public Email(String email) {
		
	}
	
	public boolean email(String address) {
		ArrayList<String> myParts = new ArrayList<String>();
		myParts = address.split('@');
		if(myParts.size())
		
		return true;
	}
}
