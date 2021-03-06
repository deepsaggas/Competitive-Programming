import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;



public class Lights2{
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";


	public static void solveTestCase(int n, int x)//;, int c, int d)
    {
        HashMap<String,Integer> an;
        HashMap<Integer,String> anrev;
//        while(t-->0)
        {
  //          int n=ni();//reads integer
  //          int x=ni();//reads integer
            an= new HashMap<String,Integer>();
            anrev= new HashMap<Integer,String>();

            String u=ns(); // reads string
            char s[]=u.toCharArray();
            an.put(u,0);
            anrev.put(0,u);
            for(int i=1;i<=x;i++)
            {
                char ans[]=new char[s.length];
                ans[0]=s[1];
                ans[n-1]=s[n-2];
                for(int j=1;j<n-1;j++)
                {
                    ans[j]=s[j-1]=='G' && s[j+1]=='G'?'G':'O';
                }
                s=ans;
                String ansu=new String(ans);
                Integer v=an.get(ansu);
                if(v!=null)
                {
                    if(v==i-1)
                    {
                        break;
                    }
                    else if(v==i-2)
                    {
                        int y=x-v;
                        if(y%2==0)
                        {
                            break;
                        }
                        else
                        {
                            s=anrev.get(v+1).toCharArray();
                            break;
                        }
                    }
                }
                an.put(ansu, i);
                anrev.put(i,ansu);
            }
       
            out.println(new String(s));
        }
    }
	public static void solve()
	{
		int t=ni();
		while(t-->0)
		{
			int n=ni();
			int x=ni();
			solveTestCase(n,x);
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
