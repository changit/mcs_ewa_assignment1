<?php
 /*
 * @Project:    UberDash
 * @File:       Encryption.php
 * @Package:	Classes
 * @Version:	1.00
 * @Copyright:  2012 UberDash
 * @Author:		Prasad Rajapaksha <prasadrajapaksha@gmail.com>
 *
 * This class works as the DB Adapter
 *
 *
 */

class Classes_Encryption {

	/** 
     * Generate the Hash 
     * @return String 
     * @param $password String 
     * @param $salt String[optional] 
     * @param $iterations Int[optional] 
     * @param $secret String[optional] 
     */  
    public static function generatePassword($password, $salt = null, $iterations = 2, $hash_function = 'sha1', $secret = '')  
    {  
        $salt or $salt = self::generateSalt();  
        $hashes = array();  
        $hash = $password;  
        // hash a sequence of hashes, each hash depends on the last one, so any implementation must hash each one individually  
        $i = $iterations;  
        while(--$i)  
        {  
            $hash = $hash_function($hash.$salt.$secret);  
        }  
        return implode(':', array($hash, $salt));  
    } 
	
	/** 
     * Verify a password meets a hash 
     * @return Bool 
     * @param $password String 
     * @param $hash String 
     * @param $secret String[optional] 
     */  
    public static function verify($password, $hash, $secret = '')  
    {  
        list($_hash, $salt) = explode(':', $hash);  
        return ($hash == self::generatePassword($password, $salt, 2, 'sha1', ''));  
    }  
	
	/** 
     * Generate a random hex based salt 
     * @return String 
     * @param $length Int[optional] 
     */  
    public static function generateSalt($length = 40)  
    {  
        $salt = array();  
        for( $i = 0; $i < $length; ++$i )  
        {  
            $salt[] =  dechex( mt_rand(0, 15) );  
        }  
        return implode('', $salt);  
    } 
}

