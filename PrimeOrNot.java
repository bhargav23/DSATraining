import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* Enter number of inputs */
        int n = scanner.nextInt();
        for(int i=1;i<=n;i++){
            int c=0;
            /* Enter the inputs */
            int x = scanner.nextInt();
            if(x==1) c++;
            for(int j=2;j<=Math.sqrt(x);j++){

                
                if(x%j==0) {
                    c++;
                    break;
                }
            }
            if (c == 0)
                System.out.println("Prime");  
            else
                System.out.println("Not prime"); 
        }
        scanner.close();
    }
}
