package com.atguigu.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.net.URI;


/**
 * @author yanjh
 * @date 2020/7/24 21:33
 */
public class HdfsClient {

    @Test
    public void testConnection() throws Exception {
        // 创建配置文件对象
        Configuration conf = new Configuration();
        // 获取到文件系统对象
       //FileSystem fs = FileSystem.get(conf);
        // 设置连接的对象信息
        // conf.set("fs.defaultFS", "hdfs://hadoop102:9000");
        // 用于指定用户信息
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), conf, "root");
        // 操作
        boolean result = fs.mkdirs(new Path("/test"));
        // 关闭资源
        fs.close();

        System.out.println("result:" + result);
    }

    @Test
    public void testCopyFileFromLocal() throws  Exception{
        // 获取文件信息
        Configuration conf = new Configuration();
        conf.set("dfs.replication","2");
        // 用于指定用户信息
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), conf, "root");
        // 上传文件
        // 2 上传文件
        fs.copyFromLocalFile(new Path("e:/banzhang.txt"), new Path("/banzhang.txt"));
        // 3，关闭资源
        fs.close();
    }
/*
    @Test
    public void testMkdirs() throws IOException, InterruptedException, URISyntaxException {

        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 配置在集群上运行
        // configuration.set("fs.defaultFS", "hdfs://hadoop102:9000");
        // FileSystem fs = FileSystem.get(configuration);

        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "atguigu");

        // 2 创建目录
        fs.mkdirs(new Path("/1108/daxian/banzhang"));

        // 3 关闭资源
        fs.close();
    }*/
}