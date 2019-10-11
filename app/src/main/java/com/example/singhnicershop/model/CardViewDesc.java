package com.example.singhnicershop.model;

public class CardViewDesc {
    private String title;
    private String description;
    private String price;
    private int image;
    private String quantity;


    public CardViewDesc(String title, String description, String price, int image, String quantity) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
