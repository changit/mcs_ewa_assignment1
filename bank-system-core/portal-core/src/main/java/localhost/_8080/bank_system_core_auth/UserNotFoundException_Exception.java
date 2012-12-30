
package localhost._8080.bank_system_core_auth;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2012-12-30T15:27:10.291+05:30
 * Generated source version: 2.6.1
 */

@WebFault(name = "UserNotFoundException", targetNamespace = "http://localhost:8080/bank-system-core-auth")
public class UserNotFoundException_Exception extends Exception {
    
    private localhost._8080.bank_system_core_auth.UserNotFoundException userNotFoundException;

    public UserNotFoundException_Exception() {
        super();
    }
    
    public UserNotFoundException_Exception(String message) {
        super(message);
    }
    
    public UserNotFoundException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException_Exception(String message, localhost._8080.bank_system_core_auth.UserNotFoundException userNotFoundException) {
        super(message);
        this.userNotFoundException = userNotFoundException;
    }

    public UserNotFoundException_Exception(String message, localhost._8080.bank_system_core_auth.UserNotFoundException userNotFoundException, Throwable cause) {
        super(message, cause);
        this.userNotFoundException = userNotFoundException;
    }

    public localhost._8080.bank_system_core_auth.UserNotFoundException getFaultInfo() {
        return this.userNotFoundException;
    }
}
