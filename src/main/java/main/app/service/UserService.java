package main.app.service;

import main.domain.model.Offer;
import main.domain.model.OfferStatus;
import main.domain.model.User;
import main.domain.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

  User loggeIn;

  @Autowired UserRepo userRepo;

  @Autowired OfferService offerService;

  public Optional<User> findById(String conatct){
    return userRepo.findById(conatct);
  }

  public Offer addOffer(Offer offer ){
    //if(loggeIn.)
//    Offer offer = Offer.builder().id(IdGeneratorService.getId())
//        .description(description)
//        .quantity(qnty)
//        .start(startDate)
//        .duration_in_mins(duration)
//        .product_id(productId)
//        .build();

    return offerService.save(offer);

  }

  public Offer updateOffer(long offeId,  int qnty , int duration){
    Optional<Offer> offerFound = offerService.findById(offeId);
    if(offerFound.isPresent()){
      if(qnty>0)
      offerFound.get().setQuantity(qnty);

      if(duration>0)
        offerFound.get().setDuration_in_mins(duration);

      return offerService.save(offerFound.get());
    }
    return null;

  }

  public boolean consumeOffer(long productId, long offerId ){
    Optional<Offer> offerFound = offerService.findByIdAndProductId(offerId,productId);
    if (offerFound.isPresent() && !userRepo.findByIdAndOfferId(loggeIn.getContact(),offerId).isPresent() ){
      Date currTime= new Date(System.currentTimeMillis());
      Date valid_till = new Date(offerFound.get().getStart()+offerFound.get().getDuration_in_mins());

      if(currTime.after(valid_till)){
        offerFound.get().setStatus(OfferStatus.EXPIRED);
      }

      if (offerFound.get().getStatus()!=OfferStatus.EXPIRED && offerFound.get().getQuantity()>0){
        offerFound.get().updateQuantity();
      }
      return  true;
    }

    return false;
  }




}
