package OperationModule;


/**
* OperationModule/OperationPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从idl/operation.idl
* 2019年6月2日 星期日 下午03时57分17秒 CST
*/

public abstract class OperationPOA extends org.omg.PortableServer.Servant
 implements OperationModule.OperationOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    Integer __method = (Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // OperationModule/Operation/add
       {
         int a = in.read_long ();
         int b = in.read_long ();
         int $result = (int)0;
         $result = this.add (a, b);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:OperationModule/Operation:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Operation _this() 
  {
    return OperationHelper.narrow(
    super._this_object());
  }

  public Operation _this(org.omg.CORBA.ORB orb) 
  {
    return OperationHelper.narrow(
    super._this_object(orb));
  }


} // class OperationPOA
