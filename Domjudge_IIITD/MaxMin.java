import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.SortedSet;
import java.util.TreeSet;


public class MaxMin{
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";


	public static long solveTestCase(int m, int n, int[] a, int[] b)
	{
		if(a[0]>=b[n-1])
		{
			return 0;
		}
		int curA=a[0];
		int posA=0;
		int curB=b[n-1];
		int posB=n-1;
		long costA=1;
		long costB=1;
		long ans=0;
		while(curA!=curB)
		{
			//only A increases
			//only B decreases
			if(costA<costB && posA<=m-2)
			{
				if(curB>a[posA+1])
				{
					int i=posA+2;
					for(;i<m;i++)
					{
						if(a[i-1]!=a[i])
							break;
					}
					ans=ans+(costA*(a[posA+1]-curA));
					posA=i-1;
					costA=i;
					curA=a[posA];
				}
				else
				{
					ans=ans+(costA*(curB-curA));
					break;
				}
			}
			else if(costA>=costB && posB>=1)
			{
				if(curA<b[posB-1])
				{
					int i=posB-2;
					for(;i>=0;i--)
					{
						if(b[i+1]!=b[i])
							break;
					}
					ans=ans+(costB*(curB - b[posB-1]));
					posB=i+1;
					costB=n-i-1;
					curB=b[posB];
				}
				else
				{
					ans=ans+(costB*(curB-curA));
					break;
				}
			}
			else
			{
				if(costA<costB)
				{
					ans=ans+(costA*(curB-curA));
					break;
				}
				else
				{
					ans=ans+(costB*(curB-curA));
					break;
				}
			}
		}
		return ans;
	}
	public static void solve() throws Exception
	{
		int t=ni();
		while(t-->0)
		{
			int m=ni();
			int n=ni();
			int []a=na(m);
			int []b=na(n);
			Arrays.sort(a);
			Arrays.sort(b);
			out.println(solveTestCase(m, n ,a, b));
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
