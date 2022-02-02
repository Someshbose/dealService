package main.domain.repo;

import main.domain.model.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OfferRepo extends CrudRepository<Offer,Long> {

  Optional<Offer> findByIdAndProductId(long id,long offerId);
}
