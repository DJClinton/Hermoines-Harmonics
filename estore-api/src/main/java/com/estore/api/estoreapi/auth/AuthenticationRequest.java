package com.estore.api.estoreapi.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
  @JsonProperty("email")
  private String email;
  @JsonProperty("password")
  private String password;

  public AuthenticationRequest(@JsonProperty("email") String email, @JsonProperty("password") String password) {
    this.email = email;
    this.password = password;
  }
}
