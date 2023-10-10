package com.empresa.postgresqlspringbootjwt05032023.services;

import com.empresa.postgresqlspringbootjwt05032023.models.Expert;
import com.empresa.postgresqlspringbootjwt05032023.responses.ExpertResponse;
import com.empresa.postgresqlspringbootjwt05032023.repositories.ExpertRepository;

public class ExpertService {

    ExpertRepository expertRepository = new ExpertRepository();

    public ExpertResponse index() {
        return expertRepository.findAll();
    }

    public ExpertResponse store(Expert expert) {
        return expertRepository.save(expert);
    }
}