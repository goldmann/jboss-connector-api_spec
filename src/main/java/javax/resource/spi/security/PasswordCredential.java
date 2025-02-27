package javax.resource.spi.security;

import javax.resource.spi.ManagedConnectionFactory;

/**
 * The class PasswordCredential acts as a holder for username and
 * password.
 *
 * @see javax.resource.spi.ManagedConnectionFactory
 *
 * @author  Rahul Sharma
 * @version 0.6
 * @since   0.6
 */

public final class PasswordCredential implements java.io.Serializable 
{
   /** Serial version uid */
   private static final long serialVersionUID = -1770833344350711674L;

   private String userName;
   private char[] password;
   private ManagedConnectionFactory mcf;
   
   /**
    * Creates a new <code>PasswordCredential</code> object from the given
    * user name and password.
    *
    * <p> Note that the given user password is cloned before it is stored in
    * the new <code>PasswordCredential</code> object.
    *
    * @param userName the user name
    * @param password the user's password
    **/
   public PasswordCredential(String userName, char[] password) 
   {
      this.userName = userName;
      this.password = (char[])password.clone();
   }

   /**
    * Returns the user name.
    *
    * @return the user name
    **/
   public String getUserName() 
   {
      return userName;
   }
   
   /**
    * Returns the user password.
    *
    * <p> Note that this method returns a reference to the password. It is
    * the caller's responsibility to zero out the password information after
    * it is no longer needed.
    *
    * @return the password
    **/
   public char[] getPassword() 
   {
      return password;
   }

   /** Gets the target ManagedConnectionFactory for which the user name and 
    *  password has been set by the application server. A ManagedConnection-
    *  Factory uses this field to find out whether PasswordCredential should
    *  be used by it for sign-on to the target EIS instance.
    *
    *  @return    ManagedConnectionFactory instance for which user name and
    *             password have been specified
    **/
   public ManagedConnectionFactory getManagedConnectionFactory() 
   {
      return mcf;
   }

   /**  Sets the target ManagedConenctionFactory instance for which the user 
    *   name and password has been set by the application server.
    *
    *  @param     mcf   ManagedConnectionFactory instance for which user name
    *                   and password have been specified
    **/
   public void setManagedConnectionFactory(ManagedConnectionFactory mcf) 
   {
      this.mcf = mcf;
   }
   
   /** Compares this PasswordCredential with the specified object for 
    *  equality. The two PasswordCredential instances are the same if
    *  they are equal in username and password.
    *
    *  @param other  Object to which PasswordCredential is to be compared
    *  @return <tt>true</tt> if and if the specified object is a
    *            PasswordCredential whose username and password are
    *            equal to this instance.
    **/
   public boolean equals(Object other) 
   {
      if (!(other instanceof PasswordCredential))
         return false;
      
      PasswordCredential pc = (PasswordCredential)other;
      
      if (!(userName.equals(pc.userName)))
         return false;
      
      if (password.length != pc.password.length)
         return false;
      
      for (int i = 0; i < password.length; i++) 
      {
         if (password[i] != pc.password[i]) 
            return false;
      }

      return true;
   }
   
   /** Returns the hash code for this PasswordCredential
    * 
    *  @return  hash code for this PasswordCredential
    **/
   public int hashCode() 
   {
      String s = userName;
      s += new String(password);
      return s.hashCode();
   }
}
