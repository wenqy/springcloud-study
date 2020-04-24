package com.wenqy.oauth2.resource;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(
  classes = OAuth2SsoAsymJwtResourceApplication.class, 
  webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthenticationClaimsIntegrationTest {
 
    @Autowired
    private JwtTokenStore tokenStore;
 
    @Test
    public void whenTokenDoesNotContainIssuer_thenSuccess() {
        String tokenValue = obtainAccessToken("sheep1", "admin", "123456");
        System.out.println("token:" + tokenValue);
        OAuth2Authentication auth = tokenStore.readAuthentication(tokenValue);
//        Map<String, Object> details = (Map<String, Object>) auth.getDetails();
//        assertTrue(details.containsKey("organization"));
        assertTrue("admin".equals(auth.getPrincipal()));
    }
 
    private String obtainAccessToken(
      String clientId, String username, String password) {
  
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("client_secret", "123456");
        params.put("username", username);
        params.put("password", password);
        Response response = RestAssured.given()
          .auth().preemptive()
          .basic(clientId, "123456")
          .and().with().params(params).when()
          .post("http://localhost:58084/oauth/token");
        return response.jsonPath().getString("access_token");
    }
}
