import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
class Dictionary
{
    private String[] words;
    public Dictionary()
    {
        try
        {
            ArrayList<String> temp = new ArrayList<String>();
            File file = new File("ospd.txt");
            Scanner scanner = new Scanner(file);
            //System.out.println(file.getName());
            while (scanner.hasNextLine())
            {
                temp.add(scanner.nextLine());
            }
            words = temp.toArray(new String[temp.size()]);
        }
        catch (IOException e) {System.out.println(e.getMessage());}
    }
    public boolean lookUp(String word)
    {
        if (Arrays.binarySearch(words, word) < 0)
        {
            return false;
        }
        return true;
    }
}