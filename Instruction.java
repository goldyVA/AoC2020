
public class Instruction 
{
	String operation;
	int argument;
	boolean hasBeenExecuted;
	
	public Instruction(String a, int b)
	{
		operation = a;
		argument = b;
		hasBeenExecuted = false;
	}
	
	public String getOperation()
	{
		return operation;
	}
	
	public int getArgument()
	{
		return argument;
	}
	
	public void execute()
	{
		hasBeenExecuted = true;
	}
	
	public boolean hasBeenExecuted()
	{
		return hasBeenExecuted;
	}
	
	public void changeOperation()
	{
		if(operation.equals("nop"))
			operation = "jmp";
		else if(operation.equals("jmp"))
			operation = "nop";
	}
	
	public String toString()
	{
		return operation + " " + argument + " " + hasBeenExecuted;
	}

}
