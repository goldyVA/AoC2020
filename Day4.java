import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day4 
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day4.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextLine());
    	}
    }
    catch(Exception e) 
    {	
    }
    
   
    //set up the passwords
    ArrayList<String> array = new ArrayList<String>();
    String x = "";
    for(int i = 0; i < list.size()-1 ;i++)
    {
    	if(!list.get(i+1).equals(""))
    		x=x+list.get(i) + " ";
    	else
    	{
    		x=x+list.get(i) + " ";
    		array.add(x);
    		x="";
    	}
    }
    
    //handle the last one
    array.add("hgt:173cm byr:1925 pid:070222017 iyr:2013 hcl:#ceb3a1 ecl:gry eyr:2024");
    
    //clean it up
    for(int i = 0; i < array.size()-1 ;i++)
    {
    	if(array.get(i).substring(0,1).equals(" "))
    		array.set(i, array.get(i).substring(1));
    }
    

    //part 1
    int valid = 0;
    for(String a: array)
    {
    	int count = 0;
    	for(int i = 0; i <a.length(); i++)
    	{
    		if(a.charAt(i) == ':')
    			count++;
    	}
    	
    	if(count == 8)
    		valid++;
    	if(count == 7)
    		if(a.indexOf("cid:") == -1)
    			valid++;
    }
    
    System.out.println(valid);
    
    
    //part 2
    valid = 0;
    ArrayList<String> validPassports = new ArrayList<String>();
    //set up ArrayList of valid passports from part 1
    for(String a: array)
    {
    	int count = 0;
    	for(int i = 0; i <a.length(); i++)
    	{
    		if(a.charAt(i) == ':')
    			count++;
    	}
    	
    	if(count == 8)
    		validPassports.add(a);
    	if(count == 7)
    		if(a.indexOf("cid:") == -1)
        		validPassports.add(a);
    }
    
    //loop through valid passports and get data in order
    //remove the expected field labels
    //test if they are valid passports
    for(String a: validPassports)
    {
    	String[] split = a.split(" ");
    	ArrayList<String> temp = new ArrayList<String>();
    	for(int i = 0; i < split.length; i++)
    		temp.add(split[i]);
    	Collections.sort(temp);
    	for(int i =0; i <temp.size(); i++)
    	{
    		temp.set(i, temp.get(i).substring(4));
    	}
    	
    	
    	if(validP(temp))
    	{
    		valid++;
    	}
   
    }
    System.out.println(valid);

  }
  
  //method to check for valid passports
  public static boolean validP(ArrayList<String> list)
  {
	  if(list.size()==8)
	  {
		list.remove(1);
	  }
	  
	  int valid = 0;
	  if(Integer.parseInt(list.get(0)) >= 1920 && Integer.parseInt(list.get(0))<=2002)
		  valid++;
	  if(list.get(1).equals("amb") || list.get(1).equals("blu") || list.get(1).equals("brn") || list.get(1).equals("gry") || list.get(1).equals("grn") || list.get(1).equals("hzl") || list.get(1).equals("oth") )
		  valid++;
	  if(Integer.parseInt(list.get(2)) >= 2020 && Integer.parseInt(list.get(2))<=2030)
		  valid++;
	  
	  String temp = list.get(3);
	  if(temp.length() == 7)
	  {
		  if(temp.charAt(0) == '#')
		  {
			  int check = 0;
			  for(int i=1; i<temp.length(); i++)
			  {
				  int test = (int) temp.charAt(i);
				  if((test>=48 &&test<=57))
					  check++;
				  if((test>=97 &&test<=102))
					  check++;
			  }
			  if(check == 6)
				  valid++;
		  }
	  }
	  
	  temp = list.get(4);
	  if(temp.indexOf("cm") != -1)
	  {
		  temp=temp.substring(0,temp.indexOf("cm"));
		  int cm = Integer.parseInt(temp);
		  if(cm>=150 && cm <=193)
			  valid++;
	  }
	  else if(temp.indexOf("in") != -1)
	  {
		  temp=temp.substring(0,temp.indexOf("in"));
		  int in = Integer.parseInt(temp);
		  if(in>=59 && in <=76)
			  valid++;
	  }
	  
	  if(Integer.parseInt(list.get(5)) >= 2010 && Integer.parseInt(list.get(5))<=2020)
		  valid++;
	  
	  if(list.get(6).length()==9)
		  valid++;
	  
	  
	  
	  if(valid == 7)
		  return true;
	  else
		  return false;
	 
  }
  
  
  
}