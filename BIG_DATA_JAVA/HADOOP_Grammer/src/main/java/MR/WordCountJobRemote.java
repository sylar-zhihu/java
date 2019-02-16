package MR;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.v2.app.webapp.dao.ConfEntryInfo;

/*
 * 作者:Lijianbo
 * 日期:2016年5月25日:下午5:53:12
 * 程序作用:
 * 用来把map和reduce程序连接起来。成为一个job
**/
public class WordCountJobRemote {
	public static void main(String[] args) {

		try {
			Configuration configuration = new Configuration();
			// 得到job对象
			Job job = Job.getInstance(configuration);
			// 设置整个job类使用的jar包的位置
			job.setJarByClass(WordCountJobRemote.class);
			// 指定mapper对象
			job.setMapperClass(WordCountMap.class);
			// 指定reduce对象
			job.setReducerClass(WordCountReduce.class);

			// reduce输出的key的类型 value类型 这里是对map和reduce都起作用
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(LongWritable.class);
			// map的输出key value类型
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(LongWritable.class);
			// 指定输入数据存放路径 这个要自己先建立
			FileInputFormat.setInputPaths(job, new Path("/wc/data/"));
			/*
			 *  指定结果保存目录 这个路径不能存在 因为存在可能覆盖文件
			 *  所以要指定一个不存在的文件路径
			 */
			FileOutputFormat.setOutputPath(job, new Path("/wc/output/"));
			
			// 是否显示执行过程
			job.waitForCompletion(true);
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
