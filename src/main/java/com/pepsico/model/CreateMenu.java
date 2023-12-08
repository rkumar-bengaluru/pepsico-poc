package com.pepsico.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateMenu
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-08T12:58:27.435673+05:30[Asia/Calcutta]")
public class CreateMenu   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("menuitems")
  @Valid
  private List<CreateMenuItem> menuitems = null;

  public CreateMenu name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the menu
   * @return name
  */



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateMenu description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Full description of the menu
   * @return description
  */



  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreateMenu menuitems(List<CreateMenuItem> menuitems) {
    this.menuitems = menuitems;
    return this;
  }

  public CreateMenu addMenuitemsItem(CreateMenuItem menuitemsItem) {
    if (this.menuitems == null) {
      this.menuitems = new ArrayList<>();
    }
    this.menuitems.add(menuitemsItem);
    return this;
  }

  /**
   * Get menuitems
   * @return menuitems
  */


  @Valid

  public List<CreateMenuItem> getMenuitems() {
    return menuitems;
  }

  public void setMenuitems(List<CreateMenuItem> menuitems) {
    this.menuitems = menuitems;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateMenu createMenu = (CreateMenu) o;
    return Objects.equals(this.name, createMenu.name) &&
        Objects.equals(this.description, createMenu.description) &&
        Objects.equals(this.menuitems, createMenu.menuitems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, menuitems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateMenu {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    menuitems: ").append(toIndentedString(menuitems)).append("\n");
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

