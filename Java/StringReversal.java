import java.util.*;
class StringReversal
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String s=sc.next();
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        System.out.println("Using StringBuilder : "+sb);
        String str=new String();
        for(int i=s.length()-1;i>=0;i--)
        {
            str+=s.charAt(i);
        }
        System.out.println("Using Loop : "+str);
    }
}