package server;

import serviceimpl.OperationImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(8080);
            Naming.bind("rmi://localhost:8080/rmiTest", new OperationImpl());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
