package main.domain.repo;

import main.domain.model.Offer;
import main.domain.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User,String> {

  Optional<Offer> findByIdAndOfferId(String id,long offerid);
}
