package serviceimpl;

import OperationModule.OperationPOA;

public class OperationImpl extends OperationPOA {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
