import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author deepanker
 * n!mod p where n-p is small
 *
 */
class NFMOD
{
	public static long  exptBySquaring(long p, long q,long m)//p^q mod m
	{
	    long r=1;

	    while (q != 0) 
	    {
	        if (q % 2 == 1) 
	        {    // q is odd
	            r = (r*p)%m;
	            q--;
	        }
	        p = (p*p)%m;
	        q /= 2;
	    }
	    return r;
	}
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(in.readLine());
		while(t-->0)
		{
			String s[]=in.readLine().split(" ");
			long n=Long.parseLong(s[0]);
			long p=Long.parseLong(s[1]);
			long ans=1;
			if(n>=p)
			{
				ans=0;
			}
			else
			{
				for(long i=n+1;i<p;i++)
				{
					ans=(ans*i)%p;
				}
				ans=exptBySquaring(ans, p-2, p); //2^3 mod 5
				ans=(ans*(p-1))%p; 
				//ans^p-2 mod p *p-1 mod p
			}
			System.out.println(ans);
		}
	}

}