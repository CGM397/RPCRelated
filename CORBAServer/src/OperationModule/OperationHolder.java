package OperationModule;

/**
* OperationModule/OperationHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从idl/operation.idl
* 2019年6月2日 星期日 下午03时57分17秒 CST
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
