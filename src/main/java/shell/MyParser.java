package shell;

import java.util.ArrayList;
import java.util.List;

public class MyParser {

    public List<String> Parse(String str, char delimiter)
    {
        String string = str;
        List<String> strmass = new ArrayList<String>();
        boolean stop = false;
        while(!stop)
        {
            if(string.contains(" ")){
                int index = string.indexOf(delimiter);
                String res = string.substring(0,index);
                strmass.add(res);
                string = string.substring(index+1,string.length());
            }
            else {
                strmass.add(string);
                stop = true;
            }
        }
        return strmass;
    }
}
