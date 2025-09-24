/**
 * Piero Miranda
 * Student ID: 1062732
 * The goal is to create a class Duration that has a time duration in hours and
 * minutes.
 * The program gets the durations from the user in the format "hh:mm" and
 * creates Duration objects.
 * The Duration class has methods to convert a string to a Duration object, add
 * two Duration objects together.
 * It should also handle invalid inputs, such as negative values or incorrect
 * formats.
 * The class has a default constructor, a parameterized constructor, and methods
 * to add two durations together.
 */

class Duration {
    private int hours;
    private int minutes;

    // Public Duration no-arg constructor
    public Duration() {
        this.hours = 0;
        this.minutes = 0;
    }

    // Add a public two parameter constructor. Should throw an
    // InvalidArgumentException if the passed in parameters are invalid.
    /**
     * @param hours   the hours of the duration
     * @param minutes the minutes of the duration
     */
    public Duration(int hours, int minutes) {
        // Handle negative values
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            //hours *= -1;
            throw new IllegalArgumentException("Invalid time values. Hours must be between 0 and 24 and minutes between 0 and 59");
        }
        this.hours = hours + minutes / 60; // minutes truncate
        this.minutes = minutes % 60; // minutes is remainder
    }

    // Add accessors and mutators for the private properties
    /**
     * @return hours the hours of the duration
     */
    public int getHours() {
        return hours;
    }

    /**
     * @return minutes the minutes of the duration
     */
    public int getMinutes() {
        return minutes;
    }
    //SETTERS
    /**
     * @param hours integer of the hours to set
     * @throws IllegalArgumentException if hours is negative
     */
    public void setHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Hours must be between 0 and 24.");
        }
        this.hours = hours;
    }
    /**
     * @param minutes integer of the minutes to set
     * @throws IllegalArgumentException if minutes is not between 0 and 59
     */
    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Minutes must be between 0 and 59.");
        }
        this.minutes = minutes;
    }

    // Add toString method that returns the duration in hh:mm format
    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    // Add a static fromString methods that takes in a string of the form
    // hh:mm
    /**
     * @param time the string from the user
     * @return Duration object created from the string
     * @throws IllegalArgumentException if the string cannot be parsed or if the
     *                                  values are invalid
     */
    public static Duration fromString(String time) {
        String[] separate = time.split(":");
        // If not formatted correctly
        if (separate.length != 2) {
            throw new IllegalArgumentException("Time should be in \"hours:minutes.\"");
        }
        int hours;
        int minutes;
        try {
            hours = Integer.parseInt(separate[0]);
            minutes = Integer.parseInt(separate[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("You have to use numbers for hours and minutes.");
        }
        if (hours < 0 || minutes < 0 || minutes >= 60 || hours > 24) {
            throw new IllegalArgumentException(
                    "Invalid time values. Hours must be between 0 and 24 and minutes between 0 and 59");
        }
        // If the user did not submit numbers
        // if (hours < 0 || minutes < 0 || minutes >= 60) {
        // throw new IllegalArgumentException("Invalid time values. Hours must be
        // positive and minutes in the range of 0 and 59.");
        // }
        Duration duration = new Duration(hours, minutes);
        return duration;
    }

    // and returns a Duration object. Should throw an
    // InvalidArgumentException exception if the string cannot be parsed
    // or if the values are invalid.
    // Add method that takes in a Duration object and adds to "this"
    // object.
    /**
     * @param other the other Duration object to add
     * @return void it will update the object's hours and minutes
     */
    public void add(Duration other) {
        // int min = this.minutes + other.minutes;
        // int newHours = this.hours + other.hours + min / 60; // account for minutes that exceed 60
        // int newMinutes = min % 60; // Correct in case total minutes is more than an hour
        // Duration duration = new Duration(newHours, newMinutes);
        // return duration;
        int min = this.minutes + other.minutes;
        this.hours += other.hours + min/60;
        this.minutes = min%60;
    }

}
