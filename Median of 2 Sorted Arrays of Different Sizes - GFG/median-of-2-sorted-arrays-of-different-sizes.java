//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n1, int n2, int nums1[], int nums2[]) 
    {
        // Your Code Here
        if(nums1.length > nums2.length)
            return medianOfArrays(n2, n1, nums2, nums1);//.  okay

        int low = 0, high = n1;

        while(low <= high){

            int cut1 = (low+high)/2;
            int cut2 = (n1+n2+1)/2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1-1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];

            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2-1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 <= r2 && l2 <= r1){
                if((n1+n2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                else
                    return Math.max(l1, l2);
            }
            else if(l1 > r2)
                high = cut1-1;
            else
                low = cut1+1;
        }

        return 0.0;
    }
}