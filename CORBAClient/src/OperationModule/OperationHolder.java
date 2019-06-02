package OperationModule;

/**
* OperationModule/OperationHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��idl/operation.idl
* 2019��6��2�� ������ ����03ʱ57��17�� CST
*/

public final class OperationHolder implements org.omg.CORBA.portable.Streamable
{
  public Operation value = null;

  public OperationHolder ()
  {
  }

  public OperationHolder (Operation initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = OperationHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    OperationHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return OperationHelper.type ();
  }

}
