package com.estore.api.estoreapi.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class User extends org.springframework.security.core.userdetails.User {

  @JsonProperty("id")
  private Integer id;

  /**
   * To make authority to be serialized properly we convert it to list of strings
   * so the constructor uses Collection of Strings
   * 
   * @param id
   * @param username
   * @param password
   * @param enabled
   * @param accountNonExpired
   * @param credentialsNonExpired
   * @param accountNonLocked
   * @param authorities
   * @param cart
   * @param totalCost
   */
  @JsonCreator
  public User(
      @JsonProperty("id") int id,
      @JsonProperty("username") String username,
      @JsonProperty("password") String password,
      @JsonProperty("enabled") boolean enabled,
      @JsonProperty("accountNonExpired") boolean accountNonExpired,
      @JsonProperty("credentialsNonExpired") boolean credentialsNonExpired,
      @JsonProperty("accountNonLocked") boolean accountNonLocked,
      @JsonProperty("authorities") Collection<String> authorities,
      @JsonProperty("totalCost") int totalCost) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
        authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    this.id = id;

  }

  public User(int id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, true, true, true, true, authorities);
    this.id = id;
  }

  @JsonGetter("id")
  public Integer getId() {
    return id;
  }

  @JsonSetter("id")
  public void setId(Integer id) {
    this.id = id;
  }

  @JsonGetter("authorities")
  public Collection<String> getAuthoritiesAsString() {
    return getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof User) {
      User other = (User) o;
      return (this.id == other.id);
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + getUsername() + ", password=" + getPassword() + ", enabled=" + isEnabled()
        + ", accountNonExpired=" + isAccountNonExpired() + ", credentialsNonExpired=" + isCredentialsNonExpired()
        + ", accountNonLocked=" + isAccountNonLocked() + ", authorities=" + getAuthoritiesAsString() + "]";
  }
}
