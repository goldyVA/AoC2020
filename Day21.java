import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day21 
{
  public static void main(String[] args) 
  {
    ArrayList<Food> list = new ArrayList<Food>();
    ArrayList<String> allergens = new ArrayList<String>();
    ArrayList<String> ingredients = new ArrayList<String>();
    ArrayList<String> ingredientsWithAllergens = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day21.txt"));
    	while(scan.hasNextLine())
    	{
    		ArrayList<String> ing = new ArrayList<String>();
    		ArrayList<String> all = new ArrayList<String>();
    		String x = scan.nextLine();
    		String[] split = x.split(" |, ");
    		split[split.length-1] = split[split.length-1].substring(0,split[split.length-1].length()-1);
    		int separate = -1;
    		for(int i = 0; i< split.length; i++)
    		{
    			if(split[i].equals("(contains"))
    				separate = i;
    		}
    		for(int i = 0; i< separate; i++)
    		{
    			ing.add(split[i]);
    		}
    		for(int i = separate+1; i< split.length; i++)
    		{
    			all.add(split[i]);
    		}
    		
    		list.add(new Food(ing, all));
    	}
    }
    catch(Exception e) 
    {	
    }
    
    //compiles a list of all ingredients and allergens
    for(Food x: list)
    {
    	ArrayList<String> temp = x.getIngredients();
    	for(String y: temp)
    	{
    		if(!ingredients.contains(y))
    			ingredients.add(y);
    	}
    	
    	ArrayList<String> temp2 = x.getAllergens();
    	for(String y: temp2)
    	{
    		if(!allergens.contains(y))
    			allergens.add(y);
    	}
    }
    
    //figures out which allergen goes with which ingredients
    for(String check: allergens)
    {
    	System.out.print(check + " could be      ");
    	ArrayList<String> ingredientList = new ArrayList<String>();
    	for(Food x: list)
    	{
    		if(x.getAllergens().contains(check))
    		{
    			ArrayList<String> add = x.getIngredients();
    			//System.out.println(add.size());
    			for(String y: add)
    				ingredientList.add(y);
    		}
    	}
    	
    	String[] ing = new String[ingredients.size()];
    	for(int i = 0; i<ing.length;i++)
    	{
    		ing[i] = ingredients.get(i);
    	}
    	int[] count = new int[ing.length];
    	for(int i = 0; i<ing.length;i++)
    	{
    		String test = ing[i];
    		int counter = 0;
    		for(String a: ingredientList)
    		{
    			if(a.equals(test))
    				counter++;
    		}
    		count[i] = counter;
    	}
    	
    	int maxValue = 0;
    	for(int x: count)
    	{
    		if(x>maxValue)
    			maxValue = x;
    	}
    	for(int i = 0; i<ing.length; i++)
    	{
    		if(count[i] == maxValue)
    		{
    			System.out.print(ing[i] + " ");
    			if(!ingredientsWithAllergens.contains(ing[i]))
    				ingredientsWithAllergens.add(ing[i]);
    		}
    	}
    	System.out.println();
    }
    
    System.out.println();
    int total = 0;
    for(Food x : list)
    {
    	ArrayList<String> temp = x.getIngredients();
    	for(String y: temp)
    	{
    		if(!ingredientsWithAllergens.contains(y))
    			total++;
    			
    	}
    }
    System.out.println(total);
    
  }
}