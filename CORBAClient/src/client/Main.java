package client;

import OperationModule.Operation;
import OperationModule.OperationHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.util.Properties;

public class Main {

    private static Operation operation;
    private org.omg.CORBA.Object objRef;

    public static void main(String[] args) {
        Main start = new Main();
        start.init(args);
        System.out.println(operation.add(1, 2));
    }

    private void init(String[] args){
        Properties properties = new Properties();
        properties.put("org.omg.CORBA.ORBInitialHost", "localhost");  //指定ORB的ip地址
        properties.put("org.omg.CORBA.ORBInitialPort", "8080");       //指定ORB的端口

        //创建一个ORB实例
        ORB orb = ORB.init(args, properties);

        //获取根名称上下文
        try {
            objRef = orb.resolve_initial_references("NameService");
        } catch (InvalidName e) {
            e.printStackTrace();
        }
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        String name = "CORBATest";
        try {
            //通过ORB拿到server实例化好的Operation类
            operation = OperationHelper.narrow(ncRef.resolve_str(name));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
