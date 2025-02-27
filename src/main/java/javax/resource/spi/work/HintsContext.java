package javax.resource.spi.work;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * A standard {@link WorkContext WorkContext} that allows a {@link Work
 * Work} instance to propagate quality-of-service (QoS) hints about the
 * {@link Work Work} to the <code>WorkManager</code>.
 * 
 * @since 1.6
 * @see javax.resource.spi.work.WorkContextProvider
 * @version Java EE Connector Architecture 1.6
 */

public class HintsContext implements WorkContext 
{

   /**
    * Determines if a deserialized instance of this class
    * is compatible with this class.
    */
   private static final long serialVersionUID = 7956353628297167255L;

   /** The name hint */
   public static final String NAME_HINT = "javax.resource.Name";

   /** The long running hint */
   public static final String LONGRUNNING_HINT = "javax.resource.LongRunning";
   
   /** Description */
   protected String description = "Hints Context";

   /** Name */
   protected String name = "HintsContext";

   /** The hints */
   Map<String, Serializable> hints = new HashMap<String, Serializable>();
      
   /**
    * {@inheritDoc}
    */
   public String getDescription() 
   {
      return description;
   }
   
   /**
    * {@inheritDoc}
    */
   public String getName() 
   {
      return name;
   }
   
   /**
    * Set a brief description of the role played by the instance of
    * HintsContext and any other related debugging information.
    *
    * This could be used by the resource adapter and the WorkManager
    * for logging and debugging purposes.
    * @param description The description
    */
   public void setDescription(String description)
   {
      this.description = description;
   }
   
   /**
    * Set the associated name of the HintsContext. This
    * could be used by the resource adapter and the WorkManager
    * for logging and debugging purposes.
    * @param name The name
    */
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
    * Set a Hint and a related value. The hintName must be non-Null.
    * Standard HintNames are defined in the Connector specification. Use of
    * "javax.resource." prefixed hintNames are reserved for use by the 
    * Connector specification.
    * @param hintName The hint name
    * @param value The hint value
    *
    */
   public void setHint(String hintName, Serializable value) 
   {
      hints.put(hintName, value);
   }
   
   /**
    * Get the hints
    * @return The hints
    */
   public Map<String, Serializable> getHints() 
   {
      return hints;
   }
}
