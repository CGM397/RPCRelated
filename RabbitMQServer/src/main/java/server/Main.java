package server;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.AMQP.BasicProperties;
import service.Operation;
import serviceimpl.OperationImpl;

public class Main {

    private static final String RPC_QUEUE_NAME = "rpc_queue";

    public static void main(String[] args) {
        Operation myOperation = new OperationImpl();
        Connection connection = null;
        Channel channel;
        try {

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672);
            factory.setUsername("cgm");
            factory.setPassword("123456");
            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);

            channel.basicQos(1);

            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(RPC_QUEUE_NAME, false, consumer);

            while (true) {
                String response = null;

                QueueingConsumer.Delivery delivery = consumer.nextDelivery();

                BasicProperties props = delivery.getProperties();
                BasicProperties replyProps = new BasicProperties
                        .Builder()
                        .correlationId(props.getCorrelationId())
                        .build();

                try {
                    String message = new String(delivery.getBody(),"UTF-8");
                    String[] store = message.split(",");
                    int a = Integer.parseInt(store[0]);
                    int b = Integer.parseInt(store[1]);
                    response = "" + myOperation.add(a, b);
                } catch (Exception e){
                    response = "";
                } finally {
                    if(response != null){
                        channel.basicPublish( "", props.getReplyTo(), replyProps, response.getBytes("UTF-8"));

                        channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                    }
                }
            }
        } catch  (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (Exception ignore) {}
            }
        }
    }
}
