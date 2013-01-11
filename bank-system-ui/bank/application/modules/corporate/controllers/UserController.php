<?php

class Ws_UserController extends Zend_Controller_Action {
	
    public function init() {
        $this->_helper->viewRenderer->setNoRender(true);
		$this->_helper->layout->disableLayout();
    }
	
	public function preDispatch() {
		
		if (!$this->getRequest()->isPost()) 
		{
			echo json_encode(array('Result'=>false,'Error'=>"This function accepts only POST.",'Code'=>'POST_REQUIRE'));
			exit;
		}
		
	}

    public function indexAction() {
		echo json_encode(array('Result'=>false,'Error'=>"There is no specific service given for your request.",'Code'=>'SERVICE_NOT_AVAILABLE'));
		exit;
    }
	
	public function signupAction() {
		
		$email = trim($this->getRequest()->getPost('email'));
		$longitude = trim($this->getRequest()->getPost('longitude'));
		$latitude = trim($this->getRequest()->getPost('latitude'));
		
		
		if (empty($email))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"Email is not specified.",'Code'=>'EMAIL_NOT_SPECIFIED'));
			exit;
		}
		else if (!filter_var($email, FILTER_VALIDATE_EMAIL))
		{
			echo json_encode(array('Result'=>false,'Error'=>"The email is not valid.",'Code'=>'INVALID_EMAIL'));
			exit;
		}
		else if (!isset($longitude))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"Longitude is not specified for the location.",'Code'=>'LONGITUDE_NOT_SPECIFIED'));
			exit;
		}
		else if (!isset($latitude))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"Latitude is not specified for the location.",'Code'=>'LATITUDE_NOT_SPECIFIED'));
			exit;
		}
		
		if(Classes_AppUser::isEmailExists($email))
		{
			echo json_encode(array('Result'=>false,'Error'=>"User already registerd.",'Code'=>'ALREADY_REGISTERED'));
			exit;
		}
		
		
		
		$pin = Classes_General::generatePassword(4,false,'lud');
		$encryptedPin = Classes_Encryption::generatePassword($pin);
		$userDataAR = array('Email'=>$email,'PIN'=>$encryptedPin,'Longitude'=>$longitude,'Latitude'=>$latitude);
		$userID = Classes_AppUser::addUser($userDataAR);
		
		$resultData = array();
		if($userID>0)
		{
			$resultData['Result'] = true;
			$resultData['User_ID'] = $userID;
			$auth = new Classes_Authentication();
			$wsToken = $auth->generateWSToken($userID);
			if($auth->saveWSSession($userID,$wsToken))
				$resultData['Token'] = $wsToken;
			
			$mail = new Classes_Mail();
			$mail->setTemplatePath(MODULE_PATH_WEB_SERVICE . "/views/scripts/mail_templates");
			$mail->setSubject("UberDash Account Created");
			$mail->setFrom(SYSTEM_MAIL_SENDER_NAME,SYSTEM_MAIL_SENDER_EMAIL);
			$mail->setRecipients(array($email));
			$mail->useTemplate(true);
			$mail->setParameters(array('Email'=>$email,'Pin'=>$pin));
			$mail->setTemplate("account_created.phtml");
			$mail->sendMail();
						
			echo json_encode($resultData);
			exit;
		}
		else
		{
			$resultData['Result'] = false;
			$resultData['Error'] = "Recorder saving failed.";
			$resultData['Code'] = "SAVING_FAILED";
			echo json_encode($resultData);
			exit;
		}
	}
	
	public function authenticateAction() {
		$email = trim($this->getRequest()->getPost('email'));
		$pin = trim($this->getRequest()->getPost('pin'));
		
		$resultData = array();
		$auth = new Classes_Authentication();
		if($auth->authenticateAppUser($email,$pin))
		{
			$userID = $auth->getuserID();
			$auth->deleteWSSession();
			$wsToken = $auth->generateWSToken($userID);
			if($auth->saveWSSession($userID,$wsToken))
			{
				$resultData['Result'] = true;
				$resultData['User_ID'] = $userID;
				$resultData['Token'] = $wsToken;				
				echo json_encode($resultData);
				exit;
			}
			else
			{
				$resultData['Result'] = false;
				$resultData['Error'] = "Invalid credentials.";
				$resultData['Code'] = "AUTHENTICATION_FAILED";
				echo json_encode($resultData);
				exit;
			}
		}	
		else
		{
			$resultData['Result'] = false;
			$resultData['Error'] = "Invalid credentials.";
			$resultData['Code'] = "AUTHENTICATION_FAILED";
			echo json_encode($resultData);
			exit;
		}
	}
	
	
}