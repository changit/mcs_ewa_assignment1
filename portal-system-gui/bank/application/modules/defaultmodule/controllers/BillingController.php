<?php

class Defaultmodule_BillingController extends Zend_Controller_Action {
	
    public function init() {

    }
	
	public function preDispatch() {
		Zend_Layout::getMvcInstance()->setLayoutPath(MODULE_PATH_DEFAULT.'/layouts');
	}

    public function indexAction() {
		
    }
	
	public function dialogAction() {
		
    }
	
	public function waterAction() {
		
    }
	
	public function electricityAction() {
		
    }
}