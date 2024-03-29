package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.unity.Manufacturer;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestManufacturer {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;

    public Manufacturer toObject(){
        return new Manufacturer(name);
    }
}