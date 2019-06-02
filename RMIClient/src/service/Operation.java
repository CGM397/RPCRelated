package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operation extends Remote {

    int add(int a, int b) throws RemoteException;

}
