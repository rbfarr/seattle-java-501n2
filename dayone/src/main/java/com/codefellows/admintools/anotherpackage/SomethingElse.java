package com.codefellows.admintools.anotherpackage;

/* Even though com.codefellows.admintools.anotherpackage is contained in a subdirectory within the
com.codefellows.admintools package directory, it is in fact an entirely separate package, meaning
that if I want to use com.codefellows.admintools.*, I must explicitly import those artifacts: */

import com.codefellows.admintools.CourseManager;

public class SomethingElse {
  CourseManager cm = new CourseManager();
}
