/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.jsf.controller;

import com.fcastillo.jsf.Credencial;
import com.fcastillo.jsf.servicio.AuthenticationService;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fcastillo
 */
@Named(value = "authenticationController")
@ViewScoped
public class AuthenticationController implements Serializable {

  @Inject
  private AuthenticationService authenticationService;

  private Credencial credencial = new Credencial();

  public void login() {
    authenticationService.login(credencial);
  }

  public Credencial getCredencial() {
    return credencial;
  }

  public void setCredencial(Credencial credencial) {
    this.credencial = credencial;
  }

}
