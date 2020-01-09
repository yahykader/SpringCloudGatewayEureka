package kader.org.FacturationService.model;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Facture {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date factureDate;
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long customerId;
	@Transient
	private Customer customer;
	//@Transient
	@OneToMany(mappedBy = "facture")
	private Collection<ProductItem> productItems;

	
}

