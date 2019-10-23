package repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Show implements Serializable {
    private String title;
    private LocalDateTime dateTime;
    private Integer minAge;
    private Float price;
    private HashMap<Character, HashMap<Integer, Boolean>> availablePosition;


    public Show(String title, LocalDateTime dateTime, Integer minAge, Float price, HashMap<Character, HashMap<Integer, Boolean>> availablePosition) {
        this.title = title;
        this.dateTime = dateTime;
        this.minAge = minAge;
        this.price = price;
        this.availablePosition = availablePosition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public HashMap<Character, HashMap<Integer, Boolean>> getAvailablePosition() {
        return availablePosition;
    }

    public void setAvailablePosition(HashMap<Character, HashMap<Integer, Boolean>> availablePosition) {
        this.availablePosition = availablePosition;
    }

    @Override
    public String toString() {
        return "Show{" +
                "title='" + title + '\'' +
                ", dateTime=" + dateTime +
                ", minAge=" + minAge +
                ", price=" + price +
                ", availablePosition=" + availablePosition +
                '}';
    }
}
