import java.util.*;

class Lambda
{
    public static void main(String args[])
    {
        List<String> names=new ArrayList<>();
        names.add("Surya");
        names.add("Krishna");
        names.add("Java");
        names.add("Programming");
        names.add("Apple");

        System.out.println("Before Sorting");
        System.out.println(names);

        Collections.sort(names,(n1,n2)->n1.compareTo(n2));

        System.out.println("After Sorting");
        System.out.println(names);
    }
}