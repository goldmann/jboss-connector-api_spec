package javax.resource.cci;

import javax.resource.ResourceException;

/** The LocalTransaction defines a transaction demarcation interface for
 *  resource manager local transactions. Note that this interface is 
 *  used for application level local transaction demarcation. The
 *  system contract level LocalTransaction interface (as defined in
 *  the <code>javax.resource.spi</code> package) is used by the container 
 *  for local transaction management.
 *
 *  <p>A local transaction is managed internal to a resource manager. There
 *  is no external transaction manager involved in the coordination of 
 *  such transactions.
 *
 *  <p>A CCI implementation can (but is not required to) implement the
 *  LocalTransaction interface. If the LocalTransaction interface is supported
 *  by a CCI implementation, then the method 
 *  <code>Connection.getLocalTransaction</code> should return a
 *  LocalTransaction instance. A component can then use the
 *  returned LocalTransaction to demarcate a resource manager local transaction
 *  (associated with the Connection instance) on the underlying EIS 
 *  instance.
 *  
 *  @author  Rahul Sharma
 *  @since   0.8
 *  @see     javax.resource.cci.Connection
**/

public interface LocalTransaction 
{
   
   /** Begins a local transaction on an EIS instance.
    *
    *  @throws  ResourceException  Failed to begin a local
    *                              transaction. Examples of
    *                              error cases are:
    *           <UL>
    *             <LI>Resource adapter internal or EIS-specific
    *                 error
    *             <LI>Connection is already participating in a 
    *                 local or JTA transaction 
    *           </UL> 
    **/
   public void begin() throws ResourceException;

   /** Commits the current local transaction and release all locks held 
    *  by the underlying EIS instance.
    *
    *  @throws  ResourceException  Failed to commit a local
    *                              transaction. Examples of
    *                              error cases are:
    *          <UL>
    *            <LI> Resource adapter internal or EIS-specific error
    *            <LI> Violation of integrity constraints, deadlock 
    *                 detection, communication failure during 
    *                 transaction completion, or any retry requirement
    *            <LI> Connection is participating in an active JTA
    *                 transaction 
    *            <LI> Invalid transaction context; commit
    *                 operation invoked without an active
    *                 transaction context
    *         </UL> 
    **/
   public void commit() throws ResourceException;

   /** Rollbacks the current resource manager local transaction.
    *
    *  @throws  ResourceException  Failed to rollback a local
    *                              transaction. Examples of
    *                              error cases are:
    *           <UL>
    *             <LI> Resource adapter internal or EIS-specific error
    *             <LI> Connection is participating in an active JTA 
    *                  transaction 
    *             <LI> Invalid transaction context; rollback
    *                  operation invoked without an active
    *                  transaction context
    *          </UL> 
    **/
   public void rollback() throws ResourceException;
}
