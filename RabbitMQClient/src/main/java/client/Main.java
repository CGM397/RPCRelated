package client;

import service.Operation;
import serviceimpl.OperationImpl;

public class Main {

    public static void main(String[] args) {
        Operation operation = null;
        try{
             operation = new OperationImpl();
            System.out.println(operation.add(1, 2));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(operation != null)
                operation.close();
        }
    }
}
