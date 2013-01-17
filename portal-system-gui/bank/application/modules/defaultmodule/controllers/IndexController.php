<?php

class Defaultmodule_IndexController extends Zend_Controller_Action {
	
    public function init() {

    }
	
	public function preDispatch() {
		Zend_Layout::getMvcInstance()->setLayoutPath(MODULE_PATH_DEFAULT.'/layouts');
	}

    public function indexAction() {
		$this->_helper->layout->disableLayout();
    }
	
	 public function personalAction() {
	 	$this->_helper->layout->disableLayout();
		$auth = new Classes_Authentication();
		if ($this->getRequest()->isPost()) 
		{
			$client = new SoapClient("http://localhost:8080/bank-system-core-auth?WSDL",array('trace' => true));
			$hashPW = sha1("123456");
			$objSoap =  $client->authenticate(array('userName'=>$clientID,'hash'=>$hashPW));
			echo $client->__getLastResponse();
			exit;
			//$auth->setPersonalAuthentication('svhs7623uh');
			//$this->_helper->redirector('accounts','index');
		}
	
	 }
	 
	 public function accountsAction() {
	 	$auth = new Classes_Authentication();
		if(!$auth->checkPersonalAuthentication()) {
			$this->_helper->redirector('index','index');
		}
	
	 }
	 
	/** 
	* Logout the user
	*
	* @return void 
	*/
	public function logoutAction() {
		// unset the session
		$auth = new Classes_Authentication();
		if($auth->checkPersonalAuthentication()) {
			$auth->unsetPersonalAuthentication();
		}
		// once unset 
		$this->_helper->redirector('index','index');
	}
}