<?php

class Ws_EventController extends Zend_Controller_Action {
	
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
	
	public function reportAction() {
		$tripID = trim($this->getRequest()->getPost('trip_id'));
		$longitude = trim($this->getRequest()->getPost('longitude'));
		$latitude = trim($this->getRequest()->getPost('latitude'));
		$eventType = trim($this->getRequest()->getPost('event_type'));
		
		//HBR -> Hard Break
		//STP -> Stop
		//BMP -> Speed Bump
		$validEvents = array("HBR","STP","BMP");
	
	
		if (empty($tripID))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"The trip ID is not specified.",'Code'=>'TRIP_ID_NOT_SPECIFIED'));
			exit;
		}
		else if (!isset($longitude))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"Longitude is not specified for the event location.",'Code'=>'LONGITUDE_NOT_SPECIFIED'));
			exit;
		}
		else if (!isset($latitude))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"Latitude is not specified for the event location.",'Code'=>'LATITUDE_NOT_SPECIFIED'));
			exit;
		}
		else if (empty($eventType))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"The event type is not specified.",'Code'=>'EVENT_TYPE_NOT_SPECIFIED'));
			exit;
		}
		else if (!in_array($eventType,$validEvents))
		{
			echo json_encode(array('Result'=>false,'Error'=>"The event type is not valid.",'Code'=>'EVENT_TYPE_NOT_VALID'));
			exit;
		}
		
		$currentTime = new Zend_Date();
		$eventInfo = array('Trip_ID'=>$tripID,'Longitude'=>$longitude,'Latitude'=>$latitude,'Recorded_Time'=>$currentTime->get(SQL_DATE_PATTERN),'Event_Type'=>$eventType);
		$eventID = Classes_Event::addEvent($eventInfo);
		$resultData = array();
		
		if($eventID)
		{
			$resultData['Result'] = true;
			$resultData['Event_ID'] = $eventID;
		}
		else
		{
			$resultData['Result'] = false;
			$resultData['Error'] = "The event creating process failed.";
			$resultData['Code'] = "EVENT_CREATING_FAILED";
		}
		
		echo json_encode($resultData);
		exit;
	}
	
	public function syncAction() {
		$tripID = trim($this->getRequest()->getPost('trip_id'));
		$longitude = trim($this->getRequest()->getPost('longitude'));
		$latitude = trim($this->getRequest()->getPost('latitude'));
		$speed = trim($this->getRequest()->getPost('speed',0));
		$heading = trim($this->getRequest()->getPost('heading',0));
		$radius = trim($this->getRequest()->getPost('radius'));
		$timestamp = trim($this->getRequest()->getPost('timestamp'));
		
		if (empty($tripID))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"The trip ID is not specified.",'Code'=>'TRIP_ID_NOT_SPECIFIED'));
			exit;
		}
		else if (!isset($longitude))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"Longitude is not specified for the event location.",'Code'=>'LONGITUDE_NOT_SPECIFIED'));
			exit;
		}
		else if (!isset($latitude))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"Latitude is not specified for the event location.",'Code'=>'LATITUDE_NOT_SPECIFIED'));
			exit;
		}
		else if (empty($radius))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"The radius is not specified.",'Code'=>'RADIUS_NOT_SPECIFIED'));
			exit;
		}
		else if (empty($timestamp))
		{ 
			echo json_encode(array('Result'=>false,'Error'=>"The timestamp is not specified.",'Code'=>'TIMSTAMP_NOT_SPECIFIED'));
			exit;
		}
		
		$currentTime = new Zend_Date();
		$dataArray = array('Trip_ID'=>$tripID,'Longitude'=>$longitude,'Latitude'=>$latitude,'Speed'=>$speed,'Heading'=>$heading,'Recorded_Time'=>$currentTime->get(SQL_DATE_PATTERN));
		
		Classes_GPS::addGPSRecord($dataArray);
		$minimumDistance = 0;
		//if($speed>0)
			//$minimumDistance = (($speed / 3600) * MINIMUM_EARLY_WARNING_DURAION);
		$eventsList = Classes_Event::listNearestEvents($latitude,$longitude,$radius,$minimumDistance,$timestamp);
	
		$jsonString = json_encode($eventsList);
		if($jsonString  == "false")
		{
			echo json_encode(array('Result'=>false,'Error'=>"Error occurred.",'Code'=>'UNKNOWN_ERROR'));
			exit;
		}
		echo $jsonString ;
		exit;
		
	}
}