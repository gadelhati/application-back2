package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.unity.Equipment;
import br.eti.gadelha.persistence.model.unity.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseEquipment {

    private UUID id;
    private String name;
    private Manufacturer manufacturer;

    public static DTOResponseEquipment toDTO(Equipment value) {
        return new DTOResponseEquipment(value.getId(), value.getName(), value.getManufacturer());
    }
}