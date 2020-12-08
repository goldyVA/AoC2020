import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day7Part2 
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String[]> formatted = new ArrayList<String[]>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day7.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextLine());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    //creates an array list called formatted with the formatted bags and what they contain
    for(int i = 0; i < list.size(); i++)
    {
    	String[] split = list.get(i).split(" contain |, ");
    	String[] temp = new String[split.length];
    	temp[0]=split[0].substring(0,split[0].indexOf(" bag"));
    	for(int j = 1; j<split.length;j++)
    	{
    		if(split[j].indexOf("other") != -1)
    			temp[j]=split[j];
    		else
    			temp[j]=split[j].substring(2,split[j].indexOf(" bag")) + ","+split[j].charAt(0);		
    	}
    	formatted.add(temp);
    }
    
    /*
    for(String[] x : formatted)
    {
    	for(String y: x)
    	{
    		System.out.println(y);
    	}
    	System.out.println();
    }
    */
    
    
    System.out.println(countBags("shiny gold", formatted));
    
    
    
    
    
  }
  
  
  public static int rule2(String x, ArrayList<String[]> formatted)
  {
	  System.out.println(x+ " contains:");
	  for(String[] y : formatted)
	  {
		  if(y[0].indexOf(x)!=-1)
		  {
			  //System.out.println(y[0]);
			  /*for(int i = 0; i < y.length;i++)
			  {
				  if(i == 0)
					  System.out.print(y[i] + "      ");
				  else
					  System.out.print(y[i]+ " ");
			  }*/
			  if(y[1].indexOf("other")!=-1)
			  {
				  System.out.println("no other bags");
				  return 0;
			  }
			  for(int i = 1; i < y.length; i++)
			  {
					  System.out.println(y[i].substring(y[i].length()-1) + " " +y[i].substring(0,y[i].length()-2));
					  rule2(y[i].substring(0,y[i].length()-2),formatted);
				  
					  
			  }
		  }
		  

		  
	  }
	  //System.out.println("four");
	  System.out.println();
	  return 0;
	  
  }
  
  
  public static int countBags(String x, ArrayList<String[]> formatted)
  {
	 
	  for(String[] y : formatted)
	  {
		  
		  if(y[0].indexOf(x)!=-1)
		  {
			  //System.out.println(y[0]);
			  if(y[1].indexOf("other") != -1)
			  {
				  //System.out.println("AAAAA"+y[1]);
				  return 1;
			  }
			  else if(y.length==2)
			  {
				  //System.out.println("BBBBB"+y[1]);
				  return 1+ Integer.parseInt(y[1].substring(y[1].length()-1)) * countBags(y[1].substring(0,y[1].length()-2), formatted);
			  }
			  else if(y.length==3)
			  {
				  //System.out.println("CCCCC "+y[0]+"      "+y[1]+" " + y[2]);
				  return 1+Integer.parseInt(y[1].substring(y[1].length()-1)) * countBags(y[1].substring(0,y[1].length()-2), formatted) + Integer.parseInt(y[2].substring(y[2].length()-1)) * countBags(y[2].substring(0,y[2].length()-2), formatted);
			  }
			  else if(y.length==4)
			  {
				  //System.out.println("DDDDD "+y[0]+"      "+y[1]+" " + y[2]+" " + y[3]);
				  return 1+Integer.parseInt(y[1].substring(y[1].length()-1)) * countBags(y[1].substring(0,y[1].length()-2), formatted) + Integer.parseInt(y[2].substring(y[2].length()-1)) * countBags(y[2].substring(0,y[2].length()-2), formatted)+ Integer.parseInt(y[3].substring(y[3].length()-1)) * countBags(y[3].substring(0,y[3].length()-2), formatted);
			  }
			  else if(y.length==5)
			  {
				  //System.out.println("EEEEE "+y[0]+"      "+y[1]+" " + y[2]+" " + y[3]+" " + y[4]);
				  return 1+Integer.parseInt(y[1].substring(y[1].length()-1)) * countBags(y[1].substring(0,y[1].length()-2), formatted) + Integer.parseInt(y[2].substring(y[2].length()-1)) * countBags(y[2].substring(0,y[2].length()-2), formatted)+ Integer.parseInt(y[3].substring(y[3].length()-1)) * countBags(y[3].substring(0,y[3].length()-2), formatted)+ Integer.parseInt(y[4].substring(y[4].length()-1)) * countBags(y[4].substring(0,y[4].length()-2), formatted);
			  }
		  }
	  }
	  
	
	  
	  return 0;
  }
}