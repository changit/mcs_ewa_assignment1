<?php

class Ws_IndexController extends Zend_Controller_Action {
	
    public function init() {
        $this->_helper->viewRenderer->setNoRender(true);
		$this->_helper->layout->disableLayout();
    }
	
	public function preDispatch() {
	}

    public function indexAction() {
		echo "No specific service given for the index action";
    }
	
	

}