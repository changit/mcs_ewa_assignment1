<?php

class Defaultmodule_Form_Login extends Zend_Form {
	
    public function init() {
		
		
		// create text input for txtUserName
        $username = new Zend_Form_Element_Text('txtUserName');
		$username->setOptions(array('maxlength'=>'100', 'autocompletetype'=>'Disabled', 'autocomplete'=>'off'))
			->setAttrib('class', 'form-login')
			->setLabel('Username:')
			->addFilter('StringTrim');
		$username->style = "width:240px;";
		
		// create password input for txtPassword
		$password = new Zend_Form_Element_Password('txtPassword');
		$password->setOptions(array('maxlength'=>'20'))
			->setAttrib('class', 'form-login')
			->setLabel('Password:')
			->addFilter('StripTags')
			->addFilter('StringTrim');
		$password->style = "width:240px;";
		
		// create checkbox for Remember Me
		$rememberme = new Zend_Form_Element_Checkbox('cboRemember');
		$rememberme->style = "float:left; margin:0 5px 0 0; padding:0;";
		
		// create submit button
		/*
		$submit = new Zend_Form_Element_Submit('submit');
		$submit->setAttrib('id', 'submitbutton')
			->setLabel('Login')
			->setAttrib('class', 'form_button');
		*/
		
		$submit = new Zend_Form_Element_Image('submit');
		$submit   ->setlabel('Submit')
				 ->setImage('images/login-btn.png')
				 ->setAttrib('id', 'submitbutton')
				 ->setAttrib('class', 'frm-btn')
				 ->setAttrib('width', '71')
				 ->setAttrib('height', '33')
				 ->setAttrib('type', 'submit');

		$this->addElements(array($username, $password, $rememberme, $submit));
		
		$elements = $this->getElements();
		foreach ($elements as $elem) $elem->removeDecorator('label')->removeDecorator('HtmlTag');
	}
}