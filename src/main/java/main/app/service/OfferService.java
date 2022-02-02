package main.app.service;


import main.domain.model.Offer;
import main.domain.repo.OfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService {

  @Autowired OfferRepo repo;

  public Offer save(Offer offer){
    return repo.save(offer);
  }

  public Optional<Offer> findById(long offerId){
    return  repo.findById(offerId);
  }


  public Optional<Offer> findByIdAndProductId(long offerId,long productId){
    return  repo.findByIdAndProductId(offerId,productId);
  }
}
