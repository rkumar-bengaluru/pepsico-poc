package com.pepsico.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MenuItem
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-09T11:41:14.532834100+05:30[Asia/Calcutta]")
public class MenuItem   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("currenncy")
  private String currenncy;

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("createdDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdDate;

  @JsonProperty("lastModifiedDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastModifiedDate;

  public MenuItem id(String id) {
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

  public MenuItem name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the menu item
   * @return name
  */
  @Schema(example = "Pepsi Beverage", description = "Name of the menu item")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MenuItem description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Full description of the menu item
   * @return description
  */
  @Schema(example = "Ice Cold 16 oz. Diet Pepsi Beverage", description = "Full description of the menu item")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MenuItem currenncy(String currenncy) {
    this.currenncy = currenncy;
    return this;
  }

  /**
   * Currency for the specified pice
   * @return currenncy
  */
  @Schema(example = "USD, CAD, etc.", description = "Currency for the specified pice")


  public String getCurrenncy() {
    return currenncy;
  }

  public void setCurrenncy(String currenncy) {
    this.currenncy = currenncy;
  }

  public MenuItem price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * up to 2 decimal places, e.g. 4.25
   * @return price
  */
  @Schema(example = "4.25", description = "up to 2 decimal places, e.g. 4.25")

  @Valid

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public MenuItem createdDate(OffsetDateTime createdDate) {
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

  public MenuItem lastModifiedDate(OffsetDateTime lastModifiedDate) {
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
    MenuItem menuItem = (MenuItem) o;
    return Objects.equals(this.id, menuItem.id) &&
        Objects.equals(this.name, menuItem.name) &&
        Objects.equals(this.description, menuItem.description) &&
        Objects.equals(this.currenncy, menuItem.currenncy) &&
        Objects.equals(this.price, menuItem.price) &&
        Objects.equals(this.createdDate, menuItem.createdDate) &&
        Objects.equals(this.lastModifiedDate, menuItem.lastModifiedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, currenncy, price, createdDate, lastModifiedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MenuItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    currenncy: ").append(toIndentedString(currenncy)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

