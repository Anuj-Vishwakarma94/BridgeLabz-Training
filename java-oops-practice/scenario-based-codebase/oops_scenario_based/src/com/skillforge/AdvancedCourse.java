package com.skillforge;
class AdvancedCourse extends Course implements ICertifiable {

    public AdvancedCourse(String title, Instructor instructor, String[] modules) {
        super(title, instructor, modules, new String[]{});
    }

    public void generateCertificate() {
        System.out.println("Certificate: Advanced Level Completion");
    }
}
