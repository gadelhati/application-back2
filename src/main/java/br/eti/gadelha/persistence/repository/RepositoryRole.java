package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryRole extends JpaRepository<Role, UUID> {
//    List<Role> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    boolean existsByName(String value);
}