<?php

class Defaultmodule_Bootstrap extends Zend_Application_Module_Bootstrap
{
	protected function _initPlugin() {
		$front = Zend_Controller_Front::getInstance();
		$front->registerPlugin(new Plugin_Error());
	}
}



