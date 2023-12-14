package com.pepsico.controller;

import java.util.Map;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.pepsico.model.CreateMenu;
import com.pepsico.model.CreateMenuItem;
import com.pepsico.model.Menu;
import com.pepsico.model.MenuItem;
import org.springframework.stereotype.Service;

@Service
public class V1ApiService implements V1ApiDelegate {
    private static Logger logger = LoggerFactory.getLogger(V1ApiService.class);
    Map<String, List<Menu>> menus = new Hashtable<>();

    public V1ApiService() {
        // dummy data
        List<Menu> firstlist = new ArrayList<>();
        Menu m = new Menu();
        m.setId(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        m.setName("Breakfast");
        m.setDescription("Breakfast Description...");

        m.createdDate(OffsetDateTime.now());
        m.setLastModifiedDate(OffsetDateTime.now());
        List<MenuItem> ml = new ArrayList<>();

        MenuItem menuItem1 = new MenuItem();
        menuItem1.id(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        menuItem1.name("Burrito Scram-Bowl");
        menuItem1.description("Creamy guacamole and fresh pico de gallo top off this hearty Mexican breakfast.");
        menuItem1.price(new BigDecimal("1.2"));
        menuItem1.currenncy("USD");
        menuItem1.createdDate(OffsetDateTime.now());
        menuItem1.setLastModifiedDate(OffsetDateTime.now());
        ml.add(menuItem1);
        MenuItem menuItem2 = new MenuItem();
        menuItem2.id(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        menuItem2.name("Harissa Scram-Bowl");
        menuItem2.description("Creamy guacamole and fresh pico de gallo top off this hearty Mexican breakfast.");
        menuItem2.price(new BigDecimal("0"));
        menuItem2.currenncy("USD");
        menuItem2.createdDate(OffsetDateTime.now());
        menuItem2.setLastModifiedDate(OffsetDateTime.now());
        ml.add(menuItem2);
        MenuItem menuItem3 = new MenuItem();
        menuItem3.id(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        menuItem3.name("Mediterranean Scram-Bowl");
        menuItem3.description("Creamy goat cheese, bright and tangy chimichurri with scrambled egg whites.");
        menuItem3.price(new BigDecimal("0.2"));
        menuItem3.currenncy("USD");
        menuItem3.createdDate(OffsetDateTime.now());
        menuItem3.setLastModifiedDate(OffsetDateTime.now());
        ml.add(menuItem3);
        MenuItem menuItem4 = new MenuItem();
        menuItem4.id(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        menuItem4.name("Multigrain Oatmeal");
        menuItem4.description("A blend of oatmeal, quinoa and flax to fuel your day");
        menuItem4.price(new BigDecimal("1.2"));
        menuItem4.currenncy("USD");
        menuItem4.createdDate(OffsetDateTime.now());
        menuItem4.setLastModifiedDate(OffsetDateTime.now());
        ml.add(menuItem4);
        m.setMenuitems(ml);
        
        
        // second menu
        Menu m1 = new Menu();
        m1.setId(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        m1.setName("Drink");
        m1.setDescription("Drink Description...");

        m1.createdDate(OffsetDateTime.now());
        m1.setLastModifiedDate(OffsetDateTime.now());
        List<MenuItem> mll = new ArrayList<>();

        MenuItem mi1 = new MenuItem();
        mi1.id(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        mi1.name("Cherry bubly");
        mi1.description("Unsweetened sparkling water with essence of sweet cherries.");
        mi1.price(new BigDecimal("1.2"));
        mi1.currenncy("USD");
        mi1.createdDate(OffsetDateTime.now());
        mi1.setLastModifiedDate(OffsetDateTime.now());
        mll.add(mi1);
        MenuItem mi2 = new MenuItem();
        mi2.id(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        mi2.name("Equator Fair Trade Organic Coffee");
        mi2.description("A dark roast coffee with hints of bittersweet chocolate and walnut.");
        mi2.price(new BigDecimal("0"));
        mi2.currenncy("USD");
        mi2.createdDate(OffsetDateTime.now());
        mi2.setLastModifiedDate(OffsetDateTime.now());
        mll.add(mi2);
        MenuItem mi3 = new MenuItem();
        mi3.id(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        mi3.name("Equator Fair Trade Organic Iced Coffee");
        mi3.description("Refreshing iced coffee with hints of bittersweet chocolate and a smooth finish.");
        mi3.price(new BigDecimal("0.2"));
        mi3.currenncy("USD");
        mi3.createdDate(OffsetDateTime.now());
        mi3.setLastModifiedDate(OffsetDateTime.now());
        mll.add(mi3);
        MenuItem mi4 = new MenuItem();
        mi4.id(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        mi4.name("Grapefruit bubly");
        mi4.description("Unsweetend sparkling water with hints of fresh grapefruit.");
        mi4.price(new BigDecimal("1.2"));
        mi4.currenncy("USD");
        mi4.createdDate(OffsetDateTime.now());
        mi4.setLastModifiedDate(OffsetDateTime.now());
        mll.add(mi4);
        m1.setMenuitems(ml);

        firstlist.add(m);
        firstlist.add(m1);
        menus.put("12345-test-id", firstlist);
    }

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

    public ResponseEntity<List<Menu>> getMenus(String customerId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"name\" : \"breakfast\", \"description\" : \"breakfast menu for XYZ\", \"id\" : \"ABCDabcd12345678\", \"menuitems\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 4.25, \"name\" : \"Pepsi Beverage\", \"description\" : \"Ice Cold 16 oz. Diet Pepsi Beverage\", \"id\" : \"ABCDabcd12345678\", \"currenncy\" : \"USD, CAD, etc.\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        List<Menu> m = menus.get(customerId);
        if (m == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(m);

    }

    private Menu convert(CreateMenu createMenu) {
        Menu m = new Menu();
        m.setId(AlphaNumericIDGenerator.generateAlphaNumericID(10));
        m.setName(createMenu.getName());
        m.setDescription(createMenu.getDescription());
        m.createdDate(OffsetDateTime.now());
        m.setLastModifiedDate(OffsetDateTime.now());
        List<MenuItem> ml = new ArrayList<>();
        for (CreateMenuItem mi : createMenu.getMenuitems()) {
            MenuItem o = new MenuItem();
            o.id(AlphaNumericIDGenerator.generateAlphaNumericID(10));
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
        o.id(AlphaNumericIDGenerator.generateAlphaNumericID(10));
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
        System.out.println("Searching for menu item " + id);
        for (String name : menus.keySet()) {
            List<Menu> ml = menus.get(name);
            for (Menu m : ml) {
                for (MenuItem mi : m.getMenuitems()) {
                    System.out.println("comparing " + mi.getId() + " with " + id);
                    if (mi.getId().equals(id)) {
                        CustomerMenu cm = new CustomerMenu();
                        cm.customerId = name;
                        cm.m = m;
                        cm.mi = mi;
                        return cm;
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
            if (x.getId().equals(menuItemId)) {
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
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
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
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
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
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
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

}
