package kader.org.FacturationService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import kader.org.FacturationService.model.ProductItem;
@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long>{	
	List<ProductItem> findByFactureId(Long factureId);
}
