package ECB18S1;

import java.util.*;

import java.io.*;
public class Phonebookfile {

		public String name;
		public Dateofbirth birthday;
		public String email;
		public String address;
		public String phone;
		public boolean validinfo;
//constructor		
public Phonebookfile(String info, Dateofbirth bir, String em, String ad, String ph) {
	name = info;
	birthday = bir;
	email=em;
	address=ad;
	phone=ph;
}
	
	
	
        
	//method
        public boolean validinformation() {        
        	return validinfo;
        }

		public String getname() {
		return name;
		}
		public String getemail() {
			return email;
		}
		public Dateofbirth getbirthday() {
			return birthday;
		}
		public String getaddress() {
			return address;
		}
		public String getphone() {
			return phone;
		}
	

}