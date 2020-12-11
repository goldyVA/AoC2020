import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day11Part2
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
    			seats[i][j]=' ';
    	}
    }
    
    //check seats
    boolean finished = false;
    while(!finished)
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
        			boolean done = false;
        			int I = i;
        			int J = j;
        			
        			char ul = ' ';
        			done=false;
        			I=i-1;
        			J=j-1;
        			while(!done && I>=0 & J>=0)
        			{
        				if(copy[I][J]=='#')
    					{
    						ul='#';
    						I--;
    						J--;
    						done=true;
    					}
    					else if(copy[I][J]=='L')
    					{
    						ul='L';
    						I--;
    						J--;
    						done=true;
    					}
    					else
    					{
    						I--;
    						J--;
    					}
        			}
        			
            		char u = ' ';
            		done=false;
        			I=i-1;
        			J=j;
        			while(!done && I>=0)
        			{
        				if(copy[I][J]=='#')
    					{
    						u='#';
    						I--;
    						done=true;
    					}
    					else if(copy[I][J]=='L')
    					{
    						u='L';
    						I--;
    						done=true;
    					}
    					else
    					{
    						I--;
    					}
        			}
            		
            		char ur = ' ';
            		done=false;
        			I=i-1;
        			J=j+1;
        			while(!done && I>=0 & J<copy[0].length)
        			{
        				if(copy[I][J]=='#')
    					{
    						ur='#';
    						I--;
    						J++;
    						done=true;
    					}
    					else if(copy[I][J]=='L')
    					{
    						ur='L';
    						I--;
    						J++;
    						done=true;
    					}
    					else
    					{
    						I--;
    						J++;
    					}
        			}
       		
            		char right = ' ';
            		done=false;
        			I=i;
        			J=j+1;
        			while(!done && J<copy[0].length)
        			{
        				if(copy[I][J]=='#')
    					{
    						right='#';
    						J++;
    						done=true;
    					}
    					else if(copy[I][J]=='L')
    					{
    						right='L';
    						J++;
    						done=true;
    					}
    					else
    					{
    						J++;
    					}
        			}

            		char dr = ' ';
            		done=false;
        			I=i+1;
        			J=j+1;
        			while(!done && I<copy.length & J<copy[0].length)
        			{
        				if(copy[I][J]=='#')
    					{
        					dr='#';
    						I++;
    						J++;
    						done=true;
    					}
    					else if(copy[I][J]=='L')
    					{
    						dr='L';
    						I++;
    						J++;
    						done=true;
    					}
    					else
    					{
    						I++;
    						J++;
    					}
        			}
            		
            		char d = ' ';
            		done=false;
        			I=i+1;
        			J=j;
        			while(!done && I<copy.length)
        			{
        				if(copy[I][J]=='#')
    					{
    						d='#';
    						I++;
    						done=true;
    					}
    					else if(copy[I][J]=='L')
    					{
    						d='L';
    						I++;
    						done=true;
    					}
    					else
    					{
    						I++;
    					}
        			}
		
            		char dl = ' ';
            		done=false;
        			I=i+1;
        			J=j-1;
        			while(!done && I<copy.length & J>=0)
        			{
        				if(copy[I][J]=='#')
    					{
    						dl='#';
    						I++;
    						J--;
    						done=true;
    					}
    					else if(copy[I][J]=='L')
    					{
    						dl='L';
    						I++;
    						J--;
    						done=true;
    					}
    					else
    					{
    						I++;
    						J--;
    					}
        			}
            		
            		char l = ' ';
            		done=false;
        			I=i;
        			J=j-1;
        			while(!done && J>=0)
        			{
        				if(copy[I][J]=='#')
    					{
    						l='#';
    						J--;
    						done=true;
    					}
    					else if(copy[I][J]=='L')
    					{
    						l='L';
    						J--;
    						done=true;
    					}
    					else
    					{
    						J--;
    					}
        			}
    		
            		char[] adj = {ul, u, ur, right, dr, d, dl, l};
            		
            		int people = 0;
            		for(char x: adj)
            		{
            			if(x == '#')
            				people++;
            		}
            		
            		if(copy[i][j]=='#' && people >=5)
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
        	finished = true;   
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