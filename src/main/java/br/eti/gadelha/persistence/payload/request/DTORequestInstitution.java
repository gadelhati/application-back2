package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.unity.Institution;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestInstitution {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Country country;

    public Institution toObject(){
        return new Institution(name, country);
    }
}