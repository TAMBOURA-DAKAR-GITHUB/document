package com.document.document.service.Impdocservice;

import com.document.document.domain.Document;
import com.document.document.repository.DocumentRepository;
import com.document.document.service.docservice.DocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImp implements DocumentService {

    private DocumentRepository documentRepository;

    public DocumentServiceImp(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Document> listeDocument() {
        return documentRepository.findAll();
    }

    @Override
    public Document listeById(long id) {
        return documentRepository.findById(id).get();
    }

    @Override
    public Document UpdateDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public void deleteDocument(long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public Document rechercheByCritere(long idC, long idN, long idT) {
        return documentRepository.findByCategorieIdCategorieAndNatureIdNatureAndTypeIdType(idC,idN,idT);

    }

    @Override
    public boolean isDocumentExist(long id) {
        return false;
    }

    @Override
    public Document VerificationDocument(String reference) {
        return documentRepository.findByreferenceDocument(reference);
    }
}
