package kader.org.FacturationService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
//@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ProductItem {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Long productId;
	@Transient
	private Product product;
	private double quantity;
	private double price;		
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Facture facture;
	
	
	public ProductItem() {
		// TODO Auto-generated constructor stub
	}
	public ProductItem(Long id, Long productId, Product product, double quantity, double price, Facture facture) {
		super();
		this.id = id;
		this.productId = productId;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.facture = facture;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public double getQuantity() {
		return quantity;
	}


	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Facture getFacture() {
		return facture;
	}


	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	


}	
