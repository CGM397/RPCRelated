package serviceimpl;

import com.rabbitmq.client.*;
import service.Operation;

import java.util.UUID;

public class OperationImpl implements Operation {

    private Connection connection;
    private Channel channel;
    private String requestQueueName = "rpc_queue";
    private String replyQueueName;
    private QueueingConsumer consumer;

    public OperationImpl() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("cgm");
        factory.setPassword("123456");
        connection = factory.newConnection();
        channel = connection.createChannel();

        replyQueueName = channel.queueDeclare().getQueue();
        consumer = new QueueingConsumer(channel);
        channel.basicConsume(replyQueueName, true, consumer);
    }

    public int add(int a, int b) {
        int res = 0;
        String corrId = UUID.randomUUID().toString();

        AMQP.BasicProperties props = new AMQP.BasicProperties
                .Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();
        String message = a + "," + b;
        try{
            channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));
            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                if (delivery.getProperties().getCorrelationId().equals(corrId)) {
                    String response = new String(delivery.getBody(),"UTF-8");
                    res = Integer.parseInt(response);
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public void close() {
        try{
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
