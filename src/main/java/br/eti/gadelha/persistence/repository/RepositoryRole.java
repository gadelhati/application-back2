package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryRole extends JpaRepository<Role, UUID>, RepositoryInterface<Role> {

}