package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestResearcher;
import br.eti.gadelha.persistence.payload.response.DTOResponseResearcher;
import br.eti.gadelha.persistence.repository.RepositoryResearcher;
import br.eti.gadelha.services.ServiceResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController @RequestMapping("/researcher")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerResearcher implements ControllerInterface<DTOResponseResearcher, DTORequestResearcher> {

    @Autowired
    private final ServiceResearcher serviceResearcher;

    public ControllerResearcher(RepositoryResearcher repository) {
        this.serviceResearcher = new ServiceResearcher(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> create(@RequestBody @Valid DTORequestResearcher created){
        try {
            return new ResponseEntity<>(serviceResearcher.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseResearcher> retrieve(){
        return serviceResearcher.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseResearcher>> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceResearcher.retrieve(pageable), HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceResearcher.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseResearcher>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceResearcher.retrieve(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestResearcher updated){
        try {
            return new ResponseEntity<>(serviceResearcher.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceResearcher.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceResearcher.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}