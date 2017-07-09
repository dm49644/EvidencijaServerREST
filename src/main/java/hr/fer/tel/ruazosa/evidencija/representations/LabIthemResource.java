package hr.fer.tel.ruazosa.evidencija.representations;

import hr.fer.tel.ruazosa.evidencija.entities.LabIthem;

/**
 * Created by dorotea on 05.07.17..
 */

public class LabIthemResource {

    private String id;
    private String kit;
    private String description;

    public LabIthemResource(){

    }

    public LabIthemResource(String id, String kit, String description) {
        this.id = id;
        this.kit = kit;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getKit() {
        return kit;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKit(String kit) {
        this.kit = kit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LabIthemResource{" +
                "id='" + id + '\'' +
                ", kit='" + kit + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
