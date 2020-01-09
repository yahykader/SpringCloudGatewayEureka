package kader.org.FacturationService.projection;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;
import kader.org.FacturationService.model.Facture;
import kader.org.FacturationService.model.ProductItem;

@Projection(name="fullFacture",types = Facture.class)
public interface FactureProjection {
	public Long getId();
	public Date getFactureDate();
	public Long CustomerId();
	public Collection<ProductItem> getProductItems();
}
