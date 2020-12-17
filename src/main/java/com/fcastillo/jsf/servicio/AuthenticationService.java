package com.fcastillo.jsf.servicio;

import com.fcastillo.jsf.AuthToken;
import javax.ejb.Stateless;
import com.fcastillo.jsf.Credencial;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Stateless
public class AuthenticationService {

  private static final String BASE_PATH = "https://urlexample/";
  private static final Logger logger = Logger.getLogger(AuthenticationService.class.getName());

  public void login(Credencial credencial) {
    Jsonb jsonb = JsonbBuilder.create();

    MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();

    formData.add("username", credencial.getUsername());
    formData.add("password", credencial.getPassword());
    formData.add("grant_type", "password");

    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(BASE_PATH).path("example");

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.post(Entity.entity(formData, MediaType.APPLICATION_FORM_URLENCODED));

    String readEntity = response.readEntity(String.class);
    AuthToken authToken = jsonb.fromJson(readEntity, AuthToken.class);
    JsonbConfig config = new JsonbConfig().withFormatting(Boolean.TRUE);

    jsonb = JsonbBuilder.create(config);
    String employeeJson = jsonb.toJson(authToken);
    logger.log(Level.INFO, "JSON constructed from Employee object:{0}", employeeJson);

  }

}
