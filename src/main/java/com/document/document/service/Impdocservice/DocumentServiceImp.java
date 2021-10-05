package com.document.document.service.Impdocservice;

import com.document.document.domain.Document;
import com.document.document.repository.Verification.VerifiactionDocument;
import com.document.document.repository.data.DocumentRepository;
import com.document.document.service.docservice.DocumentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DocumentServiceImp implements DocumentService {

    private DocumentRepository documentRepository;
    private VerifiactionDocument verifiactionDocument;

    public DocumentServiceImp(DocumentRepository documentRepository, VerifiactionDocument verifiactionDocument) {
        this.documentRepository = documentRepository;
        this.verifiactionDocument = verifiactionDocument;
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
    public List<Document> rechercheByCritere(long idC, long idN, long idT) {
        return documentRepository.findByCategorieIdCategorieAndNatureIdNatureAndTypeIdType(idC,idN,idT);

    }

    @Override
    public boolean isDocumentExist(long id) {
        return verifiactionDocument.isDocumentExist(id);
    }

    @Override
    public Document VerificationDocument(String reference) {
        return documentRepository.findByreferenceDocument(reference);
    }
}
