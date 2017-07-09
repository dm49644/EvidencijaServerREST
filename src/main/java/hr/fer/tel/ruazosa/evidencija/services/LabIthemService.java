package hr.fer.tel.ruazosa.evidencija.services;

import hr.fer.tel.ruazosa.evidencija.entities.LabIthem;

/**
 * Created by dorotea on 05.07.17..
 */

public interface LabIthemService {

    public Iterable<LabIthem> findAll();
    public LabIthem getWithId(String id);
    public LabIthem save(LabIthem convertToEntity);
    public void update(LabIthem labIthem);
    public void delete(String id);
}
