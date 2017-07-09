package hr.fer.tel.ruazosa.evidencija.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import javax.websocket.server.PathParam;

import hr.fer.tel.ruazosa.evidencija.entities.Posudba;
import hr.fer.tel.ruazosa.evidencija.services.PosudbaService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by Domagoj on 06/07/2017.
 */
@RestController
@RequestMapping(value = "/api/posudbas")
public class PosudbaController {
    @Autowired
    PosudbaService ps;

    public PosudbaController(PosudbaService ps) {
        this.ps = ps;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Posudba getPosudba(@PathVariable(value="id") String id){
        Posudba posudba=ps.getWithId(id);
        if(posudba!=null) return posudba;
        else throw new ResourceNotFoundException("Posudba ne postoji.");
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Posudba> getPosudbas(){
        List<Posudba> list=new LinkedList<Posudba>();
        Iterable<Posudba> pos=ps.findAll();
        for(Posudba posudba:pos){
            list.add(posudba);
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity newPosudba(@RequestBody Posudba posudba){
        ps.save(posudba);
        URI uri=linkTo(methodOn(PosudbaController.class).getPosudba(posudba.getId())).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity updatePosudba(@PathVariable("id") String id, @RequestBody Posudba posudba){
        try{
            posudba.setId(id);
            ps.update(posudba);
            return ResponseEntity.noContent().build();
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).eTag(e.getMessage()).build();
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePosudba(@PathVariable("id") String id){
        ps.delete(id);
        return ResponseEntity.noContent().build();
    }
}
