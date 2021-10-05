package com.document.document.service.Impdocservice;

import com.document.document.domain.Nature;
import com.document.document.repository.Verification.VerifiactionNature;
import com.document.document.repository.data.NatureRepository;
import com.document.document.service.docservice.NatureService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatureServiceImp implements NatureService {

    private NatureRepository natureRepository;
    private VerifiactionNature verifiactionNature;

    public NatureServiceImp(NatureRepository natureRepository, VerifiactionNature verifiactionNature) {
        this.natureRepository = natureRepository;
        this.verifiactionNature = verifiactionNature;
    }

    @Override
    public Nature addNature(Nature nature) {
        return natureRepository.save(nature);
    }

    @Override
    public List<Nature> listeNature() {
        return natureRepository.findAll(Sort.by("idNature").descending());
    }

    @Override
    public Nature listeById(long id) {
        return natureRepository.findById(id).get();
    }

    @Override
    public Nature UpdateNature(Nature nature) {
        return natureRepository.save(nature);
    }

    @Override
    public void deleteNature(long id) {
        natureRepository.deleteById(id);
    }

    @Override
    public boolean isNatureExist(long id) {
        return verifiactionNature.isNatureExist(id);
    }

    @Override
    public Nature VerificationNature(String nature) {
        return natureRepository.findBynatureDocs(nature);
    }
}
