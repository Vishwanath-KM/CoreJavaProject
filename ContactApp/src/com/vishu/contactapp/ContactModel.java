package com.vishu.contactapp;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactModel 
{

	public boolean isBookexist(String bookName) 
	{
		return new File(Constants.PATH+bookName+".con").exists();
	}

	public boolean addContact(ContactBean cb, String bookName) throws IOException 
	{
		BufferedWriter bw=null;
		try
		{
			bw=new BufferedWriter(new FileWriter(Constants.PATH+bookName+".con",true));
			bw.write(cb.toString());
			bw.newLine();
			
			return true;
		}
		finally 
		{
			if(bw!=null)
			bw.close();
		}
	}
	public List<ContactBean> getcontacts(String bookName) throws ParseException {
		
	List<ContactBean> beans = new ArrayList<ContactBean>();
	
	BufferedReader br = null;
	try
	{
		br = new BufferedReader(new FileReader(Constants.PATH+bookName+".con"));
		String line;
		while((line = br.readLine())!=null)
		{
			String[] sa = line.split(":");
			
			ContactBean bean = new ContactBean(sa[0],sa[1],sa[2],sa[3],sa[4],sa[5],sa[6]);
			beans.add(bean);
			System.out.println(br.read());
		}
		
		return beans;
	}
	catch(IOException e)
	{
		e.printStackTrace();
		return null;
	}
	finally
	{
		if(br!=null)
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	  }
	
	@SuppressWarnings("resource")
	public Set<ContactBean> removecontacts(String bookName,String name) throws ParseException {
		
		Set<ContactBean> rem = new HashSet<ContactBean>();
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		try
		{
			br = new BufferedReader(new FileReader(Constants.PATH+bookName+".con"));
			bw = new BufferedWriter(new FileWriter(Constants.PATH+bookName+".con"));
			String line;
			while((line = br.readLine())!=null)
			{
				String[] sa = line.split(":");
				
				ContactBean r = new ContactBean(sa[0],sa[1],sa[2],sa[3],sa[4],sa[5],sa[6]);
				rem.remove(r);
				bw.write(line);
				System.out.println(br.read());
			    
			}
			
			return rem;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public boolean searchcontact(String bookName,String name) {
		boolean a=false;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(Constants.PATH+bookName+".con"));
			String line;
			while((line = br.readLine())!=null) {
				if(line.startsWith(name)) {
					a = true;
				}
				System.out.println(br.read());
				System.out.println(line);
				return a;
			}
		}
			catch(IOException e)
			{
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			finally {
				if(br!=null)
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		return a;
		}
	
	public void update(List<ContactBean> list, String bookName) throws IOException 
	{
		BufferedWriter bw=null;
		try
		{
			bw=new BufferedWriter(new FileWriter(Constants.PATH+bookName+".con"));
			for(ContactBean cb:list)
			bw.write(cb.toString());
			bw.newLine();
			
		}
		finally 
		{
			if(bw!=null)
			bw.close();
		}
	}
	public List<String> LoadContactbook(){
		List<String> list = new ArrayList<String>();
		File folder = new File(Constants.PATH);
		File[] listFile = folder.listFiles();
		for(File f:listFile) {
			if(f.isFile()) {
					list.add(f.getName().replaceAll(".txt", " "));
			}
            System.out.println(list);
		}
		return list;
	}

	public boolean searchcontactbook(String bookName) {
		boolean dd = false;
		File f = new File(Constants.PATH+bookName+".con");
		if(f.exists())
		{
			dd = true;
			System.out.println("book exits");
			return dd;
		}
		return dd;
	}

	public boolean removecontactbook(String bookName) {
		boolean d= false;
		File f = new File(Constants.PATH+bookName+".con");
		if(f.exists())
		{
			d = f.delete();
			System.out.println(d+ " is removed");
			return d;
		}
		return d;
	}
				
	}





			
			
			
		
		
		
	
	


	

		
	
	
		

		
	





			
			
			
		
		
		
	
	


	

		
	
	
		

		
	