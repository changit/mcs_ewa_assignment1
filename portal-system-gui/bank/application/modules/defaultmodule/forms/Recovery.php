<?php

class Defaultmodule_Form_Recovery extends Zend_Form {
	
    public function init() {
		
		// create password input for txtPassword			
		$password = new Zend_Form_Element_Password('txtPassword');
		$password->setOptions(array('maxlength'=>'20'))
			->setAttrib('class', 'validate[required,minSize[6]] field-txt')
			->setLabel('Password:')
			->setRequired(true)
			->addFilter('StripTags')
			->addFilter('StringTrim')
			->addValidator('NotEmpty', true, array('messages' => 'ERROR: Password can not be empty'));
		$password->style = "width:250px;";
		
		// create password input for txtPasswordCon
		$passwordcon = new Zend_Form_Element_Password('txtPasswordCon');
		$passwordcon->setOptions(array('maxlength'=>'20'))
			->setAttrib('class', 'validate[required,equals[txtPassword]] field-txt')
			->setLabel('Password:')
			->setRequired(true)
			->addFilter('StripTags')
			->addFilter('StringTrim')
			->addValidator('NotEmpty', true, array('messages' => 'ERROR: Password can not be empty'));
		$passwordcon->style = "width:250px;";
		
		// create submit button
	
			
		$submit = new Zend_Form_Element_Image('submit');
		$submit   ->setlabel('Submit')
				 ->setImage('../images/reset_btn.png')
				 ->setAttrib('id', 'submitbutton')
				 ->setAttrib('class', 'frm-btn')
				 ->setAttrib('width', '121')
				 ->setAttrib('height', '33')
				 ->setAttrib('type', 'submit');
		
		$this->addElements(array($password, $passwordcon, $submit));
		
		$elements = $this->getElements();
		foreach ($elements as $elem) $elem->removeDecorator('label')->removeDecorator('HtmlTag')->removeDecorator('DtDdWrapper');
	}
}