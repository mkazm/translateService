package com.kazm.translate.tools;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;

public class Tools {
	public static String getFormatedDate(DateTime date){
		DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm dd/MM/yyyy");
		return dtf.print(date);
	}
	
    public static final DateTime getCurrentTime() {
	DateTimeZone zone = DateTimeZone.forID("Europe/Warsaw");
	LocalDateTime local = new LocalDateTime(System.currentTimeMillis(), zone);
	return local.toDateTime();
    }
  


    public static String getHash(){
	SecureRandom random = new SecureRandom();
	String hash = new BigInteger(130, random).toString(32);
	return hash;
    }
    
    public static String getRootUrl(HttpServletRequest request){
    	String root = request.getRequestURL().toString();
    	if(request.getServletPath()!=null)root = root.replace(request.getServletPath(), "");
    	if(request.getPathInfo()!=null)root = root.replace(request.getPathInfo(), "");
    	return root;
        }
    
}
