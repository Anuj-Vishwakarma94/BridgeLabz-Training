package com.skillforge;
class Course {

    private String title;
    private Instructor instructor;
    protected double rating;
    private String[] modules;
    private final String[] reviews;

    public Course(String title, Instructor instructor) {
        this(title, instructor, new String[]{"Intro", "Basics"}, new String[]{});
    }

    public Course(String title, Instructor instructor, String[] modules, String[] reviews) {
        this.title = title;
        this.instructor = instructor;
        this.modules = modules;
        this.reviews = reviews;
    }

    protected void updateRating(double value) {
        rating = value;
    }

    public String getTitle() {
        return title;
    }

    public String[] getReviews() {
        return reviews;
    }
}
