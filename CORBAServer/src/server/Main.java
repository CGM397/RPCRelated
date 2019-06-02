package server;

import OperationModule.Operation;
import OperationModule.OperationHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import serviceimpl.OperationImpl;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try{
            Properties properties = new Properties();
            properties.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            properties.put("org.omg.CORBA.ORBInitialPort", "8080");
            ORB orb = ORB.init(args, properties);

            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            OperationImpl instance = new OperationImpl();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(instance);

            Operation service = OperationHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt namingContextExt = NamingContextExtHelper.narrow(objRef);
            namingContextExt.rebind(namingContextExt.to_name("CORBATest"), service);
            orb.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
