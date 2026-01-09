package com.skillforge;
class BeginnerCourse extends Course implements ICertifiable {

    public BeginnerCourse(String title, Instructor instructor, String[] modules) {
        super(title, instructor, modules, new String[]{});
    }

    public void generateCertificate() {
        System.out.println("Certificate: Beginner Level Completion");
    }
}
