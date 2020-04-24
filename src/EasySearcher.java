import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EasySearcher {
    List<String> wordData;
    public EasySearcher()
    {
        wordData = new ArrayList<String>();
    }

    public void findDocumentsContaining(List<String> words)
    {
        HomeworkFileReader fileReader = new HomeworkFileReader("index");
        List<String> indexRows = fileReader.readFileByLines();
        List<String> documentsContaining = new ArrayList<String>();
        List<String> documentsToRank = new ArrayList<String>();
        HashMap<String, List<String>> index = createHashMap(indexRows);
        int size = documentsContaining.size();
        int count = 0;
        for(String word : words)
        {
            documentsToRank.addAll(index.get(word));
            if(documentsContaining.isEmpty()&&count==0) {
                documentsContaining.addAll(index.get(word));
                size=documentsContaining.size();
                count++;
            }
            else if(documentsContaining.isEmpty())
            {
                break;
            }
            else {
                for(int i =0; i<size;i++)
                {
                    if(!index.get(word).contains(documentsContaining.get(i)))
                    {
                       documentsContaining.remove(i); i--; size=documentsContaining.size();
                    }
                }
            }
        }
        if(documentsContaining.isEmpty())
        {
            System.out.println("No valid document which includes all files!");
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.print("Type 'egyenkent' to write one by one, or write anything to write out sorted: ");
                String input = bufferedReader.readLine();
                if(input.equals("egyenkent"))
                {
                    System.out.println("one by one the words:");
                    for(String word : words)
                    {
                    System.out.println(word +": "+index.get(word));
                    }
                }
                else{
                    Collections.sort(documentsToRank);
                    count =1;
                    HashMap<String, Integer> documentumContent= new HashMap<String, Integer>();
                    for(int i =0; i<documentsToRank.size();i++)
                    {
                        if(i<(documentsToRank.size()-1))
                        {
                            if(documentsToRank.get(i).equals(documentsToRank.get(i+1)))
                            {
                            count++;
                            }
                            else {
                            documentumContent.put(documentsToRank.get(i),count); count =1;
                            }
                        }
                        else if(i==documentsToRank.size()-1)
                        {
                            documentumContent.put(documentsToRank.get(i),count); count =1;
                        }
                    }
                    for(String fileName : documentumContent.keySet())
                    {
                        System.out.println(fileName+": "+documentumContent.get(fileName));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("These documents include the files:"+documentsContaining);
        }
    }
    public HashMap<String, List<String>> createHashMap(List<String> list)
    {
        String[] documents;
        String[] document;
        List<String> files;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String row : list)
        {
            files=new ArrayList<String>();
            row=row.replaceAll("\\[","");
            row=row.replaceAll("\\]","");
            documents=row.split(":");
            document=documents[1].split(",");
            files.addAll(Arrays.asList(document));
            map.put(documents[0],files);
        }
        return map;
    }

}
