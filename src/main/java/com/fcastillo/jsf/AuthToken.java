/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.jsf;

import javax.json.bind.annotation.JsonbProperty;

/**
 *
 * @author fcastillo
 */
public class AuthToken {

  @JsonbProperty("access_token")
  private String access_token;
  @JsonbProperty("token_type")
  private String token_type;
  @JsonbProperty("expires_in")
  private Long expires_in;
  @JsonbProperty("userName")
  private String userName;
  @JsonbProperty("issued")
  private String issued;
  @JsonbProperty("expired")
  private String expired;

  public AuthToken() {
  }

  public AuthToken(String access_token, String token_type, Long expires_in, String userName, String issued, String expired) {
    this.access_token = access_token;
    this.token_type = token_type;
    this.expires_in = expires_in;
    this.userName = userName;
    this.issued = issued;
    this.expired = expired;
  }

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }

  public String getToken_type() {
    return token_type;
  }

  public void setToken_type(String token_type) {
    this.token_type = token_type;
  }

  public Long getExpires_in() {
    return expires_in;
  }

  public void setExpires_in(Long expires_in) {
    this.expires_in = expires_in;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public String toString() {
    return "username: " + userName;
  }

  public String getIssued() {
    return issued;
  }

  public void setIssued(String issued) {
    this.issued = issued;
  }

  public String getExpired() {
    return expired;
  }

  public void setExpired(String expired) {
    this.expired = expired;
  }

}
