import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day11Part1 
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day11.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextLine());
    	}
    }
    catch(Exception e) 
    {	
    }
    //set up the 2d array
    char[][] seats = new char[list.size()+2][list.get(0).length()+2];
    for(int i = 1; i < seats.length-1; i++)
    {
    	String x = list.get(i-1);
    	String[] split = x.split("");
    	for(int j = 1; j< seats[0].length-1; j++)
    	{
    		seats[i][j] = split[j-1].charAt(0);
    	}
    }
    for(int i = 0; i < seats.length; i++)
    {
    	for(int j = 0; j< seats[0].length; j++)
    	{
    		if(i==0 || j==0 || i==seats.length-1 || j==seats[0].length-1)
    			seats[i][j]='z';
    	}
    }
    
    //check seats
    boolean done = false;
    while(!done)
    {
    	boolean change = false;
    	char[][] copy = new char[seats.length][seats[0].length];
        
        for(int i = 1; i < seats.length-1; i++)
        {
        	for(int j = 1; j< seats[0].length-1; j++)
        	{
        		copy[i][j] = seats[i][j];
        	}
        }
       
        for(int i = 1; i < seats.length-1; i++)
        {
        	for(int j = 1; j< seats[0].length-1; j++)
        	{
        		if(copy[i][j] != '.')
        		{
        			char ul = copy[i-1][j-1];
            		char u = copy[i-1][j];
            		char ur = copy[i-1][j+1];
            		char r = copy[i][j+1];
            		char dr = copy[i+1][j+1];
            		char d = copy[i+1][j];
            		char dl = copy[i+1][j-1];
            		char l = copy[i][j-1];
            		
            		char[] adj = {ul, u, ur, r, dr, d, dl, l};
            		
            		int people = 0;
            		for(char x: adj)
            		{
            			if(x == '#')
            				people++;
            		}
            		
            		if(copy[i][j]=='#' && people >=4)
            		{
            			seats[i][j] = 'L';
            			change = true;
            		}
            		else if(copy[i][j]=='L' && people ==0)
            		{
            			seats[i][j] = '#';
            			change = true;
            		}            	            		
        		}        		
        	}
        }     
        if(!change)
        	done = true;
    }
    
    //count seats
    int occupied = 0;
    for(int i = 0; i < seats.length; i++)
    {
    	for(int j = 0; j< seats[0].length; j++)
    	{
    		if(seats[i][j]=='#')
    			occupied++;
    	}
    } 
    System.out.println(occupied);

  }
}