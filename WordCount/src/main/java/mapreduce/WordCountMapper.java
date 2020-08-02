package mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author yanjh
 * @date 2020/8/2 10:50
 *
 * 当前WordCountMapper中输入KV,与输出KV的类型解释
 * 输入KV:
 * key：LongWritable 记录的是文件内容的偏移量，文件读取的到的位置
 * value：Text   表示文件中读取到的一行数据
 * 输出KV:
 * key: Text 表示一个单词作为key
 * value: IntWritable 表示当前单词出现的次数
 */
public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    Text k = new Text();
    IntWritable v = new IntWritable(1);
    /**
     * 重写map方法（MapReduce方法可以分为map阶段和reduce阶段）
     * @param key
     * @param value
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
      // 1、获取一行数据
        String string = value.toString();

        // 2、切分数据
        String[] s = string.split(" ");

        // 3、循环输出
        for (String s1 : s) {
            k.set(s1);
            context.write(k,v);
        }
    }

}
