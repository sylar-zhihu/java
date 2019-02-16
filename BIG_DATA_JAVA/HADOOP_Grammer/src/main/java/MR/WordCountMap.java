package MR;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/*
 * 作者:Lijianbo
 * 日期:2016年5月25日:下午4:50:53
 * 程序作用:hadoop的Map方法
 * 首先要继承Mapper
 * 里面有四个参数
 * 前两个指定map输入数据的类型key value对
 * 默认情况下传递给map的数据key 为long value为String
 * 但是序列传输需要序列化，所以改为LongWritable和Text
 * key为文本中一行的偏移量
 * 第一次为0 如果第一次的value为hello world
 * 第二次的偏移量为12 0+11+1 1为换行符
 * value为文本内容
 *
 * 后两个是输出给recude的参数
 * 可以自定义
 *
 * KEYIN, VALUEIN, KEYOUT, VALUEOUT
 *
 * 用hadoop封装的数据类型
 * long->LongWritable
 * String->Text
 */
public class WordCountMap extends Mapper<LongWritable, Text, Text, LongWritable> {

    // 每读一行数据就调用一次map方法
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
            throws IOException, InterruptedException {
        // 把内容转为String
        String line = value.toString();
        // 按空格分割
        String[] wordsArray = StringUtils.split(line, " ");
        for (String word : wordsArray) {
            // 返回值保存在Context中 在上面已经定义好了
            context.write(new Text(word), new LongWritable(1));

        }

    }
}
