package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.exception.enumeration.ERole;
import br.eti.gadelha.persistence.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class DTOResponseRole {

    private ERole name;

    public static DTOResponseRole toDTO(Role value) {
        return new DTOResponseRole(value.getName());
    }
}