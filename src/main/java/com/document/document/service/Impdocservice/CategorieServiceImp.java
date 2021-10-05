package com.document.document.service.Impdocservice;

import com.document.document.domain.Categorie;
import com.document.document.repository.Verification.VerifiactionCategorie;
import com.document.document.repository.data.CategorieRepository;
import com.document.document.service.docservice.CategorieService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImp implements CategorieService {

    private CategorieRepository categorieRepository;
    private VerifiactionCategorie verifiactionCategorie;

    public CategorieServiceImp(CategorieRepository categorieRepository, VerifiactionCategorie verifiactionCategorie) {
        this.categorieRepository = categorieRepository;
        this.verifiactionCategorie = verifiactionCategorie;
    }

    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> listeCategorie() {
        return categorieRepository.findAll(Sort.by("idCategorie").descending());
    }

    @Override
    public Categorie listeById(long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public Categorie UpdateCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public boolean isCategorieExist(long id) {
        return verifiactionCategorie.isCategorieExist(id);
    }

    @Override
    public Categorie VerificationCategorie(String categorie) {
        return categorieRepository.findBycategorieDocs(categorie);
    }
}
