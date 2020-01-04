package kader.org.FacturationService.model;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
//@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Facture {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date factureDate;
	private Long personneId;
	@Transient
	private Personne customer;
	@OneToMany(mappedBy = "facture")
	private Collection<ProductItem> productItems;
	
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture(Long id, Date factureDate, Long personneId, Personne customer,
			Collection<ProductItem> productItems) {
		super();
		this.id = id;
		this.factureDate = factureDate;
		this.personneId = personneId;
		this.customer = customer;
		this.productItems = productItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFactureDate() {
		return factureDate;
	}

	public void setFactureDate(Date factureDate) {
		this.factureDate = factureDate;
	}

	public Long getPersonneId() {
		return personneId;
	}

	public void setPersonneId(Long personneId) {
		this.personneId = personneId;
	}

	public Personne getCustomer() {
		return customer;
	}

	public void setCustomer(Personne customer) {
		this.customer = customer;
	}

	public Collection<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(Collection<ProductItem> productItems) {
		this.productItems = productItems;
	}

    
	
}

