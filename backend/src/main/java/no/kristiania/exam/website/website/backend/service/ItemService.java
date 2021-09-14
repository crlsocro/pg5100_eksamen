package no.kristiania.exam.website.website.backend.service;

import no.kristiania.exam.website.website.backend.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional
public class ItemService {

    @Autowired
    private EntityManager em;

    @Autowired
    private RankService rankService;

    public List<Item> getOnlyItem(long itemId){
        TypedQuery<Item> query = em.createQuery("select i from Item i where i.id = ?1", Item.class);
        query.setParameter(1, itemId);
        return query.getResultList();
    }

    public Item getItem(Long id){

        return em.find(Item.class, id);
    }

    public long createItem(String title, String description, String category){
        Item item = new Item();
        item.setTitle(title);
        item.setDescription(description);
        item.setCategory(category);
        em.persist(item);
        return item.getId();
    }

    public List<Item> sortByCategory(String category){
        TypedQuery<Item> query = em.createQuery("SELECT i from Item i where i.category = ?1 order by i.title ASC", Item.class);
        query.setParameter(1, category);
        return query.getResultList();
    }
    public List<Item> getAllItems(boolean withAuthors){
        TypedQuery<Item> query = em.createQuery("SELECT i from Item i", Item.class);
        List<Item> items = query.getResultList();

        if(withAuthors){
            items.forEach(i -> i.getAuthorsRanked().size());
        }
        return items;
    }
    public Item getItem(long id, boolean withAut){
        Item item = em.find(Item.class, id);
        if(withAut && item != null){
            item.getAuthorsRanked().size();
        }
        return item;
    }

    //Inspired from Line 177-193 in
    //https://github.com/arcuri82/testing_security_development_enterprise_systems/blob/4337fd41d8ecd9988cec2c19751f865c5c6ca3d9/intro/jee/jpa/jpql/src/test/java/org/tsdes/intro/jee/jpa/jpql/UserTest.java

    public double computeAvgRatingByUsers(Item item){
        TypedQuery<Double> queryAvg = (TypedQuery<Double>) em.createQuery("select AVG(r.rating) from Rank r WHERE r.itemInfo = ?1");
        queryAvg.setParameter(1, item);
        double avg = queryAvg.getSingleResult();
        item.setAvgRating(avg);
        return avg;
    }
}
