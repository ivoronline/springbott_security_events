package com.ivoronline.springbott_security_events.config;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationListener {

  //======================================================================================
  // METHOD: LISTEN TO SUCCESS
  //======================================================================================
  @EventListener
  public void listenToSuccess(AuthenticationSuccessEvent event){

    //GET USERNAME
    UsernamePasswordAuthenticationToken token    = (UsernamePasswordAuthenticationToken) event.getSource();
    User                                user     = (User) token.getPrincipal();
    String                              username = user.getUsername();

    //GET IP
    WebAuthenticationDetails details = (WebAuthenticationDetails) token.getDetails();
    String                   IP      = details.getRemoteAddress();

    //LOG DATA
    System.out.println("Successful Login by Username/IP: " + username + "/" + IP);

  }

  //======================================================================================
  // METHOD: LISTEN TO FAILURE
  //======================================================================================
  @EventListener
  public void listenToFailure(AuthenticationFailureBadCredentialsEvent event){

    //GET USERNAME
    UsernamePasswordAuthenticationToken token    = (UsernamePasswordAuthenticationToken) event.getSource();
    String                              username = (String) token.getPrincipal();

    //GET IP
    WebAuthenticationDetails details = (WebAuthenticationDetails) token.getDetails();
    String                   IP      = details.getRemoteAddress();

    //LOG DATA
    System.out.println("Unsuccessful Login by Username/IP: " + username + "/" + IP);

  }

}