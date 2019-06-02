package server;

import service.Operation;
import serviceimpl.OperationImpl;

import javax.xml.ws.Endpoint;

public class Main {

    private static final String ADDRESS = "http://localhost:8080/WebServiceTest";

    public static void main(String[] args) {
        Operation operation = new OperationImpl();
        Endpoint.publish(ADDRESS, operation);
    }
}
