package org.formprocessor;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class Student {
	
	@Id
	Long id;
	String emailid,name1,name2,college,year,phoneno,department,event;
	public Student(String a,String b,String c,String d,String e,String f,String t1,String t2){
		emailid=a;
		name1=b;
		name2=f;
		college=c;
		year=d;
		phoneno=e;
		department=t1;
		event=t2;
	}
	
	public Student(){
		
	}
}
