import java.util.*;

class Factorial
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number to find the factorial");
        int num=sc.nextInt();
        int result=1;
        for(int i=01;i<=num;i++)
        {
            result*=i;
        }
        System.out.println("Factorial : "+result);
    }
}
