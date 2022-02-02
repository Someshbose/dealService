package main.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
  String userName;
  @Id
  String contact;

  UserType role;

  @OneToMany
  List<Offer> offerConsumed;

  public User(String name, String contact){
    this.userName =name;
    this.contact=contact;
  }

}
