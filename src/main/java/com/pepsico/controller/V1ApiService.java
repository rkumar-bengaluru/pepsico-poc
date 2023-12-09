package com.pepsico.controller;

import java.util.Map;
import java.util.UUID;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.pepsico.model.CreateMenu;
import com.pepsico.model.CreateMenuItem;
import com.pepsico.model.Menu;
import com.pepsico.model.MenuItem;

public class V1ApiService implements V1ApiDelegate {
    private static Logger logger = LoggerFactory.getLogger(V1ApiService.class);
    Map<String, List<Menu>> menus = new Hashtable<>();

    @Override
    public ResponseEntity<String> createMenu(String customerId,
            CreateMenu createMenu) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    logger.info("saving customer id " + customerId);
                    String exampleString = "\"ABCDabcd12345678\"";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        if (menus.containsKey(customerId) == false) {
            List<Menu> firstlist = new ArrayList<>();
            Menu m = convert(createMenu);
            logger.info("adding first menu " + m.getName() + " for customer " + customerId);
            firstlist.add(m);
            menus.put(customerId, firstlist);
        } else {
            Menu m = convert(createMenu);
            logger.info("adding menu " + m.getName() + " for customer " + customerId);

            menus.get(customerId).add(m);
        }
        return ResponseEntity.ok("customer id created successfully...");
    }

    private Menu convert(CreateMenu createMenu) {
        Menu m = new Menu();
        m.setId(UUID.randomUUID().toString());
        m.setName(createMenu.getName());
        m.setDescription(createMenu.getDescription());
        m.createdDate(OffsetDateTime.now());
        m.setLastModifiedDate(OffsetDateTime.now());
        List<MenuItem> ml = new ArrayList<>();
        for (CreateMenuItem mi : createMenu.getMenuitems()) {
            MenuItem o = new MenuItem();
            o.id(UUID.randomUUID().toString());
            o.name(mi.getName());
            o.description(mi.getDescription());
            o.price(mi.getPrice());
            o.currenncy(mi.getCurrenncy());
            o.createdDate(OffsetDateTime.now());
            o.setLastModifiedDate(OffsetDateTime.now());
            ml.add(o);
        }
        m.setMenuitems(ml);
        return m;
    }

    public ResponseEntity<String> createMenuItem(String menuId,
            CreateMenuItem mi) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "\"ABCDabcd12345678\"";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        CustomerMenu m = findMenuById(menuId);
        if (m == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MenuItem o = new MenuItem();
        o.id(UUID.randomUUID().toString());
        o.name(mi.getName());
        o.description(mi.getDescription());
        o.price(mi.getPrice());
        o.currenncy(mi.getCurrenncy());
        o.createdDate(OffsetDateTime.now());
        o.setLastModifiedDate(OffsetDateTime.now());
        m.m.getMenuitems().add(o);
        return ResponseEntity.ok("menu item created successfully " + o.getName());
    }

    class CustomerMenu {
        String customerId;
        Menu m;
        MenuItem mi;
    }

    private CustomerMenu findMenuById(String id) {
        for (String name : menus.keySet()) {
            List<Menu> ml = menus.get(name);
            for (Menu m : ml) {
                logger.info("comparing " + id + ", with " + m.getId());
                if (m.getId().equals(id)) {
                    CustomerMenu cm = new CustomerMenu();
                    cm.customerId = name;
                    cm.m = m;
                    return cm;
                }
            }
        }
        return null;
    }

    private CustomerMenu findMenuItemById(String id) {
        for (String name : menus.keySet()) {
            List<Menu> ml = menus.get(name);
            for (Menu m : ml) {
                for (MenuItem mi : m.getMenuitems()) {
                    if (mi.getId().equals(id)) {
                        CustomerMenu cm = new CustomerMenu();
                        cm.customerId = name;
                        cm.m = m;
                        cm.mi = mi;
                    }
                }
            }
        }
        return null;
    }

    public ResponseEntity<Void> deleteMenuById(String menuId) {
        CustomerMenu m = findMenuById(menuId);
        if (m == null || m.customerId == null || m.m == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       
        logger.info("removing menu " + m.m.getName() + ", from customer " + m.customerId);
        menus.get(m.customerId).remove(m.m);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> deleteMenuItemById(String menuItemId) {
        CustomerMenu m = findMenuItemById(menuItemId);
        if (m == null || m.customerId == null || m.m == null || m.mi == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MenuItem mi = null;
        for (MenuItem x : m.m.getMenuitems()) {
            if (x.getId() == menuItemId) {
                mi = x;
            }
        }
        if (mi == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("removing menu item " + mi.getName() + ", from menu " + m.m.getName());
        m.m.getMenuitems().remove(mi);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Menu> getMenuById(String menuId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"breakfast\", \"description\" : \"breakfast menu for XYZ\", \"id\" : \"ABCDabcd12345678\", \"menuitems\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        logger.info("searching for menu " + menuId);
        CustomerMenu m = findMenuById(menuId);
        if (m == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("returning menu " + m.m.getName());
        return ResponseEntity.ok(m.m);
    }

    public ResponseEntity<MenuItem> getMenuItemById(String menuItemId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        CustomerMenu m = findMenuItemById(menuItemId);
        if (m == null || m.customerId == null || m.m == null || m.mi == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(m.mi);

    }

    public ResponseEntity<List<MenuItem>> getMenuItems(String menuId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        CustomerMenu m = findMenuById(menuId);
        if (m == null || m.customerId == null || m.m == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(m.m.getMenuitems());
    }

    public ResponseEntity<List<Menu>> getMenus(String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"breakfast\", \"description\" : \"breakfast menu for XYZ\", \"id\" : \"ABCDabcd12345678\", \"menuitems\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        List<Menu> m = menus.get(customerId);
        if (m == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(m);

    }
}
