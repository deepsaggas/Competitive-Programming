import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HLPMHN {

	static void solve() throws IOException
	{
		int N=10000;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
// Find Primes upto 10000 using Sieve of Eratosthenes
		boolean[] isPrime=new boolean[10000];
		Arrays.fill(isPrime,true);
		isPrime[0]=isPrime[1]=false;
		for(int i=2;i<N;i++)
		{
			if(isPrime[i] && i*i<N)
			{
				for(int j=i*i;j<N;j+=i)
				{
					isPrime[j]=false;
				}
			}
		}
//Find product of first k primes
		long[] prod=new long[25];
		prod[0]=1;
		for(int j=2,k=1;j<N && k<25;j++)
		{
			if(isPrime[j])
				{
			//	out.println(k-1+": "+prod[k-1]);
				prod[k]=prod[k-1]*j;
				k++;
				}				
		}
//Answer testCases
		String s1=in.readLine();

		int t=Integer.parseInt(s1);
		while(t-->0)
		{
			s1=in.readLine();
			long n=Long.parseLong(s1);
			int i=0;
			for(i=0;i<25;i++)
			{
				if(prod[i]>n)
					break;
			}
			System.out.println(prod[i-1]);
		}
	}

	public static void main(String[] args) throws Exception
	{
		solve();
	}
}