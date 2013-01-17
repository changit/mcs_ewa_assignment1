<?php

class Defaultmodule_Form_UserAdd extends Zend_Form {
	
    public function init() {
		
		$formPrefix = "add_";
		
		// create text input for user name
        $User_Name = new Zend_Form_Element_Text('User_Name');
		$User_Name->setOptions(array('maxlength'=>'60', 'autocompletetype'=>'Disabled', 'autocomplete'=>'off'))
			->setAttrib('class', 'validate[required] field-txt')
			->setAttrib('id', $formPrefix . 'User_Name')
			->setLabel('User Name:')
			->setRequired(true)
			->addFilter('StringTrim');
		$User_Name->style = "width:250px;";
		
		// create text input for Email
        $Email = new Zend_Form_Element_Text('Email');
		$Email->setOptions(array('maxlength'=>'100'))
			->setAttrib('class', 'validate[required,custom[email]] field-txt')
			->setAttrib('id', $formPrefix . 'Email')
			->addFilter('StringTrim');
		$Email->style = "width:250px;";
		
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
			
		// create text input for User_Type
		$User_Type = new Zend_Form_Element_Select('User_Type');
		$User_Type->addMultiOption('', 'Please select');
		$User_Type->addMultiOption('U', 'General User');
		$User_Type->addMultiOption('A', 'Administrator');
		$User_Type->setAttrib('class', 'validate[required] field-txt')
			->setRequired(true)
			->setAttrib('id', $formPrefix . 'User_Type')
			->addFilter('StringTrim');
		$User_Type->style = "width:257px;";
		
		
		// attach elements to form
		$this->addElements(array($User_Name, $Email, $User_Password, $User_Password_Con, $User_Type));
		
		$elements = $this->getElements();
		foreach ($elements as $elem) $elem->removeDecorator('label')->removeDecorator('HtmlTag');
	}
}