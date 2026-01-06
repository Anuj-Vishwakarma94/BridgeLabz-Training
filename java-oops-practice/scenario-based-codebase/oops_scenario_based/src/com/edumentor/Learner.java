package com.edumentor;
public class Learner extends User implements Certifiable {

    private String courseType;

    public Learner(String name, String email, String userId, String courseType) {
        super(name, email, userId);
        this.courseType = courseType;
    }

    @Override
    public void generateCertificate() {
        if(courseType.equalsIgnoreCase("short")) {
            System.out.println("Certificate: Short Course Completion Award for " + name);
        } else {
            System.out.println("Certificate: Full-Time Course Graduation Award for " + name);
        }
    }
}
