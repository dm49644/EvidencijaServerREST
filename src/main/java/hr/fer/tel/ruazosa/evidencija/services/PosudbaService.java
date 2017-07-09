package hr.fer.tel.ruazosa.evidencija.services;

import hr.fer.tel.ruazosa.evidencija.entities.Posudba;

/**
 * Created by Domagoj on 05/07/2017.
 */

public interface PosudbaService {
    public Iterable<Posudba> findAll();
    public Posudba getWithId(String id);
    public Posudba save(Posudba convertToEntity);
    public void update(Posudba posudba);
    public void delete(String id);
}
