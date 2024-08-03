package org.com.streamapi;

import java.util.Arrays;

import org.com.model.Flat;
import org.com.model.MobileNumber;
import org.com.model.Person;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	Flat f = new Flat();

	public Flat objectConverter() throws JsonProcessingException {
		
		// Creating family data
		
		
		f.setFlatId(7);
		f.setBuildNumber("A-16");
		f.setFlatFamilyName("Shelar");
		f.setJoinSoc("1990");

		/////////////--- Creating dilip shelar---------------------
		
		Person dilip_Shelar = new Person();
		dilip_Shelar.setPersonId(1);
		dilip_Shelar.setPersonName("Dilip Dattu Shelar");
		dilip_Shelar.setPersonLocation("Pune Nigadi");
		dilip_Shelar.setPersonBirthPlace("Talegaon dhabhade,Pune");
		dilip_Shelar.setPersonBday("05/08/1959");
		dilip_Shelar.setPersonEmail("dilipshelar@gmail.com");

		MobileNumber moNumber = new MobileNumber();
		moNumber.setMobileId(1);
		moNumber.setMobileNumber("8888641348");
		
		dilip_Shelar.setMobileNumbers(Arrays.asList(moNumber));

/////////////--- Creating pushpa shelar---------------------
		
		Person pushpa_Shelar = new Person();
        pushpa_Shelar.setPersonId(2);
		pushpa_Shelar.setPersonName("Pushpa Dilip Shelar");
		pushpa_Shelar.setPersonLocation("Pune Nigadi");
		pushpa_Shelar.setPersonBirthPlace("Talegaon dhabhade,Pune");
		pushpa_Shelar.setPersonBday("11/06/1963");
		pushpa_Shelar.setPersonEmail("pushpashelar@gmail.com");

		MobileNumber moNumber1 = new MobileNumber();
		moNumber1.setMobileId(2);
		moNumber1.setMobileNumber("9623581846");
		
		pushpa_Shelar.setMobileNumbers(Arrays.asList(moNumber1));

          /////////////--- Creating mauli shelar---------------------
		
		Person mauli_Shelar = new Person();
		mauli_Shelar.setPersonId(3);
		mauli_Shelar.setPersonName("Mauli Dilip Shelar");
		mauli_Shelar.setPersonLocation("Pune Nigadi");
		mauli_Shelar.setPersonBirthPlace("Talegaon dhabhade,Pune");
		mauli_Shelar.setPersonBday("02/04/1992");
		mauli_Shelar.setPersonEmail("maulishelar777@gmail.com");

		MobileNumber moNumber2 = new MobileNumber();
		moNumber2.setMobileId(3);
		moNumber2.setMobileNumber("7304544777");
		
		
		MobileNumber moNumber3 = new MobileNumber();
		moNumber3.setMobileId(4);
		moNumber3.setMobileNumber("7020123078");
	
		mauli_Shelar.setMobileNumbers(Arrays.asList(moNumber2,moNumber3));
		
		
        /////////////--- Creating mauli shelar---------------------
		
		Person supriya_Shelar = new Person();
		supriya_Shelar.setPersonId(3);
		supriya_Shelar.setPersonName("Supriya Mauli Shelar");
		supriya_Shelar.setPersonLocation("Pune Nigadi");
		supriya_Shelar.setPersonBirthPlace("Barshi,Solapur");
		supriya_Shelar.setPersonBday("11/05/1994");
		supriya_Shelar.setPersonEmail("supriyasavant@gmail.com");

		MobileNumber moNumber4 = new MobileNumber();
		moNumber4.setMobileId(5);
		moNumber4.setMobileNumber("7020606260");
		
		
		MobileNumber moNumber5 = new MobileNumber();
		moNumber5.setMobileId(6);
		moNumber5.setMobileNumber("8983623409");
		
		supriya_Shelar.setMobileNumbers(Arrays.asList(moNumber4,moNumber5));
	f.setFamilyMembers(Arrays.asList(dilip_Shelar,pushpa_Shelar,mauli_Shelar,supriya_Shelar));
	
	System.out.println("hello..................................");
	//System.out.println(f);
	
	
	 ObjectMapper mapper = new ObjectMapper(); String json =
	 mapper.writeValueAsString(f);
	  
	  
	 System.out.println("json  :    "+json);
	 
	
		
		
		return f;
	}

}
