import akka.actor.{Actor, ActorSystem, Props}

/**
  * 继承Actor类
  */
class HelloActor extends Actor {

  // 重写方法 接受消息的
  override def receive: Receive = {
    // 接受消息并处理
    case "hello" => println("hello")
    case "aa" => println("aa")
    // 停止
    case "stop" => {
      context.stop(self) // 停止自己的actorRef
      context.system.terminate() // 关闭ActorSystem
    }
  }
}

object HelloActor {

  // 得到工厂
  private val factory = ActorSystem("Factory")
  // 传入自己定义的类 得到引用
  private val helloActorRef = factory.actorOf(Props[HelloActor], "helloActor")

  def main(args: Array[String]): Unit = {
    // 给自己发送消息
    helloActorRef ! "hello"
    helloActorRef ! "aa"
    helloActorRef ! "stop"

  }

}
