package hr.fer.tel.ruazosa.evidencija.controllers;

import com.sun.jndi.toolkit.url.Uri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import hr.fer.tel.ruazosa.evidencija.entities.LabIthem;
import hr.fer.tel.ruazosa.evidencija.representations.LabIthemResource;
import hr.fer.tel.ruazosa.evidencija.services.LabIthemService;

/**
 * Created by dorotea on 05.07.17..
 */

@RequestMapping(value = "/api/labIthems")
@RestController
public class LabIthemController {
    private LabIthemService service;
    private LabIthemAssembler liAssembler;

    @Autowired
    public LabIthemController(LabIthemService service, LabIthemAssembler liAssembler) {
        this.service = service;
        this.liAssembler = liAssembler;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LabIthem getLabIthem(@PathVariable(value = "id") String id){
        LabIthem ithem = service.getWithId(id);
        if(ithem != null) {
            return ithem;
        }
        throw new ResourceNotFoundException("Lab ithem does not exist.");
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<LabIthemResource> getLabIthems(){
        return liAssembler.toLabItemResourceList(service.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity newLabItem(@RequestBody LabIthem item){
        service.save(item);

        URI uri = linkTo(methodOn(LabIthemController.class).getLabIthem(item.getId())).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateLabItem(@PathVariable("id") String id, @RequestBody LabIthem item){
        try{
            service.update(item);
            return ResponseEntity.noContent().build();
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                    .eTag(e.getMessage())
                    .build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLabItem(@PathVariable("id") String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}