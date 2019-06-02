package OperationModule;

/**
* OperationModule/OperationHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl/operation.idl
* 2019��6��2�� ������ ����03ʱ57��17�� CST
*/

public final class OperationHolder implements org.omg.CORBA.portable.Streamable
{
  public OperationModule.Operation value = null;

  public OperationHolder ()
  {
  }

  public OperationHolder (OperationModule.Operation initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = OperationModule.OperationHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    OperationModule.OperationHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return OperationModule.OperationHelper.type ();
  }

}
