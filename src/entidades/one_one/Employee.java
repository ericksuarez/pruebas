package entidades.one_one;


import java.io.Serializable;

import javax.jdo.annotations.*;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable
public class Employee implements Serializable{
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long key;
    @Persistent
    private String nombre;
    @Persistent
    private String apellido;
    
    @Persistent
    private ContactInfo contactInfo;

    public Employee(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
    
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public ContactInfo getContactInfo() {
        return contactInfo;
    }
	public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
    
    
}

