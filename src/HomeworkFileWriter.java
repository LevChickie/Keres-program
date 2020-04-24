import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class HomeworkFileWriter {
    public HomeworkFileWriter() {
    }

    public boolean write(HashMap<String, List<String>> index, String filename)
    {
        try {
            FileWriter writer = new FileWriter(filename+".txt");
            for(String words : index.keySet())
            {
                writer.write(words+":"+index.get(words)+"\n");

            }
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
