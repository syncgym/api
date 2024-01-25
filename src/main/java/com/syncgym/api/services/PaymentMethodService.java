package com.syncgym.api.services;

import com.syncgym.api.data.dto.v1.PaymentMethodDTOV1;
import com.syncgym.api.exceptions.DuplicateResourceException;
import com.syncgym.api.exceptions.RegistrationFailedException;
import com.syncgym.api.exceptions.ResourceNotFoundException;
import com.syncgym.api.mapper.Mapper;
import com.syncgym.api.models.PaymentMethod;
import com.syncgym.api.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PaymentMethodService {

    Logger logger = Logger.getLogger(PaymentMethodService.class.getName());

    @Autowired
    PaymentMethodRepository repository;

    public ResponseEntity<List<PaymentMethodDTOV1>> findAll() {
        var dtos = Mapper.parseListObjects(repository.findAll(), PaymentMethodDTOV1.class);

        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity<?> findById(long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PaymentMethod not found"));

        var dto = Mapper.parseObject(entity, PaymentMethodDTOV1.class);

        return ResponseEntity.ok(dto);
    }

    public ResponseEntity<?> create(PaymentMethodDTOV1 dto) {
        if (Objects.isNull(dto)) {
            throw new RegistrationFailedException("Creation failed - PaymentMethod is null");
        }

        try {
            var foundPaymentMethod = findById(dto.getId());
            if (!Objects.isNull(foundPaymentMethod)) {
                throw new DuplicateResourceException("Creation failed - duplicated PaymentMethod");
            }

            repository.save(Mapper.parseObject(dto, PaymentMethod.class));

            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch (DuplicateResourceException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    public ResponseEntity<?> update(PaymentMethodDTOV1 dto) {
        if (Objects.isNull(dto)) {
            throw new IllegalArgumentException("Grade to update is null");
        }

        var foundPaymentMethod = findById(dto.getId());
        if (Objects.isNull(foundPaymentMethod)) {
            throw new ResourceNotFoundException("Update failed - PaymentMethod not found");
        }

        repository.save(Mapper.parseObject(dto, PaymentMethod.class));

        return ResponseEntity.ok(dto);
    }
}
