<?php

class Defaultmodule_ErrorController extends Zend_Controller_Action
{

	public function preDispatch() {
		Zend_Layout::getMvcInstance()->setLayoutPath(MODULE_PATH_DEFAULT.'/layouts');
	}
	
    public function errorAction()
    {
        $errors = $this->_getParam('error_handler');
        
        switch ($errors->type) {
            case Zend_Controller_Plugin_ErrorHandler::EXCEPTION_NO_ROUTE:
            case Zend_Controller_Plugin_ErrorHandler::EXCEPTION_NO_CONTROLLER:
            case Zend_Controller_Plugin_ErrorHandler::EXCEPTION_NO_ACTION:
        
                // 404 error -- controller or action not found
                $this->getResponse()->setHttpResponseCode(404);
                $this->view->message = 'Page not found';
                break;
            default:
                // application error
                $this->getResponse()->setHttpResponseCode(500);
                $this->view->message = 'Application error';
				$this->logMessage("Error [Personal Banking] : " . $errors->exception);
                break;
        }
        //echo $errors->exception;
		
    }

   public function logMessage($message)
	{
		$stream = @fopen("log/" . date("Ymd") . "_error.txt", 'a', false);
		if (! $stream) {
			throw new Exception('Failed to open stream');
		}
		 
		$writer = new Zend_Log_Writer_Stream($stream);
		$logger = new Zend_Log($writer);
		$logger->info($message);
	}


}

