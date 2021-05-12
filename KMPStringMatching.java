import java.util.Scanner;

public class KMPStringMatching{
	String text = "";
	String pattern = "";
	int tLen,pLen,count=0; //textLength, patternLength, numOfMatches
	int[] lps; //LONGEST PREFIX SUFFIX

	void inputData()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter Text String: ");
		text = sc.next();
		System.out.print("Enter Pattern String: ");
		pattern = sc.next();

		tLen = text.length();
		pLen = pattern.length();
		lps = new int[pLen];
	}

	void lpsArray()
	{
		lps[0] = 0; //LPS[0] ID ALWAYS 0
		int i=1; //to index through pattern from 1 to pLen-1
		int len=0;
		while(i<pLen)
		{
			if(pattern.charAt(len) == pattern.charAt(i))
			{
				len++;
				lps[i] = len;
				i++;
			}
			else
			{
				if(len != 0)
				{
					len = lps[len-1];
				}
				else
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}

	void kmpSearch()
	{
		int i=0;//index for text
		int j=0;//index for pattern

		while(i<tLen)
		{
			if(pattern.charAt(j) == text.charAt(i))
			{
				i++;
				j++;
			}
			//If the patern match is found (0 to pLen-1 matched), print answer
			if(j==pLen)
			{
				System.out.printf("\nPattern found at index %d",i-j);
				count++;
				//IMPORTANT STEP
				j = lps[j-1];
			}
			//If encountered a mismatch
			if(i<tLen && pattern.charAt(j) != text.charAt(i))
			{
				if(j != 0)
				{
					j = lps[j-1];
				}
				else
				{
					i++;
				}
			}
		}
		if(count==0)
		{
			System.out.println("NO MATCH FOUND");
		}
	}

	public static void main(String args[])
	{
		KMPStringMatching obj = new KMPStringMatching();
		obj.inputData();
		obj.lpsArray();
		obj.kmpSearch();
	}
}