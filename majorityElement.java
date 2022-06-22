public class ME{
    public static void main(String[] args) {
        int a[] = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
        int n = a.length;
        majorityElement(a, n);
    }
    public static void majorityElement(int a[], int n)
    {
        int i,max=0,p=-1;
        int t[] = new int[n];
        int c[] = new int[n];
        for(i=0;i<n;i++)
            t[i] = 0;
        for (i = 0; i < n; i++) {
            if (t[i] != 0)
                continue;
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    count++;
                    t[j] = 1;

                }
            if (count > max) {
                max = count;
                p = i;
                }
            } 
        }
         if (max > n / 2)
            System.out.println(a[p]);
        else
            System.out.println("No Majority Element");
    }
}
