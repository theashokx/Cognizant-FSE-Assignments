import java.util.*;
import java.util.stream.*;

class StreamApi
{
    public static void main(String args[])
    {
        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> even=list.stream()
                                .filter(n->n%2==0)
                                .collect(Collectors.toList());
        
        System.out.println(even);
    }
}