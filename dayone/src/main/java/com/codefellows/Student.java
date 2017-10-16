package com.codefellows;

public class Student extends Person {
  private double avgGPA;

  public Student(String name) {
    super(name);
  }

  public Student(String name, int age, String ssn, double avgGPA) {
    super(name, age, ssn);
    this.avgGPA = avgGPA;
  }

  public double getAvgGPA() {
    return avgGPA;
  }

  @Override
  public String getName() {
    return String.format("student: %s", name);
  }
}
