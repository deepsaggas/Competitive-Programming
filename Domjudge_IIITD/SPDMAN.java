import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SPDMAN {

	static void solve() throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String s1=in.readLine();
		int t=Integer.parseInt(s1);
		while(t-->0)
		{
			String s[]=in.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
			int k=Integer.parseInt(s[2]);
			int ans=0;
			if(m>=n)
				ans=1;
			else if(k>=m)
				ans=-1;
			else
			{
				ans=(n-m)/(m-k);
				if((n-m)%(m-k)!=0)
					ans++;
				ans++;
			}
			System.out.println(ans);
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		solve();
	}
}