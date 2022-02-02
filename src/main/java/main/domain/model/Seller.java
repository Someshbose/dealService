package main.domain.model;

public class Seller extends User{
  UserType type;
  public Seller(String name, String contact,UserType type) {
    super(name, contact);
    this.type =type;
  }
}
