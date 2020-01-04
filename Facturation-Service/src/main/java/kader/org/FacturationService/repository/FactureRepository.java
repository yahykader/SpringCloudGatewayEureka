package kader.org.FacturationService.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import kader.org.FacturationService.model.Facture;
@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture, Long>{

}
