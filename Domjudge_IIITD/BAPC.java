import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * 
 * @author deepanker
 *
 */

public class BAPC
{
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(in.readLine());
		while(t-->0)
		{
			String s[]=in.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int k=Integer.parseInt(s[1]);
			int f=0;
			int l=(int) Math.sqrt(k);
			if(l*l==k || (l+1)*(l+1)==k)
				f=1;
			if((n-f)%2==0)
			{
				System.out.println("off");
			}
			else
			{
				System.out.println("on");
			}
		}
		
	}
}