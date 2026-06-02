import java.util.*;
class GuessGame
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        while(true)
        {
            System.out.println("Guess the number :");
            int num=sc.nextInt();
            if(num==65)
            {
                System.out.println("Correct Congratulations");
                return ;
            }
            else if(num>65)
            {
                System.out.println("Number is High!!");
            }
            else if(num<65)
            {
                System.out.println("Number is Low!!");
            }
        }
    }
}