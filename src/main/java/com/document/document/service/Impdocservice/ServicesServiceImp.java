package com.document.document.service.Impdocservice;

import com.document.document.domain.Services;
import com.document.document.repository.Verification.VerifiactionService;
import com.document.document.repository.data.ServicesRepository;
import com.document.document.service.docservice.ServicesService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImp implements ServicesService {

    private ServicesRepository servicesRepository;
    private VerifiactionService verifiactionService;

    public ServicesServiceImp(ServicesRepository servicesRepository, VerifiactionService verifiactionService) {
        this.servicesRepository = servicesRepository;
        this.verifiactionService = verifiactionService;
    }

    @Override
    public Services addServices(Services services) {
        return servicesRepository.save(services);
    }

    @Override
    public List<Services> listeServices() {
        return servicesRepository.findAll(Sort.by("idService").descending());
    }

    @Override
    public Services listeById(long id) {
        return servicesRepository.findById(id).get();
    }

    @Override
    public Services UpdateServices(Services services) {
        return servicesRepository.save(services);
    }

    @Override
    public void deleteServices(long id) {
        servicesRepository.deleteById(id);
    }

    @Override
    public boolean isServicesExist(long id) {
        return verifiactionService.isServiceExist(id);
    }

    @Override
    public Services VerificationServices(String email) {
        return servicesRepository.findByemailService(email);
    }
}
