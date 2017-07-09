package hr.fer.tel.ruazosa.evidencija.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import hr.fer.tel.ruazosa.evidencija.entities.Posudba;

/**
 * Created by Domagoj on 05/07/2017.
 */
public interface PosudbaRepository extends CrudRepository<Posudba, String> {
}
