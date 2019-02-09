//package Spark_Streaming.dataSource
//
//import java.io.{BufferedReader, InputStreamReader}
//import java.net.Socket
//import java.nio.charset.StandardCharsets
//
//import org.apache.spark.storage.StorageLevel
//import org.apache.spark.streaming.receiver.Receiver
//
///**
//  * 自定义Receiver方法
//  *
//  * @param host
//  * @param port
//  */
//class MyReceiver(host: String, port: Int) extends Receiver(StorageLevel.MEMORY_ONLY) {
////  // Receiver启动的时候调用的方法
////  override def onStart(): Unit = {
////    // 自己启动一个线程 去运行自己定义的方法
////    new Thread("MyReceiver") {
////      override def run(): Unit = {
////        receive()
////      }
////
////    }.start()
////
////  }
////
////  // 我的实现
////  def receive(): Unit = {
////    //
////    val socket = new Socket(host, port)
////    // 读取数据
////    val reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))
////    var lines = reader.readLine()
////    //
////    while(!isStopped()&&lines!=null){
////      // 把数据提交给spark
////      store(lines)
////      lines = reader.readLine()
////
////    }
////    reader.close()
////    socket.close()
////  }
////
////  // Receiver停止的时候调用的方法
////  override def onStop(): Unit = {
////
////  }
//}
