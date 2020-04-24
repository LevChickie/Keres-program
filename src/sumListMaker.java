import java.util.ArrayList;
import java.util.List;

public class sumListMaker {
    List<String> list;

    public sumListMaker()
    {
        list=new ArrayList<String>();
    }

    public void addList(List<String> newList)
    {
        List<String> newModifiableList=new ArrayList<String>();
        newModifiableList.addAll(newList);
        removeDuplicates(newModifiableList);
        if(list.isEmpty())
        {
            list.addAll(newModifiableList);
        }
        else {
            int size = newModifiableList.size();
            for(int i= 0; i<size;i++)
            {
                if(list.contains(newModifiableList.get(i)))
                {
                    newModifiableList.remove(i); i--; size=newModifiableList.size();
                }
            }
            list.addAll(newModifiableList);
        }
    }
    public void removeDuplicates(List<String> list)
    {
        List<String> checkList=new ArrayList<String>();
        int size = list.size();
        for(int i=0; i<size;i++)
        {
            if(!checkList.contains(list.get(i)))
            {
            checkList.add(list.get(i));
            }
            else
            {
                list.remove(i); i--; size=list.size();
            }
        }
    }
    public List<String> getList()
    {
        return list;
    }
}
