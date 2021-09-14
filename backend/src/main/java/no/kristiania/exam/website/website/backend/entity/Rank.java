package no.kristiania.exam.website.website.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Rank {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @NotNull
    private User rankingBy;

    @ManyToOne
    @NotNull
    private Item itemInfo;

    @Min(1)
    @Max(5)
    @NotNull
    private int rating;

    @Size(max = 1000)
    private String comment;

    public Rank() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRankingBy() {
        return rankingBy;
    }

    public void setRankingBy(User rankingBy) {
        this.rankingBy = rankingBy;
    }

    public Item getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(Item itemInfo) {
        this.itemInfo = itemInfo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
