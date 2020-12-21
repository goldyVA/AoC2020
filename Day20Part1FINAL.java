import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day20Part1FINAL 
{
  public static void main(String[] args) 
  {
    HashMap<Integer, char[][]> list = new HashMap<Integer, char[][]>();
    HashMap<Integer, String[]> updatedList = new HashMap<Integer, String[]>();
    ArrayList<Integer> keys = new ArrayList<Integer>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day20.txt"));
    	while(scan.hasNextLine())
    	{
    		char[][] temp = new char[10][10];
    		String a = scan.nextLine();
    		a = a.substring(5,9);
    		keys.add(Integer.parseInt(a));
    		for(int i = 0; i< 10; i++)
    		{
    			String b = scan.nextLine();
    			for(int j = 0; j< 10; j++)
    			{
    				temp[i][j] = b.charAt(j);
    			}
    		}
    		list.put(Integer.parseInt(a), temp);
    		scan.nextLine();
    	}
    }
    catch(Exception e) 
    {	
    }
    
    for(int i = 0; i<list.size();i++)
    {
    	char[][] temp = list.get(keys.get(i));
    	String[] temp2 = new String[8];
    	temp2[0] = topCW(temp);
    	temp2[1] = rightCW(temp);
    	temp2[2] = bottomCW(temp);
    	temp2[3] = leftCW(temp);
    	temp2[4] = topCCW(temp);
    	temp2[5] = leftCCW(temp);
    	temp2[6] = bottomCCW(temp);
    	temp2[7] = rightCCW(temp);
    	updatedList.put(keys.get(i), temp2);
    }
    
    
    long product = 1;
    for(int x = 0; x <keys.size(); x++)
    {
    	int count = 0;
    	
    	String[] a = updatedList.get(keys.get(x));
    	for(int y = 0; y<keys.size();y++)
    	{
    		String[] b = updatedList.get(keys.get(y));
    		if(x!=y)
    		{
    			for(int z = 0; z< a.length; z++)
        		{
        			for(int w = 0; w<b.length; w++)
        			{
        				if(a[z].equals(b[w]))
        					count++;
        			}
        		}
    		}
    		
    	}
    	if(count == 4)
    	{
    		System.out.println(keys.get(x));
    		product*=(long)keys.get(x);
    	}
    }
    System.out.println(product);
    
    
    
    
  }
  
  public static String topCW(char[][] temp)
  {
	  String a = "";
	  for(int i = 0; i <10; i++)
	  {
		  a+= temp[0][i];
	  }
	  return a;
  }
  
  public static String topCCW(char[][] temp)
  {
	  String a = "";
	  for(int i = 9; i >=0; i--)
	  {
		  a+= temp[0][i];
	  }
	  return a;
  }
  
  public static String bottomCCW(char[][] temp)
  {
	  String a = "";
	  for(int i = 0; i <10; i++)
	  {
		  a+= temp[9][i];
	  }
	  return a;
  }
  
  public static String bottomCW(char[][] temp)
  {
	  String a = "";
	  for(int i = 9; i >=0; i--)
	  {
		  a+= temp[9][i];
	  }
	  return a;
  }
  
  public static String leftCCW(char[][] temp)
  {
	  String a = "";
	  for(int i = 0; i <10 ; i++)
	  {
		  a+= temp[i][0];
	  }
	  return a;
  }
  
  public static String leftCW(char[][] temp)
  {
	  String a = "";
	  for(int i = 9; i >=0 ; i--)
	  {
		  a+= temp[i][0];
	  }
	  return a;
  }
  
  public static String rightCW(char[][] temp)
  {
	  String a = "";
	  for(int i = 0; i <10 ; i++)
	  {
		  a+= temp[i][9];
	  }
	  return a;
  }
  
  public static String rightCCW(char[][] temp)
  {
	  String a = "";
	  for(int i = 9; i >=0 ; i--)
	  {
		  a+= temp[i][9];
	  }
	  return a;
  }
  
  
  
}