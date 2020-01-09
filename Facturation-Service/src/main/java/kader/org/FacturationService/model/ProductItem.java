package kader.org.FacturationService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ProductItem {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long productId;
	@Transient
	private Product product;
	private double quantity;
	private double price;		
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Facture facture;

}	
