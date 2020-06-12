package com.ehb.examen.Controller;


import com.ehb.examen.Model.*;
//import jdk.vm.ci.meta.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class IndexController {
    @Autowired
    PersoonDao daoPersoon;
    @Autowired
    ProductDao daoProduct;
    @Autowired
    BodDao daoBod;
    @RequestMapping(value = "/products", method= RequestMethod.GET)
    @ResponseBody
    public Iterable<Product> getAllProduct(){
        return daoProduct.findAll();
    }

    @RequestMapping(value = "/users/new", method= RequestMethod.POST)
    @ResponseBody
    public void ccreateUser (@RequestParam(value = "firsname") String firstName,
                             @RequestParam(value = "lastname") String lastName,
                             @RequestParam(value = "email") String email){
        Persoon persoon = new Persoon(firstName, lastName, email);
        daoPersoon.save(persoon);
    }
    @RequestMapping(value = "/products/new", method= RequestMethod.POST)
    @ResponseBody
    public void ccreateProduct (@RequestParam(value = "naam") String naam,
                                @RequestParam(value = "date") String dateTxt,
                                @RequestParam(value = "prijs") int prijs) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateTxt, formatter);
        Product product = new Product(naam, prijs, dateTime);
        daoProduct.save(product);
    }

    @RequestMapping(value = "/products{userId}", method= RequestMethod.GET)
    @ResponseBody
    public Iterable<Product> getAllProductByPersoonId(@PathVariable(value = "userId") int id){
        return daoPersoon.getProductByPersoonId(id);
    }

    @RequestMapping(value = "/bids/new", method= RequestMethod.POST)
    @ResponseBody
    public void createBid(@RequestParam(value = "prodId") int producId,
                          @RequestParam(value = "prijs") int prijs){
        Product getProd = daoProduct.getProductById(producId);
        int prodPrijs = getProd.getStartprijs();
        LocalDateTime prodDate = getProd.getDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentDate = new Date();
//geen tijd gehad om tijd te formatteren

        if(prijs > prodPrijs && currentDate.before(prodDate)){
            Bod bod = new Bod(prijs, getProd);
            daoBod.save(bod);
    }



}
