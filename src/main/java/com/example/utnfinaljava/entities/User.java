package com.example.utnfinaljava.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class User implements UserDetails {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "nombre_usuario")
    public String nombreUsuario;
    @Column(name = "email")
    public String email;
    @Column(name = "clave")
    public String clave;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private List<UserRole> roles = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role : getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
        }
        return authorities;
    }
    @Override
    public String getPassword() {
        return clave;
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    } 
}
