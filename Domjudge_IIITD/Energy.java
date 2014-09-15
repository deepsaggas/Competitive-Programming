import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;



public class Energy{
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";

	static long fact[] = new long[1000010];
	static long mod = 1000000007;
	public static void solveTestCase(int n,int k)
	{
		long denom = (((((((n*fact[k])%mod)*fact[n-k])%mod)*fact[k-1])%mod)*fact[n+1-k])%mod;
		//long denom = (((n*fact[k])%mod)*((fact[n-k]*fact[k-1])%mod)*fact[n-k+1])%mod;
		long denominv = Long.parseLong((new BigInteger(denom+"").modInverse(new BigInteger(mod+""))).toString());
		long num = (fact[n]*fact[n])%mod;
		long ans=(num*denominv)%mod;
		out.println(ans);
		//long ans = (1/n)*(fact[n]/fact[k]*fact[n-k])*fact[n]/fact[k-1]*fact[n-k+1];
		
	}
	public static void solve()
	{
		fact[0]=1;
		for(int i=1;i<fact.length;i++)
		{
			fact[i]=(i*fact[i-1])%mod;
		}
		int t=ni();
		while(t-->0)
		{
			int n=ni();
			int k=ni();
			if(k==0)
				out.println(0);
			else
				solveTestCase(n,k);
		}

	}
	public static void main(String[] args) throws Exception
	{
		long S = System.currentTimeMillis();
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		//is=new FileInputStream(new File("HLPNITIKAin.txt"));
		//out=new PrintWriter(new File("HLPNITIKAout.txt"));
		//is=new FileInputStream(new File("LIGHTS2Largein.txt"));
		//out=new PrintWriter(new File("LIGHTS2Largeout.txt"));

		solve();
		out.flush();
		out.close();
		long G = System.currentTimeMillis();
		tr(G-S+"ms");
	}

	private static boolean eof()
	{
		if(lenbuf == -1)return true;
		int lptr = ptrbuf;
		while(lptr < lenbuf)if(!isSpaceChar(inbuf[lptr++]))return false;

		try {
			is.mark(1000);
			while(true){
				int b = is.read();
				if(b == -1 || b=='\n'){
					is.reset();
					return true;
				}else if(!isSpaceChar(b)){
					is.reset();
					return false;
				}
			}
		} catch (IOException e) {
			return true;
		}
	}

	private static byte[] inbuf = new byte[1024];
	static int lenbuf = 0, ptrbuf = 0;

	private static int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}

	private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private static int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

	private static double nd() { return Double.parseDouble(ns()); }
	private static char nc() { return (char)skip(); }

	private static String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private static char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	private static char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}

	private static int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	private static long[] nal(int n)
	{
		long[] a = new long[n];
		for(int i = 0;i < n;i++)a[i] = nl();
		return a;
	}
	private static int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}

		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private static long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}

		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	/*low,high,e
	 if(arr[mid]<e) low=mid;
	 else high = mid;
	 if(arr[high]<e) return high;
	 if(arr[low]<e) return low; return -1;
	 */
	private static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }
}
