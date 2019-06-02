package serviceimpl;

import service.Operation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OperationImpl extends UnicastRemoteObject implements Operation {

    public OperationImpl() throws RemoteException {}

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
