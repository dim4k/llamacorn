package llamacorn.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import llamacorn.model.Delivery;

@RepositoryRestResource(collectionResourceRel = "delivery", path = "delivery")
public interface DeliveryRepository extends PagingAndSortingRepository<Delivery, Long> {

	List<Delivery> findByconsdate(@Param("consdate") Date consdate);
	
}

