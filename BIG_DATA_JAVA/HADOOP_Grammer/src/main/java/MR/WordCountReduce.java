package MR;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/*
 * 作者:Lijianbo
 * 日期:2016年5月25日:下午4:51:16
 * 程序作用:
 * 所有的map执行完了才会执行reduce
 * 首先要继承
 * 两个参数是map传递的
 * 后两个参数作为输出
 */
public class WordCountReduce extends Reducer<Text, LongWritable, Text, LongWritable> {

    /*
     * 框架在map之后，将所有的key value对缓存
     * 然后分组
     * key为一个值，value为传递value的list
     * 如：
     * <hello,{1,1,1,1,1,1,1,1,1}>
     *
     * 每一组调用一次reduce
     */
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values,
                          Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
        long count = 0;
        // 遍历value的list
        for (LongWritable value : values) {
            // 得到结果
            count += value.get();
        }
        // 输出到context
        context.write(key, new LongWritable(count));

    }
}
