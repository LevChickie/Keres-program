import java.util.ArrayList;
import java.util.List;

public class IndexMaker {
    String word;
    List<String> files;
    public IndexMaker(String name)
    {
        word=name;
        files=new ArrayList<String>();
    }
    public void test(String name, List<String> content)
    {
        if(content.contains(word))
        {
            files.add(name);
        }
    }

    public List<String> getFiles()
    {
        return files;
    }
    public String getWord()
    {
        return word;
    }
}
