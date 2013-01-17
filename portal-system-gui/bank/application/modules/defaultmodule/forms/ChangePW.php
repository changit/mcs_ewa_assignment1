<?php

class Defaultmodule_Form_ChangePW extends Zend_Form {
	
    public function init() {
		
		$formPrefix = "edit_";
		
		
		// create password input for Password			
		$User_Password = new Zend_Form_Element_Password('User_Password');
		$User_Password->setOptions(array('maxlength'=>'20'))
			->setAttrib('class', 'validate[required,minSize[6]] field-txt')
			->setLabel('Password:')
			->setAttrib('id', $formPrefix . 'User_Password')
			->setRequired(true)
			->addFilter('StripTags')
			->addFilter('StringTrim')
			->addValidator('NotEmpty', true, array('messages' => 'ERROR: Password can not be empty'));
		$User_Password->style = "width:250px;";
		
		// create password input for Password Confirm
		$User_Password_Con = new Zend_Form_Element_Password('User_Password_Con');
		$User_Password_Con->setOptions(array('maxlength'=>'20'))
			->setAttrib('class', 'validate[required,equals['.$formPrefix . 'User_Password]] field-txt')
			->setLabel('Password:')
			->setAttrib('id', $formPrefix . 'User_Password_Con')
			->setRequired(true)
			->addFilter('StripTags')
			->addFilter('StringTrim')
			->addValidator('NotEmpty', true, array('messages' => 'ERROR: Password can not be empty'));
		$User_Password_Con->style = "width:250px;";
		
		
		// attach elements to form
		$this->addElements(array($User_Password, $User_Password_Con));
		
		$elements = $this->getElements();
		foreach ($elements as $elem) $elem->removeDecorator('label')->removeDecorator('HtmlTag');
	}
}