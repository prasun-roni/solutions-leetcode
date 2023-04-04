//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = nums[0];

        for(int num : nums)
            max = Math.max(max, num);

        while(min <= max){

            int mid = min + (max-min)/2;

            if(divisors(nums, mid) <= threshold)
                max = mid-1;
            else
                min = mid+1;
        }

        return min;
    }

    static int divisors(int[] nums, int i){

        int ans = 0;

        for(int num : nums){
            ans += num/i;
            if(num%i != 0)
                ans++;
        }

        return ans;
    }
}