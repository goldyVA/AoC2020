import java.util.ArrayList;

public class Food 
{
	private ArrayList<String> ingredients;
	private ArrayList<String> allergens;
	
	public Food(ArrayList<String> i, ArrayList<String> a)
	{
		ingredients = i;
		allergens = a;
	}
	
	public ArrayList<String> getIngredients()
	{
		return ingredients;
	}
	
	public ArrayList<String> getAllergens()
	{
		return allergens;
	}
	
	
}
