import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CreateArrayList
{
    public static void main(String[] args)
    {
//        ArrayList<String> words = new ArrayList<String>() { "Hello", "World"};
//        ArrayList words = Arrays.asList("Hello", "World");
        ArrayList<String> words = new ArrayList<>(Arrays.asList("Hello", "World"));
//        ArrayList<String> words = {"Hello", "World"};

        System.out.println(words);
    }
}
