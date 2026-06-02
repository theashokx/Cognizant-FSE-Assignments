import java.util.*;
class Calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first Number");
        double num1=sc.nextDouble();
        System.out.println("Enter the second Number");
        double num2=sc.nextDouble();
        System.out.println("Enter the operator (+,-,/,*)");
        char ch=sc.next().charAt(0);
        double result=0;
        switch(ch)
        {
            case '+':result=num1+num2;
                    break;
            case '-':result=num1-num2;
                    break;
            case '*':result=num1*num2;
                    break;
            case '/':if(num2==0)
                    {
                        result=Integer.MAX_VALUE;
                    }
                    result=num1/num2;
            default:System.out.println("Invalid operator Input");
                    return;
        }
        System.out.println("Result "+result);

    }
}