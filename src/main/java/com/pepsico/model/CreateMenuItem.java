package com.pepsico.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateMenuItem
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-09T11:41:14.532834100+05:30[Asia/Calcutta]")
public class CreateMenuItem   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("currenncy")
  private String currenncy;

  @JsonProperty("price")
  private BigDecimal price;

  public CreateMenuItem name(String name) {
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

  public CreateMenuItem description(String description) {
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

  public CreateMenuItem currenncy(String currenncy) {
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

  public CreateMenuItem price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * up to 2 decimal places, e.g. 4.25
   * @return price
  */
  @Schema(example = "4.25", description  = "up to 2 decimal places, e.g. 4.25")

  @Valid

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateMenuItem createMenuItem = (CreateMenuItem) o;
    return Objects.equals(this.name, createMenuItem.name) &&
        Objects.equals(this.description, createMenuItem.description) &&
        Objects.equals(this.currenncy, createMenuItem.currenncy) &&
        Objects.equals(this.price, createMenuItem.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, currenncy, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateMenuItem {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    currenncy: ").append(toIndentedString(currenncy)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

