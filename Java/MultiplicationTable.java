import java.util.*;
class MultiplicationTable
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int num=sc.nextInt();
        System.out.println("Multiplication table - "+num);
        for(int i=1;i<=10;i++)
        {
            System.out.println(num+" * "+i+" = "+num*i);
        }
    }
}