package client;

import service.Operation;

import java.rmi.Naming;

public class Main {

    public static void main(String[] args) {
        try{
            Operation bankSystem =
                    (Operation) Naming.lookup("rmi://localhost:8080/rmiTest");
            System.out.println(bankSystem.add(1, 2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
