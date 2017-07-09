package hr.fer.tel.ruazosa.evidencija.controllers;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import hr.fer.tel.ruazosa.evidencija.entities.LabIthem;
import hr.fer.tel.ruazosa.evidencija.representations.LabIthemResource;

/**
 * Created by dorotea on 05.07.17..
 */

@Service
public class LabIthemAssembler {

    public LabIthemResource toResource(LabIthem labIthem){
        LabIthemResource lir = new LabIthemResource();

        //BeanUtils se koristi isto za kopiranje
        lir.setId(labIthem.getId());
        lir.setKit(labIthem.getKit());
        lir.setDescription(labIthem.getDescription());

        return lir;
    }

    public List<LabIthemResource> toLabItemResourceList(Iterable<LabIthem> items){
        List<LabIthemResource> lrList = new LinkedList<>();

        for(LabIthem item : items){
            LabIthemResource lir = new LabIthemResource();
            lir.setId(item.getId());
            lir.setKit(item.getKit());
            lir.setDescription(item.getDescription());

            lrList.add(lir);
        }

        return lrList;
    }
}