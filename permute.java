public class permute {
	public static int num = 0;
	public String[] s;
	public permute(int n)
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
		int n = str.length();
		n = fact(n);
		permute a = new permute(n);		
		a.permutation(str,0,str.length()-1);
		//Sorting the strings using bubble sort...
		String t = new String(); //Temporary string for swapping
		for(int i=0; i<a.s.length; i++)
		{
			for(int j=i+1; j<a.s.length; j++)
			{
				if(a.s[i].compareTo(a.s[j]) > 0)
				{
					t = a.s[i];
					a.s[i] = a.s[j];
					a.s[j] = t;
				}
			}
		}
			
		//Printing the distinct strings after sorting...    
	    for(int i=0;i<a.s.length;i++)
	    {
	        boolean isDistinct = true;
	        for(int j=0;j<i;j++)
	        {
	            if(a.s[i].compareTo(a.s[j]) == 0)
	            {
	                isDistinct = false;
	                break;
	            }
	        }
	        if(isDistinct)
	        {
	            System.out.println(a.s[i]);
	        }
	    }	
	}
}
