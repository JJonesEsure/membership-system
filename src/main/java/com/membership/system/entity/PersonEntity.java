package com.membership.system.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

/**
 * This is the account entity,
 * it is the structure of the data.
 * @author Jacob Jones
 *
 */
@Entity
@Getter
@Setter
@Table(name="person")
public class PersonEntity implements UserDetails {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final List<GrantedAuthority>
    AUTHORITIES = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = true)
    private LocalDateTime dateOfBirth;
    
    @Column(nullable = true)
    private String title;
    
    @Column(nullable = true)
    private String email;
    
    @Column(nullable = true)
    private String sex;
    
    @Column(nullable = true)
    private String maritalStatus;
    
    @Column(nullable = true)
    private String occupation;
    
    @Column(nullable = false, name = "user_name")
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public List<String> getRoles() {
        return AUTHORITIES.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }
    
    @Override
    public Collection<? extends GrantedAuthority>
    getAuthorities() {
        return AUTHORITIES;
    }
    
     /**
     * Returns {@code true} if the supplied object is a {@code User} instance with the
     * same {@code username} value.
     * <p>
     * In other words, the objects are equal if they have the same username, representing
     * the same principal.
     */
    @Override
    public boolean equals(Object rhs) {
        if (rhs instanceof User) {
            return username.equals(((User) rhs).getUsername());
        }
        return false;
    }
    
    /**
     * Returns the hashcode of the {@code username}.
     */
    @Override
    public int hashCode() {
        return username.hashCode();
    }
    
    @Override
    public String toString() {
        return String.format(
                "PersonEntity [personId=%s, firstName=%s, lastName=%s, dateOfBirth=%s, title=%s, email=%s, sex=%s, maritalStatus=%s, occupation=%s, username=%s, password=%s]", personId, firstName, lastName, dateOfBirth, title, email, sex, maritalStatus, occupation, username, "*******");
    }
    
}