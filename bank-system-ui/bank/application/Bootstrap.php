<?php

class Bootstrap extends Zend_Application_Bootstrap_Bootstrap {
	protected function _initVars() {
		//session_start();
		Zend_Session::start();
	}
	
	protected function _initAutoload() {
		// this is a fallback to autoload our own classes in library
		$autoLoader = Zend_Loader_Autoloader::getInstance();
		$autoLoader->setFallbackAutoloader(true);
	}
	
	
	
}

