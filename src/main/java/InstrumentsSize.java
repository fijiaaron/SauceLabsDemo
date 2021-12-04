import java.util.HashMap;
import java.util.Map;

public class InstrumentsSize
{
    public static void main(String[] args)
    {
        Map<String, Integer> instruments = new HashMap<>();
        instruments.put("guitar", 1200);
        instruments.put("cello", 3000);
        instruments.put("drum", 2000);

        System.out.println(instruments);
        System.out.println(instruments.size());

        instruments.put("cello", 4500);


        System.out.println(instruments);
        System.out.println(instruments.size());
    }
}
