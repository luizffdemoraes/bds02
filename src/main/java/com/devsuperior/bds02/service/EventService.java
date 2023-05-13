package com.devsuperior.bds02.service;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.exception.ResourceNotFoundException;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        try {
            Event entity = eventRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = eventRepository.save(entity);
            return new EventDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Event does not exist!");
        }

    }

    private void copyDtoToEntity(EventDTO dto, Event entity) {
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        entity.setCity(cityRepository.getOne(dto.getCityId()));
    }
}
