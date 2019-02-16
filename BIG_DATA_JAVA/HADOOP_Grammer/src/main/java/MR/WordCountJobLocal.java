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
 * 本地运行，直接运行main方法,把路径改为本地路径
**/
public class WordCountJobLocal {
	
	public static void main(String[] args) {
		try {
			Configuration configuration = new Configuration();
			// 得到job对象
			Job job = Job.getInstance(configuration);
			// 设置整个job类使用的jar包的位置
			job.setJarByClass(WordCountJobLocal.class);
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
			FileInputFormat.setInputPaths(job, new Path("D:/a"));
			// 指定结果保存目录 这个没有不要紧 会自动新建
			FileOutputFormat.setOutputPath(job, new Path("D:/a/out"));

			// 是否显示执行过程
			job.waitForCompletion(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
