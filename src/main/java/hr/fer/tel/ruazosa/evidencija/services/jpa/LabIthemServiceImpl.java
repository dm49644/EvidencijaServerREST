package hr.fer.tel.ruazosa.evidencija.services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.fer.tel.ruazosa.evidencija.entities.LabIthem;
import hr.fer.tel.ruazosa.evidencija.repositories.LabIthemRepository;
import hr.fer.tel.ruazosa.evidencija.services.LabIthemService;

/**
 * Created by dorotea on 05.07.17..
 */

@Service
public class LabIthemServiceImpl implements LabIthemService {
    @Autowired
    private LabIthemRepository repository;

    public LabIthemServiceImpl(LabIthemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<LabIthem> findAll() {
        return repository.findAll();
    }

    @Override
    public LabIthem getWithId(String id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public LabIthem save(LabIthem labIthem) {
        return repository.save(labIthem);
    }

    @Override
    @Transactional
    public void update(LabIthem labIthem) {
        LabIthem oldIthem = repository.findOne(labIthem.getId());
        if(oldIthem == null){
            throw new IllegalArgumentException(
                    "Ithem does not exist.");
        }
        repository.save(labIthem);
    }

    @Override
    @Transactional
    public void delete(String id){
        repository.delete(id);
    }
}
