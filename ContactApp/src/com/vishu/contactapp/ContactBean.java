package com.vishu.contactapp;




import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ContactBean implements Comparable<ContactBean>,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Set<String> emailid = new HashSet<String>();
	private Set<String> phno = new HashSet<String>();
	private Date dob;
	private String address;
	private String petname;
	private String tags;
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

	public ContactBean(String name, Date dob, String address, String petname, String tags, String emailid, String phno) {
		this.name = name;
		this.dob =dob;
		this.address=address;
		this.petname=petname;
		this.tags=tags;
		String[] sa =emailid.split(",");
		for(String s:sa)
			this.emailid.add(s);
		
		String[] str =phno.split(",");
		for(String s:str)
			this.phno.add(s);
	
	}
		public ContactBean(String name,String emailid,String phno,String dob,String address,String petname, 
			String tags) throws ParseException 
	{
		// TODO Auto-generated constructor stub
		this.name = name;
		this.dob =sdf.parse(dob);
		this.address=address;
		this.petname=petname;
		this.tags=tags;
		String[] sa =emailid.split(",");
		for(String s:sa)
			this.emailid.add(s);

		String[] str =phno.split(",");
		for(String s:str)
			this.phno.add(s);

	}

		@Override
	public String toString() 
		{
			String ph="";
			for(String s:this.phno)
				ph=ph+","+s;
			
			String em="";
			for(String s:this.emailid)
				em=em+","+s;
			
			
		return  name + ":" + em + ":" + ph + ":" + sdf.format(dob) + ":"
				+ address + ":" + petname + ":" + tags ;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getEmailid() {
		return emailid;
	}

	public void setEmailid(Set<String> emailid) {
		this.emailid = emailid;
	}

	public Set<String> getPhno() {
		return phno;
	}

	public void setPhno(Set<String> phno) {
		this.phno = phno;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPetname() {
		return petname;
	}

	public void setPetname(String petname) {
		this.petname = petname;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

		@Override
	public int hashCode() {
		return(this.name+this.dob+this.address+this.petname.toString()).hashCode();
	}
	
	public int compareTo(ContactBean obj) {
		// TODO Auto-generated method stub
		return this.name.compareTo(obj.name);
	}
			@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof ContactBean)) {
				return false;
			}
			ContactBean other = (ContactBean) obj;
			if (address == null) {
				if (other.address != null) {
					return false;
				}
			} else if (!address.equals(other.address)) {
				return false;
			}
			if (dob == null) {
				if (other.dob != null) {
					return false;
				}
			} else if (!dob.equals(other.dob)) {
				return false;
			}
			if (emailid == null) {
				if (other.emailid != null) {
					return false;
				}
			} else if (!emailid.equals(other.emailid)) {
				return false;
			}
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			if (petname == null) {
				if (other.petname != null) {
					return false;
				}
			} else if (!petname.equals(other.petname)) {
				return false;
			}
			if (phno == null) {
				if (other.phno != null) {
					return false;
				}
			} else if (!phno.equals(other.phno)) {
				return false;
			}
			if (tags == null) {
				if (other.tags != null) {
					return false;
				}
			} else if (!tags.equals(other.tags)) {
				return false;
			}
			return true;
		}
			public void setPhno(String phno2) 
			{
				for(String s:phno2.split(","))
					 this.phno.add(s);
			}
	
}

