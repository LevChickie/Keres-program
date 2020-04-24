import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        String nameFileFirst="37830";
        String nameFileSecond="37888";
        String nameFileThird="37958";
        String nameFileFourth="37967";
        String nameFileFifth="37981";
        HomeworkFileReader file = new HomeworkFileReader(nameFileFirst);
        String firstText = file.readFile();
        file = new HomeworkFileReader(nameFileSecond);
        String secondText = file.readFile();
        file = new HomeworkFileReader(nameFileThird);
        String thirdText = file.readFile();
        file = new HomeworkFileReader(nameFileFourth);
        String fourthText = file.readFile();
        file = new HomeworkFileReader(nameFileFifth);
        String fifthText = file.readFile();
        ContentChecker contentChecker = new ContentChecker();
        contentChecker.getStopWords();
        List<String> firstList = contentChecker.getWords(firstText);
        List<String> secondList = contentChecker.getWords(secondText);
        List<String> thirdList = contentChecker.getWords(thirdText);
        List<String> fourthList = contentChecker.getWords(fourthText);
        List<String> fifthList = contentChecker.getWords(fifthText);
        for(int i=0;i<fifthList.size();i++)
        {
            System.out.println(fourthList.get(i));
        }
        sumListMaker sum = new sumListMaker();
        sum.addList(firstList);
        sum.addList(secondList);
        sum.addList(thirdList);
        sum.addList(fourthList);
        sum.addList(fifthList);
        HashMap<String, List<String>> index =new HashMap<String, List<String>>();
        String word;
        List<String> files=new ArrayList<String>();
        IndexMaker indexMaker;
        for(int i=0;i<sum.getList().size();i++)
        {
            word=sum.getList().get(i);
            indexMaker=new IndexMaker(word);
            indexMaker.test(nameFileFirst+".txt",firstList);
            indexMaker.test(nameFileSecond+".txt",secondList);
            indexMaker.test(nameFileThird+".txt",thirdList);
            indexMaker.test(nameFileFourth+".txt",fourthList);
            indexMaker.test(nameFileFifth+".txt",fifthList);

            index.put(word,indexMaker.getFiles());
        }
        for(String words : index.keySet())
        {
            System.out.println("Word: "+words+" =>"+index.get(words));

        }
        HomeworkFileWriter fileWriter = new HomeworkFileWriter();
        boolean isSuccesfull= fileWriter.write(index, "index");
        if(!isSuccesfull)
        {
            System.out.println("Problem occured. Documentum index.txt was not overriden");
        }
        EasySearcher easySearcher = new EasySearcher();
        List<String> list=new ArrayList<String>();
        list.add("Ericsson"); list.add("mobiltelefon"); list.add("célul"); list.add("rohanó");//list.add("Amilyen");
        easySearcher.findDocumentsContaining(list);
    }
}
