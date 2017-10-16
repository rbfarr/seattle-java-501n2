package com.codefellows.admintools;

import com.codefellows.Person;

public class Instructor extends Person {
  private int hoursWorked; // specific to Instructors

  public Instructor(String name) {
    /* If I do not specify a parent constructor to call, Java will implicitly insert a call to
       super() here. Note that the call to super(...) must always occur before any other code in
       the constructor. */

    super(name);
  }

  public int getHoursWorked() {
    return hoursWorked;
  }

  /* The @Override annotation will tell the javac compiler to enforce that we have in fact
     overridden a parent method. */

  @Override
  public String getName() {
    return String.format("instructor: %s", name);
  }
}
