import java.util.*;
class ArraySumAverage
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of elements");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of Array");
        int sum=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        float avg=sum/n;
        System.out.println("Sum : "+sum+" -- "+"Average : "+avg);

    }
}