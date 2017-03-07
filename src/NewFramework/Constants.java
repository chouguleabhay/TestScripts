package NewFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Constants {
public static final String url="http://enterprise.demo.orangehrmlive.com/symfony/web/index.php/auth/login";
public static final String FF="FF";
public static final String CH="CH";
public static final String IE="IE";
public static final String mouseOverEle="xpath";
public static final String ScreenShotFilePath="filepath";
public static enum type {ByIndex,ByValue,ByVisibleText};
public static final String gooSearchBtn ="//*[@id='tsf']/div[2]/div[3]/center/input[1]";
public static final int implWait = 10;
public static final String back ="back";
public static final String Loginbtn="className#logbt";
public static HashMap has(){
	HashMap newmap = new HashMap();
	newmap.put("1", "Abhay");
	newmap.put("className", "Saroj");
	newmap.put("3", "Paras");
	newmap.put("Aj", "Ajay");
	return newmap;
	}

public static Map pair(){
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	List<String> valSetOne = new ArrayList<String>();
	valSetOne.add("id");
	valSetOne.add("btnOrange");
			
	List<String> valSetTwo = new ArrayList<String>();
	valSetTwo.add("xpath");
	valSetTwo.add("//xyz");
	
	map.put("btname", valSetOne);
	map.put("txtbox", valSetTwo);
	
	return map;
	}

public static void defineList(){
		Map<String, List<String[]>> map = new HashMap<String, List<String[]>>();
		List<String[]> setVal = new ArrayList<String[]>();
		
		setVal.add(new String[] {"A1","A2"});
		map.put("txtbox", setVal);	
		
		}

public static void defineFunc(){
	HashMap<String, HashMap<String, String>> myArray = new HashMap<String, HashMap<String,String>>();
	HashMap<String, String> value = new HashMap<String, String>();
	value.put("id", "btnId");
	value.put("xpath", "//xpath");
	value.put("contact", "Contactdetails");
	
	myArray.put("ABC", value);
	
	String key = null;
	
	for(Map.Entry<String, HashMap<String, String>> entry : myArray.entrySet()){
		key = entry.getKey();
		value = entry.getValue();	
		System.out.println("Key = "+ key + " Value = "+ value);
		}	
	}

}

