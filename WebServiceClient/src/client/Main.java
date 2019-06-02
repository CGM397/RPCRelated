package client;

import mypackage.OperationImpl;
import mypackage.OperationImplService;

public class Main {

    public static void main(String[] args) {
        OperationImplService operationImplService = new OperationImplService();
        OperationImpl operation = operationImplService.getOperationImplPort();
        System.out.println(operation.add(3, 2));
    }
}
