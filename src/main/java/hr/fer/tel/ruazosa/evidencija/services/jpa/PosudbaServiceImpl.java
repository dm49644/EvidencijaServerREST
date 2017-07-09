package hr.fer.tel.ruazosa.evidencija.services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.fer.tel.ruazosa.evidencija.entities.Posudba;
import hr.fer.tel.ruazosa.evidencija.repositories.PosudbaRepository;
import hr.fer.tel.ruazosa.evidencija.services.PosudbaService;

/**
 * Created by Domagoj on 05/07/2017.
 */
@Service
public class PosudbaServiceImpl implements PosudbaService{

    @Autowired
    private PosudbaRepository repo;

    public PosudbaServiceImpl(PosudbaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Iterable<Posudba> findAll() {
        return repo.findAll();
    }

    @Override
    public Posudba getWithId(String id) {
        return repo.findOne(id);
    }

    @Override
    @Transactional
    public Posudba save(Posudba entity) {
        return repo.save(entity);
    }

    @Override
    @Transactional
    public void update(Posudba posudba) {
        if(repo.exists(posudba.getId())){
            repo.save(posudba);
        }
        else{
            throw new RuntimeException("Posudba ne postoji."); //ili se uopce ne smije mijenjati posudba
        }
    }

    @Override
    @Transactional
    public void delete(String id) {
        repo.delete(id); //mozda ovaj id treba i u klasi biti Long kao kod njih ne znam ak funkcionira sa stringom
    }
}
