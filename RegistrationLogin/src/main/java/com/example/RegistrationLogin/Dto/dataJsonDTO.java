package com.example.RegistrationLogin.Dto;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class dataJsonDTO {

    private boolean is_success = true;
    private String user_id = "john_doe_17091999";
    private String email = "john@xyz.com";
    private String roll_number = "21BCE0751";

    private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<String> alphabets = new ArrayList<>();
    private ArrayList<String> highest_lowercase_alphabet = new ArrayList<>();
    private ArrayList<String> data;

    public void extractNumbers() {
        Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        this.numbers.clear();

        for (String item : data) {
            if (numericPattern.matcher(item).matches()) {
                this.numbers.add(item);
            }
        }
    }

    public void extractAlphabets() {
        Pattern alphabetPattern = Pattern.compile("[a-zA-Z]+");
        this.alphabets.clear();

        for (String item : data) {
            if (alphabetPattern.matcher(item).matches()) {
                this.alphabets.add(item);
            }
        }
    }

    public void findHighestLowercaseLetter() {
        char highestLetter = 'a' - 1;
        boolean found = false;
        this.highest_lowercase_alphabet.clear();

        for (String item : data) {
            if (item.length() == 1 && Character.isLowerCase(item.charAt(0))) {
                char currentChar = item.charAt(0);
                if (currentChar > highestLetter) {
                    highestLetter = currentChar;
                    found = true;
                }
            }
        }

        if (found) {
            this.highest_lowercase_alphabet.add(String.valueOf(highestLetter));
        }
    }

    // Getters for all fields
    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public ArrayList<String> getAlphabets() {
        return alphabets;
    }

    public ArrayList<String> getHighestLowercaseAlphabet() {
        return highest_lowercase_alphabet;
    }

    public boolean isSuccess() {
        return is_success;
    }

    public String getUserId() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getRollNumber() {
        return roll_number;
    }

    // Constructor
    public dataJsonDTO(ArrayList<String> data) {
        this.data = data;
    }

    public dataJsonDTO() {
    }

    @Override
    public String toString() {
        return "dataJsonDTO{" +
                "is_success=" + is_success +
                ", user_id='" + user_id + '\'' +
                ", email='" + email + '\'' +
                ", roll_number='" + roll_number + '\'' +
                ", numbers=" + numbers +
                ", alphabets=" + alphabets +
                ", highest_lowercase_alphabet=" + highest_lowercase_alphabet +
                ", data=" + data +
                '}';
    }
}
