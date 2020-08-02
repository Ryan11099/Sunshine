package mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author yanjh
 * @date 2020/8/2 11:12
 */


/**
 * 第一对KV 表示Reduce输入的kv值。类型与Map的输出值相同
 * 第二对KV 表示Reduce输出的kv值。类型自己决定（根据需要的类型判断）
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {


    IntWritable v = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,
                          Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        // 在这里做统计数据的累加操作
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        // 写数据
        v.set(sum);
        context.write(key,v);
    }
}
