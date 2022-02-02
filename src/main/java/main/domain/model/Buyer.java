package main.domain.model;

public class Buyer extends User{
  UserType type;
  public Buyer(String name, String contact) {
    super(name, contact);
    this.type =type;
  }
}
