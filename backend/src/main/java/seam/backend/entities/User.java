package seam.backend.entities;

/*******************************************************************************
 * 2017, this is the user entity class ,
 * this class implements users details of the spring security framework
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Description of User.
 * 
 * @author selva
 */
/**
 * @author selva
 *
 */
@Entity
@Table(name = "User")
@Scope("session")
public class User implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum Role {
		USER
	}

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	private String role;

	private String fullName;

	public User() {

	}

	public User(String username, String password, String fullName) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
	}	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ",]";
	}

	
}
