package main.app.controller;

import main.app.service.OfferService;
import main.app.service.UserService;
import main.domain.model.Offer;
import main.domain.model.User;
import main.domain.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class OfferController {

  @Autowired UserService service;

  @PostMapping("/addOffer")
  public Offer saveOffer(@RequestBody Offer offer, @RequestHeader("x-contact") String contact){
    Optional<User> userFound = service.findById(contact);
    if (userFound.isPresent() && userFound.get().getRole() == UserType.SELLER)
      return service.addOffer(offer);
    else
      return null;
  }

  @PutMapping("/updateOffer/{id}")
  public Offer updateOffer(@PathVariable("id") String id ,@RequestBody Offer offer,@RequestHeader("x-contact")String contact ){
    Optional<User> userFound = service.findById(contact);
    if (userFound.isPresent() && userFound.get().getRole() == UserType.SELLER)
      return service.updateOffer(Long.parseLong(id),offer.getQuantity(),offer.getDuration_in_mins());
    else
      return null;
  }

  @PostMapping("/claimOffer/{id}/{productId}")
  public boolean claimOffer( @PathVariable("id") String offerId, @PathVariable("productId") String productId, @RequestHeader("x-contact")String contact){
    Optional<User> userFound = service.findById(contact);
    if (userFound.isPresent() && userFound.get().getRole() == UserType.BUYER)
      return service.consumeOffer(Long.parseLong(productId),Long.parseLong(offerId));
    return false;
  }

}
