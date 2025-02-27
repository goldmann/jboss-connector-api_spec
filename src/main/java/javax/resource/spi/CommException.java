package javax.resource.spi;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * This indicates errors related to failed or interrupted 
 * communication with an EIS instance. Examples of common error conditions
 * represented by this exception type are communication protocol error and
 * invalidated connection due to server failure. 
 *
 * @version 1.0
 * @author Rahul Sharma
 * @author Ram Jeyaraman
 */
public class CommException extends javax.resource.ResourceException 
{
   /** Serial version uid */
   private static final long serialVersionUID;

   static
   {
      Boolean legacy = (Boolean)AccessController.doPrivileged(new PrivilegedAction()
      {
         public Boolean run()
         {
            try
            {
               if (System.getProperty("org.jboss.j2ee.LegacySerialization") != null)
                  return Boolean.TRUE;
            }
            catch (Throwable ignored)
            {
               // Ignore
            }
            return Boolean.FALSE;
         }
      });

      if (Boolean.TRUE.equals(legacy))
      {
         serialVersionUID = -4522218827155509206L;
      }
      else
      {
         serialVersionUID = 5000980212339163591L;
      }
   }
   
   /**
    * Constructs a new instance with null as its detail message.
    */
   public CommException()
   { 
      super(); 
   }

   /**
    * Constructs a new instance with the specified detail message.
    *
    * @param message the detail message.
    */
   public CommException(String message) 
   {
      super(message);
   }

   /**
    * Constructs a new throwable with the specified cause.
    *
    * @param cause a chained exception of type <code>Throwable</code>.
    */
   public CommException(Throwable cause) 
   {
      super(cause);
   }

   /**
    * Constructs a new throwable with the specified detail message and cause.
    *
    * @param message the detail message.
    *
    * @param cause a chained exception of type <code>Throwable</code>.
    */
   public CommException(String message, Throwable cause) 
   {
      super(message, cause);
   }

   /**
    * Constructs a new throwable with the specified detail message and
    * an error code.
    *
    * @param message a description of the exception.
    * @param errorCode a string specifying the vendor specific error code.
    */
   public CommException(String message, String errorCode) 
   {
      super(message, errorCode);
   }
}
