package no.kristiania.exam.website.website.backend.service;

import no.kristiania.exam.website.website.backend.entity.Item;
import no.kristiania.exam.website.website.backend.entity.Rank;
import no.kristiania.exam.website.website.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class RankService {
    @Autowired
    private EntityManager em;

    public Long createRank(Long itemId, String username, int rating, String comment){
        Item item = em.find(Item.class, itemId);
        User user = em.find(User.class, username);
        if(item == null){
            throw new IllegalStateException("No item found with id " + itemId);
        }
        if(user == null){
            throw new IllegalStateException("No user found in db");
        }
        Rank rank = new Rank();
        rank.setRating(rating);
        rank.setRankingBy(user);
        rank.setComment(comment);
        rank.setItemInfo(item);
        user.getRankedItems().add(item);
        em.persist(rank);
        return rank.getId();
    }
    public List<Rank> getRanks(){
        TypedQuery<Rank> query = em.createQuery("SELECT r from Rank r", Rank.class);
        return query.getResultList();
    }

    public Rank commentOnRank(long rankId, String comment){
        Rank ranks = em.find(Rank.class, rankId);
        if(ranks == null){
            throw new IllegalStateException("No ranks found");
        }
        ranks.setComment(comment);
        return ranks;
    }
    public List<Rank> updateRankAndComment(long rankId,int rating, String comment){
        Rank ranks = em.find(Rank.class, rankId);
        if(ranks == null){
            throw new IllegalStateException("No ranks found");
        }
        ranks.setComment(comment);
        ranks.setRating(rating);
        return Collections.singletonList(ranks);
    }

}
