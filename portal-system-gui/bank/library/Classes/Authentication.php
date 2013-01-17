<?php
 /*
 * @Project:    SriBank
 * @File:       Authentication.php
 * @Package:	Classes
 * @Version:	1.00
 * @Copyright:  2012 SriBank
 * @Author:		Prasad Rajapaksha <prasadrajapaksha@gmail.com>
 *
 * The Authentication class - Perform user authentications. 
 *
 */

class Classes_Authentication
{
	
	/** 
	* Return whether the user is logged in or not
	*
	* @return bool 
	*/
	public function checkPersonalAuthentication()
	{		
		$session = new Zend_Session_Namespace(DEFAULT_SESSION_NAMESPACE);
		if(isset($session->USER_AUTHENTICATION))
			return true;
		
		return false;		
	}
	
	/** 
	* Set user authentication sessions
	*
	* @return bool 
	*/
	public function setPersonalAuthentication($sessionToken)
	{		
		$session = new Zend_Session_Namespace(DEFAULT_SESSION_NAMESPACE);
		$session->USER_AUTHENTICATION = true;
		$session->SESSION_TOKEN = $sessionToken;
	}
	
	/** 
	* Remove user authentication sessions
	*
	* @return bool 
	*/
	public function unsetPersonalAuthentication()
	{		
		$session = new Zend_Session_Namespace(DEFAULT_SESSION_NAMESPACE);
		$session->__unset('SESSION_TOKEN');
		$session->__unset('USER_AUTHENTICATION');
	}

}