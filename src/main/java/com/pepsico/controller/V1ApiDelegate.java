package com.pepsico.controller;

import com.pepsico.model.CreateMenu;
import com.pepsico.model.CreateMenuItem;
import com.pepsico.model.Menu;
import com.pepsico.model.MenuItem;
import com.pepsico.model.ModelApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import java.util.Optional;

/**
 * A delegate to be called by the {@link V1ApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-09T11:41:14.532834100+05:30[Asia/Calcutta]")
public interface V1ApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /v1/menus : Adds a new menu to the given customer
     * Adds a new menu to the given customer
     *
     * @param customerId specific customerId that the menu belongs to (required)
     * @param createMenu  (optional)
     * @return successful operation (status code 200)
     *         or Invalid customerId or menu value (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or No customer exists for the given customerId (status code 404)
     * @see V1Api#createMenu
     */
    default ResponseEntity<String> createMenu(String customerId,
        CreateMenu createMenu) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "\"ABCDabcd12345678\"";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /v1/menuItems : Adds a new menuItem to the given Menu
     * Adds a new menuItem to the given Menu
     *
     * @param menuId specific menu id that the menuitem belongs to (required)
     * @param createMenuItem MenuItem object that needs to be added to the menu (optional)
     * @return successful operation (status code 200)
     *         or Invalid menuId or menuItem value (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or No menu exists for the given menuId (status code 404)
     * @see V1Api#createMenuItem
     */
    default ResponseEntity<String> createMenuItem(String menuId,
        CreateMenuItem createMenuItem) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "\"ABCDabcd12345678\"";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /v1/menus/{menuId} : Delete a menu by ID
     * Deletes the specified menu using its ID.
     *
     * @param menuId ID of menu to be deleted (required)
     * @return No Content. The item was successfully deleted. (status code 204)
     *         or Not Found. The item with the specified ID was not found. (status code 404)
     *         or Internal Server Error. An error occurred during the operation. (status code 500)
     * @see V1Api#deleteMenuById
     */
    default ResponseEntity<Void> deleteMenuById(String menuId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /v1/menuItems/{menuItemId} : Delete a minuItem by ID
     * Deletes the specified menuItem using its ID.
     *
     * @param menuItemId ID of menuItem to be deleted (required)
     * @return No Content. The item was successfully deleted. (status code 204)
     *         or Not Found. The item with the specified ID was not found. (status code 404)
     *         or Internal Server Error. An error occurred during the operation. (status code 500)
     * @see V1Api#deleteMenuItemById
     */
    default ResponseEntity<Void> deleteMenuItemById(String menuItemId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /v1/menus/{menuId} : Find menu by ID
     * Returns a single menu
     *
     * @param menuId ID of menu to return (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Menu not found (status code 404)
     * @see V1Api#getMenuById
     */
    default ResponseEntity<Menu> getMenuById(String menuId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"breakfast\", \"description\" : \"breakfast menu for XYZ\", \"id\" : \"ABCDabcd12345678\", \"menuitems\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
         Menu m = new Menu();
        m.setId("ABCDabcd12345678");
        m.setName("breakfast");
        m.setDescription("breakfast menu for XYZ");
        m.createdDate(OffsetDateTime.now());
        m.setLastModifiedDate(OffsetDateTime.now());
        
        
        m.setMenuitems(getDummyData());
        
        return ResponseEntity.ok(m);

    }
    public default List<MenuItem> getDummyData() {
        List<MenuItem> ml = new java.util.ArrayList<>();
        for (int i =0; i < 10; i++) {
            MenuItem o = new MenuItem();
            o.id("ABCDabcd12345678" + i);
            o.name("Pepsi Beverage");
            o.description("Ice Cold 16 oz. Diet Pepsi Beverage");
            o.price( new BigDecimal("4.25"));
            o.currenncy("USD");
            o.createdDate(OffsetDateTime.now());
            o.setLastModifiedDate(OffsetDateTime.now());
            ml.add(o);
        }
        return ml;
    }

    /**
     * GET /v1/menuItems/{menuItemId} : Find menu item by ID
     * Returns a single menu item
     *
     * @param menuItemId ID of menuItem to return (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Menu not found (status code 404)
     * @see V1Api#getMenuItemById
     */
    default ResponseEntity<MenuItem> getMenuItemById(String menuItemId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /v1/menuItems : Get menuItems for a given menu
     * Get menu items for a given menu
     *
     * @param menuId specific menu id that the menuitems belongs to (required)
     * @return successful operation (status code 200)
     *         or Invalid menuId value (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or No menuitems found for the given menuId (status code 404)
     * @see V1Api#getMenuItems
     */
    default ResponseEntity<List<MenuItem>> getMenuItems(String menuId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /v1/menus : Get menus for a given customer
     * Get menus for a given customer
     *
     * @param customerId specific customer id that the menu belongs to (required)
     * @return successful operation (status code 200)
     *         or Invalid customerId value (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or No menu found for the given customerId (status code 404)
     * @see V1Api#getMenus
     */
    default ResponseEntity<List<Menu>> getMenus(String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"breakfast\", \"description\" : \"breakfast menu for XYZ\", \"id\" : \"ABCDabcd12345678\", \"menuitems\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /v1/menuItems/{menuItemId}/uploadImage : uploads an image for the Menu Item
     *
     * @param menuItemId ID of menuItem to update (required)
     * @param body  (optional)
     * @return successful operation (status code 200)
     * @see V1Api#uploadFile
     */
    default ResponseEntity<ModelApiResponse> uploadFile(Long menuItemId,
        MultipartFile body) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"type\" : \"type\", \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /v1/menus/{menuId}/uploadImage : uploads an image for the overall Menu
     *
     * @param menuId ID of menu to update (required)
     * @param body  (optional)
     * @return successful operation (status code 200)
     * @see V1Api#uploadMenuFile
     */
    default ResponseEntity<ModelApiResponse> uploadMenuFile(String menuId,
        MultipartFile body) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"type\" : \"type\", \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
