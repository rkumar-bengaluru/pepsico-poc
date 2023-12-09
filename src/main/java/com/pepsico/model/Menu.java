package com.pepsico.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.pepsico.model.MenuItem;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Menu
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-09T11:41:14.532834100+05:30[Asia/Calcutta]")
public class Menu   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("menuitems")
  @Valid
  private List<MenuItem> menuitems = null;

  @JsonProperty("createdDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdDate;

  @JsonProperty("lastModifiedDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastModifiedDate;

  public Menu id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Schema(example = "ABCDabcd12345678", description = "")

@Pattern(regexp = "^[A-Za-z0-9]{16}$") 
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Menu name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name identifying the Menu
   * @return name
  */
  @Schema(example = "breakfast", description = "Name identifying the Menu")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Menu description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Full description of the menu
   * @return description
  */
  @Schema(example = "breakfast menu for XYZ", description = "Full description of the menu")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Menu menuitems(List<MenuItem> menuitems) {
    this.menuitems = menuitems;
    return this;
  }

  public Menu addMenuitemsItem(MenuItem menuitemsItem) {
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
  @Schema(description = "")

  @Valid

  public List<MenuItem> getMenuitems() {
    return menuitems;
  }

  public void setMenuitems(List<MenuItem> menuitems) {
    this.menuitems = menuitems;
  }

  public Menu createdDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
  */
  @Schema(description = "")

  @Valid

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public Menu lastModifiedDate(OffsetDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
    return this;
  }

  /**
   * Get lastModifiedDate
   * @return lastModifiedDate
  */
  @Schema(description = "")

  @Valid

  public OffsetDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Menu menu = (Menu) o;
    return Objects.equals(this.id, menu.id) &&
        Objects.equals(this.name, menu.name) &&
        Objects.equals(this.description, menu.description) &&
        Objects.equals(this.menuitems, menu.menuitems) &&
        Objects.equals(this.createdDate, menu.createdDate) &&
        Objects.equals(this.lastModifiedDate, menu.lastModifiedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, menuitems, createdDate, lastModifiedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Menu {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    menuitems: ").append(toIndentedString(menuitems)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    lastModifiedDate: ").append(toIndentedString(lastModifiedDate)).append("\n");
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

