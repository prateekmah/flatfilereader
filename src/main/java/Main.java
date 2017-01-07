import javax.security.auth.login.Configuration;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;


/**
 * Created by LENOVO on 1/6/2017.
 */
public class Main {


    public static void main(String[] args) throws Exception {

        /*Path pt=new Path("hdfs://nameservice1/user/pmaheshwari1/abc.txt");
        FileSystem fs = FileSystem.get(new org.apache.hadoop.conf.Configuration());
        BufferedReader br1=new BufferedReader(new InputStreamReader(fs.open(pt)));
*/


        SchemaParser sc=new SchemaParser();
        ArrayList<Integer> sizelist=sc.getSizeArray();
        File file = new File("C:\\Users\\LENOVO\\Desktop\\abc.txt");//reading data file
        FileReader fileReader=new FileReader(file);
        BufferedReader br=new BufferedReader(fileReader);


        //FileInputStream fis=new FileInputStream(file);
        Integer columnsize [] = sizelist.toArray(new Integer[sizelist.size()]);
        String row[]= new String[columnsize.length];
        int index=0;
        // System.out.print(br.readLine());

        String finaltext="";
        String s=null;
        ArrayList<ArrayList<String>> outerList = new ArrayList<ArrayList<String>>();
        while((s=br.readLine())!= null) {
            finaltext=finaltext+s;

        }
        s=finaltext;
        while(s.length() > index) {
            int i = 0;
            int count = 0;
            //String s = br.readLine();
            ArrayList<String> innerList = new ArrayList<String>();

            while (count < columnsize.length) {
                row[i] = (s.substring(index, index + columnsize[i]));
                innerList.add(row[i]);
                count++;
                index = index + columnsize[i];
                System.out.println(row[i]);
                i++;

            }
            outerList.add(innerList);
        }

        System.out.println(outerList);
    }
}
