import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeworkFileReader {

    File file;
    public HomeworkFileReader(String name)
    {
        file = new File(name+".txt");
    }

    public String readFile()
    {
        String text="";
        try {
        FileInputStream is = new FileInputStream(file.getName());
        InputStreamReader isr = new InputStreamReader(is, "windows-1250");
        BufferedReader bufferedReader = new BufferedReader(isr);
        String data="";
            try
            {
             while((data = bufferedReader.readLine()) != null)
            {
            text+=data;
            }}
            finally{
            bufferedReader.close();
            }
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return text;
    }
    public List<String> readFileByLines()
    {
        List<String> text=new ArrayList<String>();
        try {
            FileInputStream is = new FileInputStream(file.getName());
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String data="";
            try
            {
                while((data = bufferedReader.readLine()) != null)
                {
                    text.add(data);
                }}
            finally{
                bufferedReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return text;
    }
}
