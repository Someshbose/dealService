package main.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Offer")
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Offer {

  @Id
  long id;
  String description;
  Date start;
  int duration_in_mins;
  long product_id;
  int quantity;
  OfferStatus status;

  public void updateQuantity(){
    this.quantity--;
  }
}
