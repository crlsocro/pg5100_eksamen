package no.kristiania.exam.website.website.backend.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 255)
    @NotNull
    private String title;

    @Size(max = 255)
    @NotNull
    private String description;

    @Size(max=255)
    @NotNull
    private String category;

    @Min(0)
    @Max(5)
    private double avgRating = 0.0;

    @ManyToMany(mappedBy = "rankedItems")
    private List<User> authorsRanked;

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public List<User> getAuthorsRanked() {
        return authorsRanked;
    }

    public void setAuthorsRanked(List<User> authorsRanked) {
        this.authorsRanked = authorsRanked;
    }
}
