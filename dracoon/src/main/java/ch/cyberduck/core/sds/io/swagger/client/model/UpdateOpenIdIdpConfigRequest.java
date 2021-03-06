/*
 * DRACOON
 * REST Web Services for DRACOON<br>Version: 4.8.0-LTS  - built at: 2018-05-03 15:44:37<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a>
 *
 * OpenAPI spec version: 4.8.0-LTS
 * Contact: develop@dracoon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

/*
 * Copyright (c) 2002-2018 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * UpdateOpenIdIdpConfigRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-23T09:31:14.222+02:00")
public class UpdateOpenIdIdpConfigRequest {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("issuer")
  private String issuer = null;

  @JsonProperty("authorizationEndPointUrl")
  private String authorizationEndPointUrl = null;

  @JsonProperty("tokenEndPointUrl")
  private String tokenEndPointUrl = null;

  @JsonProperty("userInfoEndPointUrl")
  private String userInfoEndPointUrl = null;

  @JsonProperty("jwksEndPointUrl")
  private String jwksEndPointUrl = null;

  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("clientSecret")
  private String clientSecret = null;

  @JsonProperty("scopes")
  private List<String> scopes = null;

  @JsonProperty("redirectUris")
  private List<String> redirectUris = null;

  @JsonProperty("pkceEnabled")
  private Boolean pkceEnabled = null;

  @JsonProperty("pkceChallengeMethod")
  private String pkceChallengeMethod = null;

  @JsonProperty("mappingClaim")
  private String mappingClaim = null;

  @JsonProperty("fallbackMappingClaim")
  private String fallbackMappingClaim = null;

  @JsonProperty("userUpdateEnabled")
  private Boolean userUpdateEnabled = null;

  @JsonProperty("resetFallbackMappingClaim")
  private Boolean resetFallbackMappingClaim = null;

  public UpdateOpenIdIdpConfigRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the IDP
   * @return name
  **/
  @ApiModelProperty(value = "Name of the IDP")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateOpenIdIdpConfigRequest issuer(String issuer) {
    this.issuer = issuer;
    return this;
  }

   /**
   * Issuer identifier of the IDP The value is a case sensitive URL.
   * @return issuer
  **/
  @ApiModelProperty(example = "https://www.random-url.com", value = "Issuer identifier of the IDP The value is a case sensitive URL.")
  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public UpdateOpenIdIdpConfigRequest authorizationEndPointUrl(String authorizationEndPointUrl) {
    this.authorizationEndPointUrl = authorizationEndPointUrl;
    return this;
  }

   /**
   * URL of the authorization endpoint
   * @return authorizationEndPointUrl
  **/
  @ApiModelProperty(example = "https://www.random-url.com", value = "URL of the authorization endpoint")
  public String getAuthorizationEndPointUrl() {
    return authorizationEndPointUrl;
  }

  public void setAuthorizationEndPointUrl(String authorizationEndPointUrl) {
    this.authorizationEndPointUrl = authorizationEndPointUrl;
  }

  public UpdateOpenIdIdpConfigRequest tokenEndPointUrl(String tokenEndPointUrl) {
    this.tokenEndPointUrl = tokenEndPointUrl;
    return this;
  }

   /**
   * URL of the token endpoint
   * @return tokenEndPointUrl
  **/
  @ApiModelProperty(example = "https://www.random-url.com", value = "URL of the token endpoint")
  public String getTokenEndPointUrl() {
    return tokenEndPointUrl;
  }

  public void setTokenEndPointUrl(String tokenEndPointUrl) {
    this.tokenEndPointUrl = tokenEndPointUrl;
  }

  public UpdateOpenIdIdpConfigRequest userInfoEndPointUrl(String userInfoEndPointUrl) {
    this.userInfoEndPointUrl = userInfoEndPointUrl;
    return this;
  }

   /**
   * URL of the user info endpoint
   * @return userInfoEndPointUrl
  **/
  @ApiModelProperty(example = "https://www.random-url.com", value = "URL of the user info endpoint")
  public String getUserInfoEndPointUrl() {
    return userInfoEndPointUrl;
  }

  public void setUserInfoEndPointUrl(String userInfoEndPointUrl) {
    this.userInfoEndPointUrl = userInfoEndPointUrl;
  }

  public UpdateOpenIdIdpConfigRequest jwksEndPointUrl(String jwksEndPointUrl) {
    this.jwksEndPointUrl = jwksEndPointUrl;
    return this;
  }

   /**
   * URL of the JWKS endpoint
   * @return jwksEndPointUrl
  **/
  @ApiModelProperty(example = "https://www.random-url.com", value = "URL of the JWKS endpoint")
  public String getJwksEndPointUrl() {
    return jwksEndPointUrl;
  }

  public void setJwksEndPointUrl(String jwksEndPointUrl) {
    this.jwksEndPointUrl = jwksEndPointUrl;
  }

  public UpdateOpenIdIdpConfigRequest clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

   /**
   * ID of the OAuth client
   * @return clientId
  **/
  @ApiModelProperty(value = "ID of the OAuth client")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public UpdateOpenIdIdpConfigRequest clientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
    return this;
  }

   /**
   * Secret, which client uses at authentication.
   * @return clientSecret
  **/
  @ApiModelProperty(value = "Secret, which client uses at authentication.")
  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public UpdateOpenIdIdpConfigRequest scopes(List<String> scopes) {
    this.scopes = scopes;
    return this;
  }

  public UpdateOpenIdIdpConfigRequest addScopesItem(String scopesItem) {
    if (this.scopes == null) {
      this.scopes = new ArrayList<String>();
    }
    this.scopes.add(scopesItem);
    return this;
  }

   /**
   * List of requested scopes Usually &#x60;openid&#x60; and the names of the requested claims.
   * @return scopes
  **/
  @ApiModelProperty(value = "List of requested scopes Usually `openid` and the names of the requested claims.")
  public List<String> getScopes() {
    return scopes;
  }

  public void setScopes(List<String> scopes) {
    this.scopes = scopes;
  }

  public UpdateOpenIdIdpConfigRequest redirectUris(List<String> redirectUris) {
    this.redirectUris = redirectUris;
    return this;
  }

  public UpdateOpenIdIdpConfigRequest addRedirectUrisItem(String redirectUrisItem) {
    if (this.redirectUris == null) {
      this.redirectUris = new ArrayList<String>();
    }
    this.redirectUris.add(redirectUrisItem);
    return this;
  }

   /**
   * URIs, to which a user is redirected after authorization.
   * @return redirectUris
  **/
  @ApiModelProperty(value = "URIs, to which a user is redirected after authorization.")
  public List<String> getRedirectUris() {
    return redirectUris;
  }

  public void setRedirectUris(List<String> redirectUris) {
    this.redirectUris = redirectUris;
  }

  public UpdateOpenIdIdpConfigRequest pkceEnabled(Boolean pkceEnabled) {
    this.pkceEnabled = pkceEnabled;
    return this;
  }

   /**
   * Determines whether PKCE is enabled. cf. [RFC 7636](https://tools.ietf.org/html/rfc7636) (default: false)
   * @return pkceEnabled
  **/
  @ApiModelProperty(example = "false", value = "Determines whether PKCE is enabled. cf. [RFC 7636](https://tools.ietf.org/html/rfc7636) (default: false)")
  public Boolean getPkceEnabled() {
    return pkceEnabled;
  }

  public void setPkceEnabled(Boolean pkceEnabled) {
    this.pkceEnabled = pkceEnabled;
  }

  public UpdateOpenIdIdpConfigRequest pkceChallengeMethod(String pkceChallengeMethod) {
    this.pkceChallengeMethod = pkceChallengeMethod;
    return this;
  }

   /**
   * PKCE code challenge method. cf. [RFC 7636](https://tools.ietf.org/html/rfc7636)
   * @return pkceChallengeMethod
  **/
  @ApiModelProperty(value = "PKCE code challenge method. cf. [RFC 7636](https://tools.ietf.org/html/rfc7636)")
  public String getPkceChallengeMethod() {
    return pkceChallengeMethod;
  }

  public void setPkceChallengeMethod(String pkceChallengeMethod) {
    this.pkceChallengeMethod = pkceChallengeMethod;
  }

  public UpdateOpenIdIdpConfigRequest mappingClaim(String mappingClaim) {
    this.mappingClaim = mappingClaim;
    return this;
  }

   /**
   * Name of the claim which is used for the user mapping.
   * @return mappingClaim
  **/
  @ApiModelProperty(example = "email", value = "Name of the claim which is used for the user mapping.")
  public String getMappingClaim() {
    return mappingClaim;
  }

  public void setMappingClaim(String mappingClaim) {
    this.mappingClaim = mappingClaim;
  }

  public UpdateOpenIdIdpConfigRequest fallbackMappingClaim(String fallbackMappingClaim) {
    this.fallbackMappingClaim = fallbackMappingClaim;
    return this;
  }

   /**
   * Name of the claim which is used for the user mapping fallback.
   * @return fallbackMappingClaim
  **/
  @ApiModelProperty(example = "sub", value = "Name of the claim which is used for the user mapping fallback.")
  public String getFallbackMappingClaim() {
    return fallbackMappingClaim;
  }

  public void setFallbackMappingClaim(String fallbackMappingClaim) {
    this.fallbackMappingClaim = fallbackMappingClaim;
  }

  public UpdateOpenIdIdpConfigRequest userUpdateEnabled(Boolean userUpdateEnabled) {
    this.userUpdateEnabled = userUpdateEnabled;
    return this;
  }

   /**
   * Determines if the user metadata is updated with data from the IDP. The scope &#x60;profile&#x60; is needed for the update. If this scope is not granted, only the email address is updated. (default: false)
   * @return userUpdateEnabled
  **/
  @ApiModelProperty(example = "false", value = "Determines if the user metadata is updated with data from the IDP. The scope `profile` is needed for the update. If this scope is not granted, only the email address is updated. (default: false)")
  public Boolean getUserUpdateEnabled() {
    return userUpdateEnabled;
  }

  public void setUserUpdateEnabled(Boolean userUpdateEnabled) {
    this.userUpdateEnabled = userUpdateEnabled;
  }

  public UpdateOpenIdIdpConfigRequest resetFallbackMappingClaim(Boolean resetFallbackMappingClaim) {
    this.resetFallbackMappingClaim = resetFallbackMappingClaim;
    return this;
  }

   /**
   * Set &#x60;true&#x60; to reset &#x60;fallbackMappingClaim&#x60;.
   * @return resetFallbackMappingClaim
  **/
  @ApiModelProperty(example = "false", value = "Set `true` to reset `fallbackMappingClaim`.")
  public Boolean getResetFallbackMappingClaim() {
    return resetFallbackMappingClaim;
  }

  public void setResetFallbackMappingClaim(Boolean resetFallbackMappingClaim) {
    this.resetFallbackMappingClaim = resetFallbackMappingClaim;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateOpenIdIdpConfigRequest updateOpenIdIdpConfigRequest = (UpdateOpenIdIdpConfigRequest) o;
    return Objects.equals(this.name, updateOpenIdIdpConfigRequest.name) &&
        Objects.equals(this.issuer, updateOpenIdIdpConfigRequest.issuer) &&
        Objects.equals(this.authorizationEndPointUrl, updateOpenIdIdpConfigRequest.authorizationEndPointUrl) &&
        Objects.equals(this.tokenEndPointUrl, updateOpenIdIdpConfigRequest.tokenEndPointUrl) &&
        Objects.equals(this.userInfoEndPointUrl, updateOpenIdIdpConfigRequest.userInfoEndPointUrl) &&
        Objects.equals(this.jwksEndPointUrl, updateOpenIdIdpConfigRequest.jwksEndPointUrl) &&
        Objects.equals(this.clientId, updateOpenIdIdpConfigRequest.clientId) &&
        Objects.equals(this.clientSecret, updateOpenIdIdpConfigRequest.clientSecret) &&
        Objects.equals(this.scopes, updateOpenIdIdpConfigRequest.scopes) &&
        Objects.equals(this.redirectUris, updateOpenIdIdpConfigRequest.redirectUris) &&
        Objects.equals(this.pkceEnabled, updateOpenIdIdpConfigRequest.pkceEnabled) &&
        Objects.equals(this.pkceChallengeMethod, updateOpenIdIdpConfigRequest.pkceChallengeMethod) &&
        Objects.equals(this.mappingClaim, updateOpenIdIdpConfigRequest.mappingClaim) &&
        Objects.equals(this.fallbackMappingClaim, updateOpenIdIdpConfigRequest.fallbackMappingClaim) &&
        Objects.equals(this.userUpdateEnabled, updateOpenIdIdpConfigRequest.userUpdateEnabled) &&
        Objects.equals(this.resetFallbackMappingClaim, updateOpenIdIdpConfigRequest.resetFallbackMappingClaim);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, issuer, authorizationEndPointUrl, tokenEndPointUrl, userInfoEndPointUrl, jwksEndPointUrl, clientId, clientSecret, scopes, redirectUris, pkceEnabled, pkceChallengeMethod, mappingClaim, fallbackMappingClaim, userUpdateEnabled, resetFallbackMappingClaim);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateOpenIdIdpConfigRequest {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
    sb.append("    authorizationEndPointUrl: ").append(toIndentedString(authorizationEndPointUrl)).append("\n");
    sb.append("    tokenEndPointUrl: ").append(toIndentedString(tokenEndPointUrl)).append("\n");
    sb.append("    userInfoEndPointUrl: ").append(toIndentedString(userInfoEndPointUrl)).append("\n");
    sb.append("    jwksEndPointUrl: ").append(toIndentedString(jwksEndPointUrl)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientSecret: ").append(toIndentedString(clientSecret)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
    sb.append("    redirectUris: ").append(toIndentedString(redirectUris)).append("\n");
    sb.append("    pkceEnabled: ").append(toIndentedString(pkceEnabled)).append("\n");
    sb.append("    pkceChallengeMethod: ").append(toIndentedString(pkceChallengeMethod)).append("\n");
    sb.append("    mappingClaim: ").append(toIndentedString(mappingClaim)).append("\n");
    sb.append("    fallbackMappingClaim: ").append(toIndentedString(fallbackMappingClaim)).append("\n");
    sb.append("    userUpdateEnabled: ").append(toIndentedString(userUpdateEnabled)).append("\n");
    sb.append("    resetFallbackMappingClaim: ").append(toIndentedString(resetFallbackMappingClaim)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

