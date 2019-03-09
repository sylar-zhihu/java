package Spark_2_2_1

import org.apache.spark.deploy.worker.Worker

object Spark_2_Worker {

  def main(args: Array[String]): Unit = {
    // Worker启动的main方法
//    Worker.main()
    /*
     def main(argStrings: Array[String]) {
      Utils.initDaemon(log) //初始log对象
      val conf = new SparkConf // 初始化SparkConf
      val args = new MasterArguments(argStrings, conf)
      // 启动RPC框架
      val (rpcEnv, _, _) = startRpcEnvAndEndpoint(args.host, args.port, args.webUiPort, conf)
      rpcEnv.awaitTermination()
  }
     */

  }
}
