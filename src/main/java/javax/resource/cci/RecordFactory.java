package javax.resource.cci;

import javax.resource.ResourceException;


/** The RecordFactory interface is used for creating MappedRecord and 
 *  IndexedRecord instances. Note that the RecordFactory is only used 
 *  for creation of generic record instances. A CCI implementation 
 *  provides an implementation class for the RecordFactory interface.
 *
 *  @author   Rahul Sharma
 *  @since    0.8
 *  @see      javax.resource.cci.IndexedRecord
 *  @see      javax.resource.cci.MappedRecord
**/
public interface RecordFactory 
{
  
   /** Creates a MappedRecord. The method takes the name of the record
    *  that is to be created by the RecordFactory. The name of the 
    *  record acts as a pointer to the meta information (stored in 
    *  the metadata repository) for a specific record type.
    *
    *  @param  recordName   Name of the Record
    *  @return MappedRecord
    *  @throws ResourceException  Failed to create a MappedRecord.
    *                             Example error cases are:
    *                              
    *          <UL>
    *             <LI> Invalid specification of record name
    *             <LI> Resource adapter internal error
    *             <LI> Failed to access metadata repository
    *          </UL>
    *  @throws javax.resource.NotSupportedException Operation not supported          
    *                            
    **/
   public MappedRecord createMappedRecord(String recordName) 
      throws ResourceException;

   /** Creates a IndexedRecord. The method takes the name of the record
    *  that is to be created by the RecordFactory. The name of the 
    *  record acts as a pointer to the meta information (stored in 
    *  the metadata repository) for a specific record type.
    *
    *  @param  recordName   Name of the Record
    *  @return IndexedRecord
    *  @throws ResourceException  Failed to create an IndexedRecord.
    *                             Example error cases are:
    *                              
    *          <UL>
    *             <LI> Invalid specification of record name
    *             <LI> Resource adapter internal error
    *             <LI> Failed to access metadata repository
    *          </UL>
    *  @throws javax.resource.NotSupportedException Operation not supported          
    **/
   public IndexedRecord createIndexedRecord(String recordName) 
      throws ResourceException;
}
