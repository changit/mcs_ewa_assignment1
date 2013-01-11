<?php

class Defaultmodule_Form_ForgetPW extends Zend_Form {
	
    public function init() {
		
		// create text input for txtUserName
        $username = new Zend_Form_Element_Text('txtUserName');
		$username->setOptions(array('maxlength'=>'100', 'autocompletetype'=>'Disabled', 'autocomplete'=>'off'))
			->setAttrib('class', 'form-login')
			->setLabel('Username:')
			->addFilter('StringTrim');
		$username->style = "width:240px;";

		
		$submit = new Zend_Form_Element_Image('submit');
		$submit   ->setlabel('Submit')
				 ->setImage('../images/send_btn.png')
				 ->setAttrib('id', 'submitbutton')
				 ->setAttrib('class', 'frm-btn')
				 ->setAttrib('width', '71')
				 ->setAttrib('height', '33')
				 ->setAttrib('type', 'submit');

		$this->addElements(array($username, $submit));
		
		$elements = $this->getElements();
		foreach ($elements as $elem) $elem->removeDecorator('label')->removeDecorator('HtmlTag');
	}
}