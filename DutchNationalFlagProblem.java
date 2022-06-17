class Solution {
    public void sortColors(int[] nums) {
        int z=0,o=0,t=0,i,j,k;
        int n=nums.length;
        int[] s = new int[n];
        for(i=0;i<nums.length;i++)
        {
            if(nums[i] == 0)
                z=z+1;
            else if(nums[i]==1)
                o=o+1;
            else
                t=t+1;
            
        }
        for( i=0;i<z;i++) {
            s[i] = 0;

        }
        for(j=i;j<z+o;j++) {
            s[j] = 1;

        }
        for(k=j;k<z+o+t;k++) {
            s[k] = 2;
        }
        for( i=0;i<s.length;i++) {
        System.out.print(s[i]);
        }
    }
}
