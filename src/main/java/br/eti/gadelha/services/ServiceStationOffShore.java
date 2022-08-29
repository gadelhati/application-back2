package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestStationOffShore;
import br.eti.gadelha.persistence.dto.response.DTOResponseStationOffShore;
import br.eti.gadelha.persistence.model.unity.StationOffShore;
import br.eti.gadelha.persistence.repository.RepositoryStationOffShore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceStationOffShore {

    private final RepositoryStationOffShore repository;

    public ServiceStationOffShore(RepositoryStationOffShore repository) {
        this.repository = repository;
    }

    public DTOResponseStationOffShore create(DTORequestStationOffShore created){
        return DTOResponseStationOffShore.toDTO(repository.save(created.toObject()));
    }
    public DTOResponseStationOffShore retrieve(UUID id){
        return DTOResponseStationOffShore.toDTO(repository.findById(id).orElse(null));
    }
    public List<DTOResponseStationOffShore> retrieve(){
        List<DTOResponseStationOffShore> list = new ArrayList<>();
        for(StationOffShore object: repository.findAll()) {
            list.add(DTOResponseStationOffShore.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseStationOffShore> retrieve(Pageable pageable){
        List<DTOResponseStationOffShore> list = new ArrayList<>();
        for(StationOffShore object: repository.findAll()) {
            list.add(DTOResponseStationOffShore.toDTO(object));
        }
        return new PageImpl<DTOResponseStationOffShore>(list, pageable, list.size());
    }
    public Page<DTOResponseStationOffShore> retrieve(Pageable pageable, String source){
        final List<DTOResponseStationOffShore> list = new ArrayList<>();
        if (source == null) {
            for (StationOffShore object : repository.findAll()) {
                list.add(DTOResponseStationOffShore.toDTO(object));
            }
        } else {
//            for (StationOffShore object : repository.findByLatitudeMostBottomContainingIgnoreCaseOrderByLatitudeMostBottomAsc(source)) {
//                list.add(DTOResponseStationOffShore.toDTO(object));
//            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseStationOffShore update(UUID id, DTORequestStationOffShore updated){
        StationOffShore object = repository.findById(id).orElse(null);
        object.setLocalDepth(updated.getLocalDepth());
        object.setCom(updated.getCom());
        object.setCommission(updated.getCommission());
        object.setStationCategory(updated.getStationCategory());
        object.setCountry(updated.getCountry());
        object.setEquipment(updated.getEquipment());
        object.setSurveying(updated.getSurveying());
        object.setResponsible(updated.getResponsible());
        object.setCountry(updated.getCountry());
        object.setFirst(updated.getFirst());
        object.setLast(updated.getLast());
        object.setLatitudeMostBottom(updated.getLatitudeMostBottom());
        object.setLatitudeMostTop(updated.getLatitudeMostTop());
        object.setLongitudeMostLeft(updated.getLongitudeMostLeft());
        object.setLongitudeMostRight(updated.getLongitudeMostRight());
        object.setPlatform(updated.getPlatform());
        return DTOResponseStationOffShore.toDTO(repository.save(object));
    }
    public DTOResponseStationOffShore delete(UUID id){
        StationOffShore object = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return DTOResponseStationOffShore.toDTO(object);
    }
    public void delete() {
        repository.deleteAll();
    }

//    public StationOffShore findByLatitudeMostBottom(Double value) { return  repository.findByLatitudeMostBottom(value); }
}