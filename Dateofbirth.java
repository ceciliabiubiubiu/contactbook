package ECB18S1;
import java.util.*;

import java.io.*;
import java.text.*;
//class of birthday
public class Dateofbirth {
private Date birth;
private static SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
private String input;


//constructor
public Dateofbirth(String dt){
	input=dt;
	String[] temp;
	if(input.matches("\\d+\\D\\d+\\D\\d+")) {
		temp=input.split("\\D");
		if(temp.length==3) {
		for(int i=0; i<2; ++i) {
			if(temp[i].length()<2)
				temp[i]="0"+temp[i];
		}
		input=temp[0]+"-"+temp[1]+"-"+temp[2];
	}
		}
    try {
    	birth=dateformat.parse(input);
    }catch(ParseException e){
    	birth=null;
    }
}
		
//method
public Date getbirth() {
	return birth;
}

public String getinput(){
	return input;
}

public long getvalue() {
	return birth.getTime();
}


}
