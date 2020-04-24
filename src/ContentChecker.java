import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContentChecker {
    List<String> list;
    List<String> stopWords;
    public ContentChecker()
    {
        stopWords = new ArrayList<String>();
    }
    public List<String> getWords(String text)
    {
        this.list=new ArrayList<String>();
        text = text.replaceAll("\\(","");
        text = text.replaceAll("\\)","");
        String words [] = text.split(" |\\, |\\. |\\\" |\\; |\\: |\\? |\\! |\\\t |\\\n |\\\r");
        ArrayList<String> listOfWords = new ArrayList<String>(Arrays.asList(words));
        int length = listOfWords.size();
        String data;
        for(int i=0;i<length;i++)
        {
            data = listOfWords.get(i);
            if(data.isEmpty())
            {listOfWords.remove(i); i--; length=listOfWords.size();}
            else if(!stopWords.contains(data))
            {
                list.add(data);
            }
        }
        return list;
    }
    public int stopsize()
    {
        return stopWords.size();
    }
    public String getstop(int i)
    {
        return stopWords.get(i);
    }
    public void getStopWords()
    {
        try{
        FileInputStream is = new FileInputStream("stopwords.txt");
        InputStreamReader isr = new InputStreamReader(is, "windows-1250");
        BufferedReader bufferedReader = new BufferedReader(isr);
        String data;
        while((data=bufferedReader.readLine())!=null) {
            if (!stopWords.contains(data)) {
                stopWords.add(data);
            }
        }}
        catch (UnsupportedEncodingException e)
        {
            System.out.println("bad encoding");
        }
        catch (IOException e)
        {
            System.out.println("bad IO");
        }

    }
}
