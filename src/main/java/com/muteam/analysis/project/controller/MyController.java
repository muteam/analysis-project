package com.muteam.analysis.project.controller;

import com.muteam.analysis.project.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.muteam.analysis.project.dao.*;

@Controller
public class MyController {

    ProductRepository repository;

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "api/products", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> list() {
        List<Product> list = this.repository.list();
        return list;
    }

    @RequestMapping(value = "api/products", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String add(@RequestBody Product product) {
        this.repository.save(product);
        return null;
    }

    @RequestMapping(value = "api/products/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product retrieve(@PathVariable String id) {
        Product product = this.repository.getById(id);
        return product;
    }

    @RequestMapping(value = "api/products/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public String update(@RequestBody Product product) {
        this.repository.update(product);
        return null;
    }

    @RequestMapping(value = "api/products/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public String delete(@PathVariable String id) {
        this.repository.delete(id);
        return null;
    }
}
