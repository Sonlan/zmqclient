package clients;

import org.zeromq.ZMQ;

/**
 * Created by Song on 2016/9/10.
 * 发布订阅模式Client
 */
public class PUB_SUB_Mode {
    public static void main(String [] args){
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);

/*        subscriber.bind("tcp:/*//*:5556");
        subscriber.bind("ipc://weather");*/
        subscriber.connect("tcp://127.0.0.1:5555");
        subscriber.subscribe("weather".getBytes());
//        subscriber.connect("ipc://weather");

        while(!Thread.currentThread().isInterrupted()){
            //byte [] bytes = subscriber.recv();
            String message = subscriber.recvStr();
            System.out.println("收到消息:"+message);
        }
    }
}
