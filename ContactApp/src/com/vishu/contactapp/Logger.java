package com.vishu.contactapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger 
{
	public static final boolean LOGTOMONITOR = true;
	
	private String path;
	
	//1. mark constructor private
	private Logger() {
		path="log.txt";
	}
	//2. create a single copy ref var 
	private static Logger obj=null;
	
	//3. expose static getInstance() method 
	public static synchronized Logger getInstance()
	{
		//4. do a null check on single copy ref and then create obj
		//only once
		if(obj==null)
			obj= new Logger();
		
		return obj;
	}
	
	public void log(String data) 
	{
		new Thread (new Runnable () {
				public void run()
				{
					Date dt = new Date();
					BufferedWriter bw =null;
					try
					{
						String msg = dt+":"+data;
						bw = new BufferedWriter(new FileWriter(path,true));
						bw.write(msg);
						bw.newLine();
						
						if(Logger.LOGTOMONITOR==true)
							System.out.println("Logger:"+msg);
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					finally
					{
						if(bw!=null)
							try {
								bw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
					}
				}
		}).start();	
	}
	
}
