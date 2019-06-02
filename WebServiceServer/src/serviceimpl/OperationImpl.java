package serviceimpl;

import service.Operation;

import javax.jws.WebService;

@WebService
public class OperationImpl implements Operation {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
