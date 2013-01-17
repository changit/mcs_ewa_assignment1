<?php
// This plugin will provide facility to use module wise error controllers
class Plugin_Error extends Zend_Controller_Plugin_Abstract {
	
 	public function preDispatch(Zend_Controller_Request_Abstract $request) {
	
		$errorHandler = Zend_Controller_Front::getInstance()
                        ->getPlugin('Zend_Controller_Plugin_ErrorHandler');				
		$errorHandler->setErrorHandlerModule($this->getRequest()->getModuleName()); 		
	}
}