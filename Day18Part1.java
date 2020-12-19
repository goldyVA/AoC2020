import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day18Part1
{

	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		try 
	    {
	    	Scanner scan = new Scanner(new File("day18.txt"));
	    	while(scan.hasNextLine())
	    	{
	    		list.add(scan.nextLine());
	    	}
	    }
	    catch(Exception e) 
	    {	
	    }
		
		long sum = 0;
		for(String x: list)
		{
			sum+=Long.parseLong(solve(x));
		}
		System.out.println(sum);
		
	}
	
	public static String solve(String x)
	{
		if(countParentheses(x) == 0)
			return evaluate(x)+"";
		else if(countParentheses(x) == 1)
		{
			int indexOfOpen = x.indexOf('(');
			int indexOfClosed = x.indexOf(')');
			String temp = x.substring(indexOfOpen+1,indexOfClosed);
			long evaluate = evaluate(temp);
			return solve(x.substring(0,indexOfOpen) + evaluate + x.substring(indexOfClosed+1));
		}
		else
		{
			int indexOfOpen = x.indexOf('(');
			int indexOfClosed = x.indexOf(')');
			int indexOfNextOpen = x.indexOf("(", x.indexOf("(") + 1);
			
			if(indexOfClosed < indexOfNextOpen)
			{
				String temp = x.substring(indexOfOpen+1,indexOfClosed);
				long evaluate = evaluate(temp);
				return solve(x.substring(0,indexOfOpen) + evaluate + x.substring(indexOfClosed+1));
			}
			else
			{
				String temp = x.substring(indexOfNextOpen+1,indexOfClosed);
				long evaluate = evaluate(temp);
				return solve(x.substring(0,indexOfNextOpen) + evaluate + x.substring(indexOfClosed+1));
			}
		
		}

	}
	
	
	public static long evaluate(String x)
	{
		x=x+" ";
		long total = 0;
		while(x.contains("+") || x.contains("*"))
		{
			int indexOfPlus = x.indexOf("+");
			int indexOfTimes = x.indexOf("*");
			if(indexOfPlus == -1)
			{
				long num1 = Long.parseLong(x.substring(0,x.indexOf(" ")));
				x=x.substring(x.indexOf("*")+2);
				long num2 = Long.parseLong(x.substring(0,x.indexOf(" ")));
				x = x.substring(x.indexOf(" ") + 1);
				total = num1*num2;
				x=total+" " + x;
			}
			else if(indexOfTimes == -1)
			{
				long num1 = Long.parseLong(x.substring(0,x.indexOf(" ")));
				x=x.substring(x.indexOf("+")+2);
				long num2 = Long.parseLong(x.substring(0,x.indexOf(" ")));
				x = x.substring(x.indexOf(" ") + 1);
				total = num1+num2;
				x=total+" " + x;
			}
			else
			{
				if(x.indexOf("+")<x.indexOf("*"))
				{
					long num1 = Long.parseLong(x.substring(0,x.indexOf(" ")));
					x=x.substring(x.indexOf("+")+2);
					long num2 = Long.parseLong(x.substring(0,x.indexOf(" ")));
					x = x.substring(x.indexOf(" ") + 1);
					total = num1+num2;
					x=total+" " + x;
				}
				else
				{
					long num1 = Long.parseLong(x.substring(0,x.indexOf(" ")));
					x=x.substring(x.indexOf("*")+2);
					long num2 = Long.parseLong(x.substring(0,x.indexOf(" ")));
					x = x.substring(x.indexOf(" ") + 1);
					total = num1*num2;
					x=total+" " + x;
				}
			}
		}
		return total;
	}
	
	
	public static int countParentheses(String x)
	{
		int count = 0;
		for(int i = 0; i<x.length();i++)
		{
			if(x.charAt(i) == '(')
				count++;
		}
		return count;
	}
}
