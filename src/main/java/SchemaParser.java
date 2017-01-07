import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LENOVO on 1/7/2017.
 */
public class SchemaParser
{
    Map<String , Integer> varToSizeMap = new HashMap<String , Integer>();

    private  void populateVarToSizeMap() throws Exception {
        File file = new File("C:\\Users\\LENOVO\\Desktop\\size.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        while((line = br.readLine()) != null)
        {
            String[] arr = line.split(" ");
            varToSizeMap.put(arr[0] , Integer.parseInt(arr[1]));
        }

    }


    private ArrayList<Integer> createSizeArray () throws Exception {
        ArrayList<Integer> sizelist=new ArrayList<Integer>();
        File file = new File("C:\\Users\\LENOVO\\Desktop\\schema.txt");
        BufferedReader br=new BufferedReader(new FileReader(file));
       // String regex="(\\w)+\\((\\d+)\\)";
        String regex="^\\S+\\s+(\\S+)";
        //String regex="([a-z])+";
        String line="";
        while((line = br.readLine()) != null)
        {
            Pattern p =Pattern.compile(regex);
            Matcher m=p.matcher(line);
            int size=0;
            if(m.find()) {
                //System.out.println(m.group(1));
                String datatype = m.group(1);
               // int exist=datatype.indexOf("(");
               // String finalDataType=datatype;


                if(datatype.contains("("))
                {
                    int start=datatype.indexOf("(");
                    int end=datatype.indexOf(")");
                    size=Integer.parseInt(datatype.substring(start+1,end));
                    //System.out.println(size);
                }

                else
                {
                  size=varToSizeMap.get(datatype);
                }
                sizelist.add(size);
            }
            //String[] arr = line.split(" ");
           // varToSizeMap.put(arr[0] , Integer.parseInt(arr[1]));
        }


return  sizelist;

    }

    public ArrayList<Integer> getSizeArray() throws Exception {
        populateVarToSizeMap();
        return createSizeArray();
    }


}
