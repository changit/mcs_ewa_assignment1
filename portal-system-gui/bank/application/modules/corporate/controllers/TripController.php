<?php

class Ws_TripController extends Zend_Controller_Action {
	
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
		
		$auth = new Classes_Auth();
		if (! $auth->authAccepted($this->getRequest()))
		{
			echo json_encode(array('Result'=>false,'Error'=>"Your request is not authenticated.",'Code'=>'UNAUTHORIZED_REQUEST'));
			exit;
		}
		
	}

    public function indexAction() {
		echo json_encode(array('Result'=>false,'Error'=>"There is no specific service given for your request.",'Code'=>'SERVICE_NOT_AVAILABLE'));
		exit;
    }
	
	public function startAction() {
		
		$userID = trim($this->getRequest()->getPost('user_id'));
	
		if (empty($userID))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"The user ID is not specified.",'Code'=>'USER_ID_NOT_SPECIFIED'));
			exit;
		}
		
		$currentTime = new Zend_Date();
		$tripInfo = array('User_ID'=>$userID,'Record_Start_Time'=>$currentTime->get(SQL_DATE_PATTERN));
		
		$tripID = Classes_Trip::addTrip($tripInfo);
		$resultData = array();
		
		if($tripID)
		{
			$resultData['Result'] = true;
			$resultData['Trip_ID'] = $tripID;
		}
		else
		{
			$resultData['Result'] = false;
			$resultData['Error'] = "The trip creating failed.";
			$resultData['Code'] = "TRIP_CREATING_FAILED";
		}
		echo json_encode($resultData);
		exit;
		
	}	
	
	public function reportAction() {
		$userID = trim($this->getRequest()->getPost('user_id'));
		$tripID = trim($this->getRequest()->getPost('trip_id'));
		$startTime = trim($this->getRequest()->getPost('start'));
		$endTime = trim($this->getRequest()->getPost('end'));
		$tripData = trim($this->getRequest()->getPost('tripData'));
	
		if (empty($userID))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"The user ID is not specified.",'Code'=>'USER_ID_NOT_SPECIFIED'));
			exit;
		}
		if (empty($tripID))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"The trip ID is not specified.",'Code'=>'TRIP_ID_NOT_SPECIFIED'));
			exit;
		}
		if (empty($startTime))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"The trip starting time is not specified.",'Code'=>'START_TIME_NOT_SPECIFIED'));
			exit;
		}
		if (empty($endTime))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"The trip ending time is not specified.",'Code'=>'END_TIME_NOT_SPECIFIED'));
			exit;
		}
		$currentTime = new Zend_Date();
		$tripInfo = array('Start_Time'=>$startTime,'End_Time'=>$endTime,'Record_End_Time'=>$currentTime->get(SQL_DATE_PATTERN));
		$resultData = array();
		if(Classes_Trip::updateTrip(array('Trip_ID'=>$tripID,'User_ID'=>$userID),$tripInfo))
		{
			if(!empty($tripData))
			{
				$tripDataJson = stripslashes($tripData);
				$tripDataAR = json_decode($tripDataJson,true);
				$position = 1;
				foreach($tripDataAR['Trip'] as $location)
				{
					$dataAR = array('Trip_ID'=>$tripID,'Longitude'=>$location['Long'],'Latitude'=>$location['Lat'],'Recording_Order'=>$position);					
					Classes_Trip::saveTripData($dataAR);
					$position++;
				}
			}
			$resultData['Result'] = true;
		}
		else
		{
			$resultData['Result'] = false;
			$resultData['Error'] = "Trip data saving failed.";
			$resultData['Code'] = "TRIP_SAVING_FAILED";
		}
		
		echo json_encode($resultData);
		exit;
	}
}