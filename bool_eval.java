import java.util.Scanner;

public class bool_eval {
	public static boolean boolex_eval(String s)
	{
		boolean a=true, b=true, a_val=false, b_val=false;
		int op=1, n = s.length();
		for (int i = 0; i<n; i++)
		{
			if(s.charAt(i) == 'T' || s.charAt(i) == 'F')
			{
				if(a_val == false)
				{
					a = s.charAt(i)=='T'?true:false;
					a_val = true;

				}
				else if(b_val == false)
				{
					b = s.charAt(i)=='T'?true:false;
					b_val = true;
				}
			}
			else if(s.charAt(i)=='O' || s.charAt(i)=='A')
			{
				op = s.charAt(i)=='O'?1:2;
			}
			else if(s.charAt(i)=='(' && i!=0)
			{
				b = boolex_eval(s.substring(i+1));
				b_val = true;
			}
			if(a_val == true && b_val == true) 
			{
				a = (op==1)?a||b:a&&b;
				a_val = b_val = false;
			}
			
		}
		return a;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		boolean ans = boolex_eval(str);
		System.out.println(ans);
	}
}
