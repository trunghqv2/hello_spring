package com.trung.indentity_service.service;

import com.trung.indentity_service.dto.request.PremissionRequest;
import com.trung.indentity_service.dto.response.PremissionResponse;
import com.trung.indentity_service.dto.response.PremissiontResponse;
import com.trung.indentity_service.entity.Premission;
import com.trung.indentity_service.mapper.PremissionMapper;
import com.trung.indentity_service.repository.PremissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class PremissionService {
    PremissionRepository premissionRepository;
    PremissionMapper premissionMapper;

     public PremissionResponse create(PremissionRequest request) {
        Premission premission = premissionMapper.toPremission(request);
        premission = premissionRepository.save(premission);
        return premissionMapper.toPremissionResponse(premission);
    }

    public List<PremissionResponse> getAll() {
        var premissions = premissionRepository.findAll();
        return premissions.stream().map(premissionMapper::toPremissionResponse);
    }

    public  void delete(String premission) {
        premissionRepository.deleteById(premission);
    }
}
