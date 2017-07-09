package hr.fer.tel.ruazosa.evidencija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import hr.fer.tel.ruazosa.evidencija.entities.LabIthem;
import hr.fer.tel.ruazosa.evidencija.entities.Posudba;
import hr.fer.tel.ruazosa.evidencija.repositories.LabIthemRepository;
import hr.fer.tel.ruazosa.evidencija.repositories.PosudbaRepository;

@SpringBootApplication
public class EvidencijaApplication implements CommandLineRunner {
	@Autowired
	private LabIthemRepository repository;
	@Autowired
	private PosudbaRepository repositoryPosudba;

	public static void main(String[] args) {
		SpringApplication.run(EvidencijaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LabIthem ithem = new LabIthem("id_prvog", "11", "arduino", null, null, null, null, null, null, null, null);
		repository.save(ithem);

		ithem = new LabIthem("id_2", "22", "laptop", null, null, null, null, null, null, null, null);
		repository.save(ithem);


		ithem=new LabIthem("id_novi", "33", "mobitel", "KIT", "Opis", "Lokacija", "Available", "Uredjaj", "Tip", "Podtip", "Broj");
		repository.save(ithem);
		ithem=new LabIthem("id_najnoviji", "44", "mobitel", "KIT", "Opis", "Lokacija", "Unavailable", "Uredjaj", "Tip", "Podtip", "Broj");
		repository.save(ithem);
		ithem=new LabIthem("id_najnoviji1", "55", "mobitel", "KIT", "Opis", "Lokacija", "Reserved", "Uredjaj", "Tip", "Podtip", "Broj");
		repository.save(ithem);
		ithem=new LabIthem("id_najnoviji2", "66", "mobitel", "KIT", "Opis", "Lokacija", "Available", "Uredjaj", "Tip", "Podtip", "Broj");
		repository.save(ithem);

		Posudba posudba=new Posudba("id_2", "Kušek", "Protrka", "25.10.2016.", "30 dana");
		repositoryPosudba.save(posudba);
		posudba=new Posudba("id_prvog", "Krnić", "Matić", "06.07.2017.","14 dana");
		repositoryPosudba.save(posudba);
	}
}
