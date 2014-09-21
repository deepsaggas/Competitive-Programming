import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author deepanker
 *
 */

public class Magicn
{

	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(in.readLine());
		while(t-->0)
		{
			String s[]=in.readLine().split(" ");
			char s1[]=s[0].toCharArray();
			//Arrays.sort(s1);
			char s2[]=s[1].toCharArray();
			//Arrays.sort(s2);
			int count1[]=new int[10];
			int count2[]=new int[10];
			int count[]=new int[256];
			for(int i=0;i<s1.length;i++)
			{
				count1[s1[i]-'0']++;
			}
			for(int i=0;i<s2.length;i++)
			{
				count2[s2[i]-'0']++;
			}
			int ctr=0;
			for(int i=0;i<10;i++)
			{
				count[i]=Math.min(count1[i], count2[i]);
				ctr+=count[i];
			}
			char ans[]=new char[ctr];
			int k=0;
			for(int i=9;i>=0;i--)
			{
				while(count[i]-->0)
				{
					ans[k]=(char) (i+'0');
					k++;
				}
			}
			System.out.println(new String(ans));
		}
	}
}