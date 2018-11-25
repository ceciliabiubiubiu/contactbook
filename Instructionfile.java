package ECB18S1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//field
public class Instructionfile {
		ArrayList<Phonebookfile> pb;
//constructor
public Instructionfile() {
		pb= new ArrayList<Phonebookfile>();
		System.out.println("Making new phonebook");
}
	
			
//method			
public ArrayList<Phonebookfile> getarraylist() {
		return pb;
}
//add the file
public void addfile(Phonebookfile pbf) {
	boolean exist = false;
    for(int i=0; i<pb.size(); i++)
    {
    	if(pbf.getname().equals(pb.get(i).getname())&&pbf.getbirthday().getvalue() == pb.get(i).getbirthday().getvalue())
    	{
    		pb.set(i, pbf);
    		exist = true;
    		break;
    	}
    }
    
    
    if(exist == false) {
    	pb.add(pbf);
    }
}


//delete the file
public void deletefile(String name, String birthday) {
	for(int i=0; i<pb.size(); i++) {
		if(name.equals(pb.get(i).getname())&&birthday.equals(pb.get(i).getbirthday().getinput())) {
			pb.remove(pb.get(i));
		}
	}
}


//save the file
public void savefile(File fl) {
	try {
		PrintWriter out=new PrintWriter(new FileOutputStream(fl));
		for(int i=0; i<pb.size(); i++) {
			if(pb.get(i).getname()!=null) {
				out.println("name: "+pb.get(i).getname());
			}
			if(pb.get(i).getbirthday()!=null) {
				out.println("birthday: "+pb.get(i).getbirthday().getinput());
			}
			if(pb.get(i).getaddress()!=null) {
				out.println("address: "+pb.get(i).getaddress());
			}
			if(pb.get(i).getphone()!=null) {
				out.println("phone: "+pb.get(i).getphone());
			}
			if(pb.get(i).getemail()!=null) {
				out.println("email: "+pb.get(i).getemail());
			}
			out.println();
		}
		out.close();
	}catch(Exception e) {
		
	}
}



//query the file by name, birthday, phone
public void queryfile(String name, Dateofbirth birthday, String phone, String fl) {
	ArrayList<Phonebookfile> namearray=new ArrayList<Phonebookfile>();
	ArrayList<Phonebookfile> birtharray=new ArrayList<Phonebookfile>();
	ArrayList<Phonebookfile> phonearray=new ArrayList<Phonebookfile>();
	try {
		
		
	if(name!=null) {
		for(int i=0; i<pb.size(); i++) {
			if(pb.get(i).getname().equals(name)) {
				namearray.add(pb.get(i));
			}
		}	
		FileWriter file3 = new FileWriter(fl, true);
		PrintWriter out=new PrintWriter(file3);
		out.printf("=======query name %s=======\r\n",name);
		for(Phonebookfile pbf: namearray) {
			out.printf("name: %s\r\nbirthday: %s\r\naddress: %s\r\n", pbf.getname(), pbf.getbirthday().getinput(), pbf.getaddress());
		}
		 out.printf("=======end of query name %s=======\r\n",name);
		 out.close();
	}
	   
	if(birthday!=null) {
		for(int i=0; i<pb.size(); i++) 
		{
			if(pb.get(i).getbirthday().getinput().equals(birthday.getinput())) {
				birtharray.add(pb.get(i));
			}
		}
		FileWriter file3 = new FileWriter(fl, true);
		PrintWriter out=new PrintWriter(file3);
		out.printf("=======query birthday %s=======\r\n",birthday.getinput());
		for(Phonebookfile pbf: birtharray) {
			out.printf("name: %s\r\nbirthday: %s\r\naddress: %s\r\n", pbf.getname(), pbf.getbirthday().getinput(), pbf.getaddress());
		}
		out.printf("=======end of query birthday %s=======\r\n",birthday.getinput());
		out.close();
	}
	    
	if(phone!=null) {
		for(int i=0; i<pb.size(); i++) 
		{
			if(pb.get(i).getphone() != null && pb.get(i).getphone().equals(phone)) {
				phonearray.add(pb.get(i));
			}
		}
		FileWriter file3 = new FileWriter(fl, true);
		PrintWriter out=new PrintWriter(file3);
		out.printf("=======query phone %s=======\r\n",phone);
		for(Phonebookfile pbf: phonearray) {
			out.printf("name: %s\r\nbirthday: %s\r\naddress: %s\r\nemail: %s\r\nphone: %s\r\n", pbf.getname(), pbf.getbirthday().getinput(), pbf.getaddress(), pbf.getemail(), pbf.getphone());
		}
		out.printf("=======end of query phone %s=======\r\n",phone);
		out.close();
	}
	
}catch(Exception e) {
	
}

}	
}
    


