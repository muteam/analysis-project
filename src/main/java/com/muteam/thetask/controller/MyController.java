package com.muteam.thetask.controller;

import com.muteam.thetask.model.Musician;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.muteam.thetask.dao.*;

@Controller
public class MyController {

    MusicianRepository repository;

    public void setRepository(MusicianRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "api/musicians", method = RequestMethod.GET)
    @ResponseBody
    public List<Musician> list() {
        List<Musician> list = this.repository.list();
        return list;
    }

    @RequestMapping(value = "api/musicians", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String add(@RequestBody Musician musician) {
        this.repository.save(musician);
        return null;
    }

    @RequestMapping(value = "api/musicians/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Musician retrieve(@PathVariable String id) {
        Musician musician = this.repository.getById(id);
        return musician;
    }

    @RequestMapping(value = "api/musicians/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public String update(@RequestBody Musician musician) {
        this.repository.update(musician);
        return null;
    }

    @RequestMapping(value = "api/musicians/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public String delete(@PathVariable String id) {
        this.repository.delete(id);
        return null;
    }
}
