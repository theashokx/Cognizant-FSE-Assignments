import java.util.*;
class GradeCalculator
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the marks of student");
        int marks=sc.nextInt();
        if(marks>92)
        {
            System.out.println("S");
        }
        else if(marks>84)
        {
            System.out.println("A+");
        }
        else if(marks>65)
        {
            System.out.println("A");
        }
        else if(marks>54)
        {
            System.out.println("B+");
        }
        else if(marks>44)
        {
            System.out.println("B");
        }
        else if(marks>36)
        {
            System.out.println("P");
        }
        else
        {
            System.out.println("F");
        }
    }
}