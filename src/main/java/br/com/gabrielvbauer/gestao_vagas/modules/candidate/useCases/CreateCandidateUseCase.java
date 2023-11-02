package br.com.gabrielvbauer.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielvbauer.gestao_vagas.exceptions.UserAlreadyExistsException;
import br.com.gabrielvbauer.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.gabrielvbauer.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class CreateCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository
      .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
      .ifPresent((user) -> {
        throw new UserAlreadyExistsException();
      });
        
    return this.candidateRepository.save(candidateEntity);
  }
}
