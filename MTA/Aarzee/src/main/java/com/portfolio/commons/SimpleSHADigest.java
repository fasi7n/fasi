package com.portfolio.commons;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;

@Controller
public class SimpleSHADigest {
	
	
	public static String mySha1(String dataToHash)
	{
		MessageDigest md = null;
		try
		{
			md = MessageDigest.getInstance("SHA1");
		}
		catch (NoSuchAlgorithmException e)
		{		
			e.printStackTrace();
		}
		
		byte[] dataInBytes = dataToHash.getBytes(); 
		md.update(dataInBytes, 0, dataInBytes.length);
		BigInteger bi = new BigInteger(1, md.digest());
		return String.format("%1$040X", bi);
	}

}
