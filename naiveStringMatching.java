import java.util.Scanner;

public class naiveStringMatching{

	String text = "";
	String pattern = "";
	int tLen,pLen,count=0;


	void inputData()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter Text String: ");
		text = sc.next();
		System.out.print("Enter Pattern String: ");
		pattern = sc.next();

		tLen = text.length();
		pLen = pattern.length();
	}

	void searchForMatch()
	{
		for(int i=0 ; i<=(tLen-pLen) ; i++)
		{
			//Declare outside for block because required after for block to check 
			int j;
			for(j=0;j<pLen;j++)
			{
				if(text.charAt(i+j) != pattern.charAt(j))
					break;
			}
			//If all characters of the pattern found a match
			if(j == pLen)
				{
					System.out.printf("\nPattern found at index %d",i);
					count++;
				}
		}
		//Message if no match found
		if(count == 0)
			System.out.println("NO MATCH FOUND");
	}

	public static void main(String args[])
	{
		naiveStringMatching obj = new naiveStringMatching();

		obj.inputData();
		obj.searchForMatch();
	}
	
}