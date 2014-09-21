import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class CHOC2
{
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";
	

	static void solve()
	{
		int t = ni();
		while(t-->0)
		{
			int n=ni();
			long k=nl();
			long a[]=new long[n];
			long ans=0;
			for(int i=0;i<n;i++)
			{
				a[i]=nl();
				ans=(ans+(a[i]%k))%1000000009L;
			}
			ans=ans%(1000000009L);
			out.println(ans);
		}
	}
	
	
	
	/** @return the greatest common denominator */
	public static long gcm(long a, long b) {
	    return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
	}

	public static String asFraction(long a, long b) {
	    long gcm = gcm(a, b);
	    return (a / gcm) + "/" + (b / gcm);
	}
	
	

	public static void main(String[] args) throws Exception
	{
		long S = System.currentTimeMillis();
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		//is=new FileInputStream(new File("CRYPTOin.txt"));
		//out=new PrintWriter(new File("CRYPTOout.txt"));
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


	private static int findmaxrect(int[][] matrix, int m, int n)
	{
		int[][] RowCount = new int[m][n];
		for(int i=0; i<n; i++)
		{
			RowCount[0][i] = matrix[0][i];
		}
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				if(matrix[j][i] != 0)
				{
					RowCount[j][i] = RowCount[j-1][i] + matrix[j][i];
				}
				else
				{
					RowCount[j][i] = 0;
				}
			}
		}
		int max, cmax = 0;
		for(int i=0; i<m; i++)
		{
			max = LArea(RowCount[i], n);
			if(max > cmax)
			{
				cmax = max;
			}
		}
		return cmax;
	}


	public static int LArea(int[] row, int ele)
	{
		int[] ar = new int[ele];
		boolean d;
		int n, i, t;
		Stack<Integer> H = new Stack<Integer>();


		for (i=0; i<ele; i++)  
		{  
			while (!H.empty())  
			{  
				if(row[i] <= row[H.peek()])  
				{  
					H.pop();  
				}  
				else  
					break;  
			}  
			if(H.empty())  
				t = -1;  
			else  
				t = H.peek();   
			ar[i] = i - t - 1;  
			H.push(i);
		}  

		while (!H.empty())
		{
			H.pop();
		}

		for (i=ele-1; i>=0; i--)  
		{  
			while (!H.empty())  
			{  
				if(row[i] <= row[H.peek()])  
				{  
					H.pop();
				}  
				else  
					break;  
			}  
			if(H.empty())  
				t = ele;  
			else  
				t = H.peek();    
			ar[i] += t - i -1;  
			H.push(i);  
		}

		int max = 0;    
		for (i=0; i<ele; i++)  
		{  
			ar[i] = row[i] * (ar[i] + 1);  
			if (ar[i] > max)  
				max = ar[i];  
		}  

		return max;
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

	private static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }
}


