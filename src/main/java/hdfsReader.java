/**
 * Created by LENOVO on 1/7/2017.
 */

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.MiniDFSCluster;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

//import java.nio.file.Path;
//import java.nio.file.Files;
//import java.nio.file.Files;

public class hdfsReader {

    public static void main(String[] args) throws Exception {

        /*Path pt = new Path("hdfs://nameservice1/user/pmaheshwari1/abc.txt");
        FileSystem fs = FileSystem.get(new org.apache.hadoop.conf.Configuration());
        BufferedReader br1 = new BufferedReader(new InputStreamReader(fs.open(pt)));
*/

        File baseDir = File.createTempFile("test",".txt").getAbsoluteFile();
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set(MiniDFSCluster.HDFS_MINIDFS_BASEDIR, baseDir.getAbsolutePath());
        MiniDFSCluster.Builder builder = new MiniDFSCluster.Builder(conf);
        MiniDFSCluster hdfsCluster = builder.build();

        String hdfsURI = "hdfs://localhost:"+ hdfsCluster.getNameNodePort() + "/";
        DistributedFileSystem fileSystem = hdfsCluster.getFileSystem();
        Path pt = new Path(hdfsURI + baseDir);
        FileSystem fs = FileSystem.get(new org.apache.hadoop.conf.Configuration());
        BufferedReader br1 = new BufferedReader(new InputStreamReader(fs.open(pt)));
        System.out.println(br1.readLine());
    }

    }
