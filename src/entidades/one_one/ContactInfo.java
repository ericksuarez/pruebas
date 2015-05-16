package entidades.one_one;


import java.io.Serializable;

import javax.jdo.annotations.*;

import com.google.appengine.api.datastore.Key;

	@PersistenceCapable
	public class ContactInfo implements Serializable{
	    @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Key key;

	    @Persistent
	    private String streetAddress;

		public ContactInfo(String streetAddress) {
			super();
			this.streetAddress = streetAddress;
		}

		public Key getKey() {
			return key;
		}

		public void setKey(Key key) {
			this.key = key;
		}

		public String getStreetAddress() {
			return streetAddress;
		}

		public void setStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
		}

	
}
