
public class permute_alllen {
	public int num = 0;
	public String[] s;
	public permute_alllen(int n)
	{
		s = new String[n];
	}
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
	public String swap(String a, int i, int j)
    {
		char temp;
        char[] charArray = a.toCharArray();
	    temp = charArray[i] ;
	    charArray[i] = charArray[j];
	    charArray[j] = temp;
	    return String.valueOf(charArray);
    } 
    public void permutation(String str, int l, int r)
    {
        if (l == r)
        	s[num++] = str;
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permutation(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
	public static void main(String args[])
	{
		String str = "AACE";
		permute_alllen[] a = new permute_alllen[str.length()];

		for(int k=0; k < str.length(); k++)
		{
			int n = k+1;
			n = fact(n);
			a[k] = new permute_alllen(n);
			a[k].permutation(str.substring(0,k+1),0,k);
			
			//Sorting the strings using bubble sort...
			String t = new String(); //Temporary string for swapping
			for(int i=0; i<a[k].s.length; i++)
			{
				for(int j=i+1; j<a[k].s.length; j++)
				{
					if(a[k].s[i].compareTo(a[k].s[j]) > 0)
					{
						t = a[k].s[i];
						a[k].s[i] = a[k].s[j];
						a[k].s[j] = t;
					}
				}
			}
			
			//Printing the distinct strings after sorting... 
			System.out.println("Strings of length "+(k+1)+" are:");
			for(int i=0;i<a[k].s.length;i++)
			{
				boolean isDistinct = true;
				for(int j=0;j<i;j++)
				{
					if(a[k].s[i].compareTo(a[k].s[j]) == 0)
					{
						isDistinct = false;
						break;
					}
				}
				if(isDistinct)
				{
					System.out.println(a[k].s[i]);
				}	
			}
		}
	}
}
