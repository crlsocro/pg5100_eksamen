package no.kristiania.exam.website.website.backend.Service;

import no.kristiania.exam.website.website.backend.entity.Item;
import no.kristiania.exam.website.website.backend.entity.Rank;
import no.kristiania.exam.website.website.backend.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Adapted from course repo:
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/backend/src/test/java/org/tsdes/intro/exercises/quizgame/backend/service
 */

@Service
@Transactional
public class ResetService {

    @PersistenceContext
    private EntityManager em;

    public void resetDatabase(){
        //Have to use native SQL for ElementCollection
        Query query = em.createNativeQuery("delete from user_roles");
        query.executeUpdate();

        deleteEntities(User.class);
        deleteEntities(Item.class);
        deleteEntities(Rank.class);

    }

    private void deleteEntities(Class<?> entity){

        if(entity == null || entity.getAnnotation(Entity.class) == null){
            throw new IllegalArgumentException("Invalid non-entity class");
        }

        String name = entity.getSimpleName();
        Query query = em.createQuery("delete from " + name);
        query.executeUpdate();
    }

}
