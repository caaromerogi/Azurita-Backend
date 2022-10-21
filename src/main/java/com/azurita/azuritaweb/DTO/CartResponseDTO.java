package com.azurita.azuritaweb.DTO;

public class CartResponseDTO {
    private Long productId;
    private String name;
    private Double price;
    private String size;
    private String imgPath;
    private Integer quantity;

    public CartResponseDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CartResponseDTO(Long productId, String name, Double price, String size, String imgPath, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.size = size;
        this.imgPath = imgPath;
        this.quantity = quantity;
    }
}
