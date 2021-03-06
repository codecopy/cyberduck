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
 * MissingKeysResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-23T09:31:14.222+02:00")
public class MissingKeysResponse {
  @JsonProperty("range")
  private Range range = null;

  @JsonProperty("items")
  private List<UserIdFileIdItem> items = null;

  @JsonProperty("users")
  private List<UserUserPublicKey> users = null;

  @JsonProperty("files")
  private List<FileFileKeys> files = null;

  public MissingKeysResponse range(Range range) {
    this.range = range;
    return this;
  }

   /**
   * Range
   * @return range
  **/
  @ApiModelProperty(value = "Range")
  public Range getRange() {
    return range;
  }

  public void setRange(Range range) {
    this.range = range;
  }

  public MissingKeysResponse items(List<UserIdFileIdItem> items) {
    this.items = items;
    return this;
  }

  public MissingKeysResponse addItemsItem(UserIdFileIdItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<UserIdFileIdItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * List of user ID and file ID mappings
   * @return items
  **/
  @ApiModelProperty(value = "List of user ID and file ID mappings")
  public List<UserIdFileIdItem> getItems() {
    return items;
  }

  public void setItems(List<UserIdFileIdItem> items) {
    this.items = items;
  }

  public MissingKeysResponse users(List<UserUserPublicKey> users) {
    this.users = users;
    return this;
  }

  public MissingKeysResponse addUsersItem(UserUserPublicKey usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<UserUserPublicKey>();
    }
    this.users.add(usersItem);
    return this;
  }

   /**
   * List of user public keys
   * @return users
  **/
  @ApiModelProperty(value = "List of user public keys")
  public List<UserUserPublicKey> getUsers() {
    return users;
  }

  public void setUsers(List<UserUserPublicKey> users) {
    this.users = users;
  }

  public MissingKeysResponse files(List<FileFileKeys> files) {
    this.files = files;
    return this;
  }

  public MissingKeysResponse addFilesItem(FileFileKeys filesItem) {
    if (this.files == null) {
      this.files = new ArrayList<FileFileKeys>();
    }
    this.files.add(filesItem);
    return this;
  }

   /**
   * List of file keys
   * @return files
  **/
  @ApiModelProperty(value = "List of file keys")
  public List<FileFileKeys> getFiles() {
    return files;
  }

  public void setFiles(List<FileFileKeys> files) {
    this.files = files;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MissingKeysResponse missingKeysResponse = (MissingKeysResponse) o;
    return Objects.equals(this.range, missingKeysResponse.range) &&
        Objects.equals(this.items, missingKeysResponse.items) &&
        Objects.equals(this.users, missingKeysResponse.users) &&
        Objects.equals(this.files, missingKeysResponse.files);
  }

  @Override
  public int hashCode() {
    return Objects.hash(range, items, users, files);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MissingKeysResponse {\n");

    sb.append("    range: ").append(toIndentedString(range)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
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

