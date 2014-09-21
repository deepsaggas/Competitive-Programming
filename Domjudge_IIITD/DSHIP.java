import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DSHIP 
{
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(in.readLine());
		int count[];
		while(t-->0)
		{
			count=new int[26];
			char[] s1=in.readLine().toCharArray();
			char[] s2=in.readLine().toCharArray();
			boolean flag=false;
			for(int i=0;i<s1.length;i++)
			{
				count[s1[i]-'a']++;
			}
			for(int i=0;i<s2.length;i++)
			{
				count[s2[i]-'a']--;
			}
			for(int i=0;i<26;i++)
			{
				if(count[i]!=0)
				{
					flag=true;
					break;
				}
			}
			if(flag)
			{
				System.out.println("Yes");
			}
			else
			{
				System.out.println("No");
			}
		}
	}

}
