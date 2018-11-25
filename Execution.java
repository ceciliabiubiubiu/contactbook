package ECB18S1;
import java.util.*;
import java.io.*;
public class Execution {
	public static void main(String[] args) {
		Instructionfile pb=new Instructionfile();
		System.out.println("input the phone book file name: ");
		Scanner reader=new Scanner(System.in);
		String reader1=reader.nextLine();
		File file1=new File(reader1);
		try {
			//read the content of phone book file
			boolean validname = true;
			boolean validbirthday=true;
			boolean validinfo;
			String name = null;
			Dateofbirth birthday=null;
			String address=null;
			String email=null;
			String phone=null;
			Scanner readfile1=new Scanner(file1);
			while(readfile1.hasNextLine()) {
			//create a new phone book file
				String line=readfile1.nextLine();
	        	  String[] begin=line.split(" ");
	        	  String beginword=begin[0];
	        			if(beginword.equals("name")) {
	        				name = line.substring(4).trim();
	        			}
	        			if(beginword.equals("birthday")) {
	        				birthday=new Dateofbirth(line.substring(8).trim());

	        			}
	        			if(beginword.equals("address")) {
	        				address=line.substring(7).trim();
	        			}
	        			if(beginword.equals("email")) {
	        				email=line.substring(5).trim();
	        			}
	        			if(beginword.equals("phone")) {
	        				phone=line.trim().substring(5).trim();
	        			}

	        	       if(line.isEmpty()) {
	        			Phonebookfile pbf=new Phonebookfile(name, birthday, email, address, phone);
	        			if(pbf.getname()!=null&&pbf.getbirthday()!=null) {
    //add the phone book file content to the arraylist
	        				if(pbf.getname().matches("[a-zA-Z\\s]+")){
	        				pb.getarraylist().add(pbf);
	        			}
	        			}
                       name = null;
                       phone = null;
                       address = null;
                       email = null;
                       birthday = null;
	        	       }
	   
			}
			
			if (name != null)
			{
				Phonebookfile pbf=new Phonebookfile(name, birthday, email, address, phone);
	            pb.getarraylist().add(pbf);
			}
				} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
//read the name of output file;
		System.out.println("input the output file name: ");
        String reader2=reader.nextLine();
        File file2=new File(reader2);
        
        
        
//read the name of report file;
        System.out.println("input the report file name: ");
        String reader3=reader.nextLine();
        FileWriter file3 = null;

        
        

//read the content of instruction file;
		System.out.println("input the instruction file name: ");
		String reader4=reader.nextLine();
		File file4=new File(reader4);
		
		String name = null;
		Dateofbirth birthday=null;
		String strbirthday=null;
		String address=null;
		String email=null;
		String phone=null;
		try {
			Scanner readfile4=new Scanner(file4);
			while(readfile4.hasNextLine()) {
				String line=readfile4.nextLine();
				String[] instr=line.split(" ");
				String instruction=instr[0];
//the instruction is add				
				if(instruction.equals("add")) {
					String subline=line.substring(3).trim();
					String[] array=subline.split(";");
					for(int i=0; i<array.length;i++) {
						array[i]=array[i].trim();
						String[] begin=array[i].split(" ");
						String beginword=begin[0];
						if(beginword.equals("name")) {
	        				name = array[i].substring(4).trim();
	        			}
	        			if(beginword.equals("birthday")) {
	        				birthday=new Dateofbirth(array[i].trim().substring(8).trim()) ;
	        			}
	        			if(beginword.equals("address")) {
	        				address=array[i].trim().substring(7);
//	        				System.out.println("o"+address+"u");
	        			}
	        			if(beginword.equals("email")) {
	        				email=array[i].substring(5).trim();
	        			}
	        			if(beginword.equals("phone")) {
	        				phone=array[i].substring(5).trim();
	        			}
					}
			    Phonebookfile pbf=new Phonebookfile(name, birthday, email, address, phone);

			        pb.addfile(pbf);
			        name=null;
			        birthday=null;
			        email=null;
			        address=null;
			        phone=null;
					}
				
				
//the instruction is delete
				if(instruction.equals("delete")) {
					String subline=line.substring(6).trim();
					String[] array=subline.split(";");
					for(int i=0; i<array.length; i++) {
						array[i]=array[i].trim();
					}
					name=array[0];
					strbirthday=array[1];
					if(strbirthday.matches("\\d+\\D\\d+\\D\\d+")) {
						String[] temp=strbirthday.split("\\D");
						for(int i=0; i<2; ++i) {
							if(temp[i].length()<2)
								temp[i]="0"+temp[i];
						}
						strbirthday=temp[0]+"-"+temp[1]+"-"+temp[2];
					}
					pb.deletefile(name, strbirthday);
			    }
				
//the instruction is save				
				if(instruction.equals("save")) {
					pb.savefile(file2);
				}
				
//the instruction is query			
				if(instruction.equals("query")) {
				String subline=line.substring(5).trim();
				String[] begin=subline.split(" ");
				if(begin[0].equals("name")) {
					name=subline.substring(4).trim();
				}else
					name=null;
				if(begin[0].equals("birthday")) {
					birthday=new Dateofbirth(subline.substring(8).trim());
				}else
					birthday=null;
				if(begin[0].equals("phone")) {
					phone=subline.substring(5).trim();
				}else
					phone=null;
				
				pb.queryfile(name, birthday, phone, reader3);
				}
				
				
			}
		}catch(Exception e) {
			
		}
}
}