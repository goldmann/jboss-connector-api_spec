package javax.resource.spi;

import javax.resource.ResourceException;

/**
 * This is a mix-in interface that may be optionally implemented by a 
 * <code>ConnectionManager</code> implementation. An implementation of
 * this interface must support the lazy connection association optimization.
 *
 * @version 1.0
 * @author  Ram Jeyaraman
 */
public interface LazyAssociatableConnectionManager 
{
   
   /**
    * This method is called by a resource adapter (that is capable of
    * lazy connection association optimization) in order to lazily associate
    * a connection object with a <code>ManagedConnection</code> instance. 
    *
    * @param connection the connection object that is to be associated.
    *
    * @param mcf The <code>ManagedConnectionFactory</code> instance that was
    * originally used to create the connection object.
    *
    * @param cxReqInfo connection request information. This information must
    * be the same as that used to originally create the connection object.
    *
    * @throws  ResourceException     Generic exception.
    *
    * @throws  ApplicationServerInternalException 
    *                              Application server specific exception.
    *
    * @throws  SecurityException     Security related error.
    *
    * @throws  ResourceAllocationException
    *                              Failed to allocate system resources for
    *                              connection request.
    * @throws  ResourceAdapterInternalException
    *                              Resource adapter related error condition.
    */
   void associateConnection(Object connection, 
                            ManagedConnectionFactory mcf,
                            ConnectionRequestInfo cxReqInfo) 
      throws ResourceException;

   /**
    * This method is called by the resource adapter (that is capable of
    * lazy connection association optimization) in order to notify the
    * application server that a disassociated connection handle is closed.
    * <p>The application server can then perform any cleanup operations 
    * related to the disassociated connection handle in its connection pool.
    *
    * @param connection the disassociated connection object handle that 
    * has been closed
    *
    * @param mcf The <code>ManagedConnectionFactory</code> instance that was
    * originally used to create the connection object.
    *
    * @since 1.6
    */
   void inactiveConnectionClosed(Object connection, 
                                 ManagedConnectionFactory mcf);
}
