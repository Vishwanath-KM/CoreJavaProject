package com.vishu.contactapp;

public class Util 
{
	public static boolean isValidName(String name)
	{
		if(name==null || name.trim().equals("") )
			return false;
		if(!Character.isAlphabetic(name.charAt(0)))
				{
					return false;
				}
		
		return true;
		
	}

}
