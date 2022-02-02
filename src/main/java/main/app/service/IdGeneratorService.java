package main.app.service;

public class IdGeneratorService {

  private static long id =1000;

  public static long getId() {
    return id++;
  }
}
