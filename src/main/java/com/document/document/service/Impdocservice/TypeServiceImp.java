package com.document.document.service.Impdocservice;

import com.document.document.domain.Type;
import com.document.document.repository.TypeRepository;
import com.document.document.service.docservice.TypeService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImp implements TypeService {

    private TypeRepository typeRepository;

    public TypeServiceImp(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type addServices(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public List<Type> listeType() {
        return typeRepository.findAll(Sort.by("idType").descending());
    }

    @Override
    public Type listeById(long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public Type UpdateType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public void deleteType(long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public boolean isTypeExist(long id) {
        return false;
    }

    @Override
    public Type VerificationType(String type) {
        return typeRepository.findBytypeDocs(type);
    }
}
