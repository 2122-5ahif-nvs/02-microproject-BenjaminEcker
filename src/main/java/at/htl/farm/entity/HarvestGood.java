package at.htl.farm.entity;

public class HarvestGood {
    private Long id;
    private String name;
    private Boolean isFeed;
    private Integer quantity;

    public HarvestGood() {
    }

    public HarvestGood(Long id, String name, Boolean isFeed, Integer quantity) {
        this.id = id;
        this.name = name;
        this.isFeed = isFeed;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFeed() {
        return isFeed;
    }

    public void setFeed(Boolean feed) {
        isFeed = feed;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "HarvestGood{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isFeed=" + isFeed +
                ", quantity=" + quantity +
                '}';
    }
}
