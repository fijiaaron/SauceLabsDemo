public class HelloHello
{
    static int count = 0;
    public static void main(String[] args)
    {
        if (count < 3)
        {
            count++;
            main(null);
        }
        System.out.println("Hello");
    }
}
