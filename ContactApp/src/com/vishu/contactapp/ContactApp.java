package com.vishu.contactapp;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ContactApp 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		String name=null,address=null,petname=null,tags=null,emailid=null;
		String phno=null;
		Date dob=null;
		String bookName=null;
		int c=0;
		ContactModel model = new ContactModel();
		try {
			while(c!=6)
			{
				System.out.println(" ");
				System.out.println("press 1 to create contacts Book");
				System.out.println("press 2 to load contacts Book");
				System.out.println("press 3 to search contacts");
				System.out.println("press 4 to list contacts ");
				System.out.println("press 5 to exit");
				System.out.println("enter the number");
				c=sc1.nextInt();
				switch(c) 
				{
				case 1: 
				{
					System.out.println("creating the contacts");
					System.out.println("enter the contact book name");
					bookName=sc2.nextLine();

					while(true)
					{
						if(!Util.isValidName(bookName))
						{
							System.out.println(" enter a valid name");
							bookName=sc2.nextLine();
							continue;
						}
						if(model.isBookexist(bookName))
						{
							System.out.println(" enter unique name");
							bookName=sc2.nextLine();
							continue;
						}
						else
							break;
					}

					int x=0;
					while(x!=6) 
					{
						System.out.println("press 1 to addcontact");
						System.out.println("press 2 to edit contact");
						System.out.println("press 3 to remove contact");
						System.out.println("press 4 to list contact");
						System.out.println("press 5 to search");
						System.out.println("press 6 to goback");
						x=sc2.nextInt();
						switch(x) {
						case 1: 
						{
							System.out.println("adding the contact ");

							System.out.println("enter the name");
							name=sc2.next();
							System.out.println("Enter date of birth(dd/mm/yyyy)");
							String dt = sc2.next();
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							dob = sdf.parse(dt);
							System.out.println("enter the address");
							address = sc2.next();
							System.out.println("enter the petname");
							petname = sc2.next();
							System.out.println("enter the tags");
							tags = sc2.next();
							System.out.println("enter the emailid");
							emailid=sc2.next();
							System.out.println("enter the phone number");
							phno = sc2.next();


							ContactBean cb = new ContactBean(name,dob,address,petname,tags,emailid,phno);
							model.addContact(cb,bookName);
							System.out.println(" success");
							break;
						}
						case 2:
						{ 
							System.out.println("editing the contact book");
							List<ContactBean>list=model.getcontacts(bookName);
							for(int i=0; i<list.size(); i++)
							{
								System.out.println(i+" )"+list.get(i).toString());
							}
							System.out.println(" select sl no of contact to be edited");
							int sl=sc1.nextInt();

							ContactBean old=list.get(sl);
						    System.out.println("editing the contact "+old.toString());

							int ch5=0;
							while(ch5!=4)
							{
								System.out.println(" 1 to edit name");
								System.out.println(" 2 to edit petname");
								System.out.println(" 3 to edit phone number");
								System.out.println(" 4 to save ");

								ch5=sc1.nextInt();

								switch (ch5) 
								{
								case 1:
								{
								   
								    System.out.println("enter the new name ");
								    name =sc2.next();
								    old.setName(name);
									break;
								}
								case 2:
								{    
									System.out.println("enter the new petname");
                                   petname = sc2.next();
                                    old.setPetname(petname);
									break;
								}
								case 3:
								{    
									System.out.println("enter the new phone number");
                                    phno = sc2.next();
                                    old.setPhno(phno);;
									break;
								}
								case 4:
								{
									model.update(list,bookName);
									System.out.println("saved successfully");
									break;
								}
								default:
									break;
								}
							}
							break;
						}
						case 3:
						{
						System.out.println("removing the contactbook");
						System.out.println("enter the book name to be removed");
						bookName = sc2.next();
						System.out.println("enter the name of contact to be removed");
						name = sc2.next();
						Set<ContactBean> rem = model.removecontacts(bookName,name);
						for(ContactBean r:rem)
						{
							System.out.println(r);

						}
						System.out.println("contactbook is removed successfully");
						break;
						}
						case 4: 
						{
							System.out.println("listing the contacts");
							System.out.println("Enter contactbook");
							bookName = sc2.next();
							List<ContactBean> beans = model.getcontacts(bookName);
							for(ContactBean bean:beans)
							{
								System.out.println(bean);

							}
							break;
						}
						case 5:{
						System.out.println("searching the contact");	
						System.out.println("enter the bookname to be search");
						bookName = sc2.next();
						System.out.println("enter the name of the contact");
						name = sc2.next();
					    model.searchcontact(bookName,name);
							break;
                        }
					  }
					}
				}
				case 2:{
					    System.out.println("loading the contactbook");
				        model.LoadContactbook();
				        System.out.println("contacts book is loaded successfully");
				break;
				}
				case 3:{
					System.out.println("searching the contactbook");
					bookName = sc2.next();
					model.searchcontactbook(bookName);
					break;
				}
				case 4:{
					    System.out.println("listing the contactbook");
				        model.LoadContactbook();
					    break;
				}
				case 5:{
					System.out.println("removing the contactbook");
					System.out.println("enter the bookname to remove");
					bookName = sc2.next();
					model.removecontactbook(bookName);
					System.out.println("bookname is removed successfully");
					 model.LoadContactbook();
				}
				case 6: {
					System.out.println("exittt!");
				}
					break;
					}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("oops something happened,error"+e.getMessage());
		}
		finally {
			sc1.close();
			sc2.close();
		}

	}
}



