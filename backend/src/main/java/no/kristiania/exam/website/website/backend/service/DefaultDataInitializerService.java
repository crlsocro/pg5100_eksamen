package no.kristiania.exam.website.website.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.function.Supplier;

/**
 * Adapted from:
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/backend
 */

@Service
public class DefaultDataInitializerService {
    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private RankService rankService;

    @PostConstruct
    public void initialize(){

        attempt(() ->  userService.createUser("elon123","Elon","Musk", "elon.musk@kristiania.no", "123"));
        attempt(() ->  userService.createUser("steve123","Steve","Jobs", "steve.jobs@kristiania.no", "123"));
        attempt(() ->  userService.createUser("bill123","Bill","Gates", "bill.gates@kristiania.no", "123"));

        String ctg1 = "Winter sports";
        String ctg2 = "Summer sports";
        String ctg3 = "Climbing";

        //Winter sports
        Long activity1 = attempt(() -> itemService.createItem("Wyllerloypa", "Try out the most notorious slope at Tryvann, Wylleloypa. " +
                "The slope is graded black and the total length is about 1,3 km long.",ctg1));

        Long act3 = attempt(() -> itemService.createItem("Tarnbakken", "You will find Tarnbakken at the very top of Tryvann. " +
                "The slope is graded green and it is recommended for the beginners. Total length is 900 meters.", ctg1));

        Long act4 = attempt(() -> itemService.createItem("Tryvannskleiva", "Tryvannskleiva is graded red. Therefore it is recommended that they" +
                "with more experience will use this slope. The slope is about 400 meters long", ctg1));

        Long act5 = attempt(() -> itemService.createItem("Vestkleiva", "You find the slope Vestkleiva next to Tryvannskleiva. The grade is red and " +
                "it is for they who are more experienced. The total length is about 200 meters", ctg1));

        Long act6 = attempt(() -> itemService.createItem("Sognsvann - Frognerseteren", "This is a route for cross-country skiing. The route starts at Sognsvann and goes up towards Frognerseteren. " +
                "The route is about 12 km and from Frognerseteren you can take the subway back to Oslo city center.", ctg1));

        Long act7 = attempt(() -> itemService.createItem("Frognerseteren - Kikut and back", "This route is for the more experienced. The route is about 30 km in total," +
                "so you have to have endurance and willpower to complete this route. The nature shows Nordmarka best side with beatiful nature and scenery", ctg1));

        //Summer sports activities in Oslo. From here all the routes are fiction for the context. Act8 - act 11 is 4 different routes in a fictional mountain bike park in Oslo.
        Long act8 = attempt(() -> itemService.createItem("The beginner", "This route is 650 meters long and is for beginners. Here you learn to ride a bike in a safe and fun way." +
                " There are simple challenges in the trail that also works as a warm-up for the other trails.", ctg2));

        Long act9 = attempt(() -> itemService.createItem("The intermediate", "This trail is 900 meters long and is for the intermediate. " +
                "Here are the different challenges that make the trail playful. Here you can also explore and learn new skills in mountain biking.",
                ctg2));

        Long act10 = attempt(() -> itemService.createItem("Advanced rider", "This trail is 1.5 km long and is for those with good experience in mountain biking. " +
                "Here you encounter different challenges that can be difficult.", ctg2));

        Long act11 = attempt(() -> itemService.createItem("Expert 101", "This trail is for the experts. " +
                "The trail is made for the World Cup in mountain biking and is 3 km long, but can be used by anyone who thinks they master a good challenge in mountain biking." +
                " And has good experience with mountain biking", ctg2 ));

        //Climbing which is also a summer/all year sport, but here it has its own category.

        // The climbing act12 - act15 will explain different routes on a Mountain called Kolsåstoppen in Oslo, but with fictional routes.
        Long act12 = attempt(() -> itemService.createItem("The climber", "This route is 11 meters long. It has grade 5- and has good grips for hands and feets.", ctg3));
        Long act13 = attempt(() -> itemService.createItem("Fingertips", "Fingers should hold, right? This climbing route has grade 7 and here you must have good strength in your hands to stay in the wall and not fall." +
                " There are bad grips for the hands all the way and the route is 12 meters high. " +
                "So here you have to keep your tongue straight all the way to clear the route.", ctg3));
        Long act14 = attempt(() -> itemService.createItem("The technical route", "The technical route is very technical with a climbing degree of 6+. " +
                "The route is 15 meters high and has some bad grips and some good ones.", ctg3));
        Long act15 = attempt(() -> itemService.createItem("It's hard", "This climbing route is very hard. " +
                "It has a climbing grade of 8 and requires a lot of the climber. " +
                "Here it requires good strength in hands and body and at the same time good technical knowledge.", ctg3));

        //Made some comments that I can post in rank. Is a bit much work to write 15-30 comments. That's why I use this method
        String cmt1 = "The route was very good, I felt a good feeling of achievement when I was finished.";
        String cmt2 = "Was a little too easy for me, would have liked more challenges on the route.";
        String cmt3 = "To difficult route, should have been better informed how difficult the route was.";
        String cmt4 = "I think the route suited me very well, but maybe a little short and a little too few obstacles. There is a potential for improvement";
        String cmt5 = "Very fun to try something new, the activity itself was fun to try out.";
        String cmt6 = "Suited my experience well";
        String cmt7 = "A little bit to hard for me";

         rankService.createRank(activity1,"elon123",5, cmt6);
         rankService.createRank(activity1,"steve123",1, cmt3);
         rankService.createRank(activity1,"bill123",5, cmt6);

         rankService.createRank(act3,"elon123",2, cmt2);
         rankService.createRank(act3,"steve123",5, cmt5);
         rankService.createRank(act3,"bill123",2, cmt2);

         rankService.createRank(act4,"elon123",5, cmt4);
        rankService.createRank(act4,"steve123",5, cmt1);
         rankService.createRank(act4,"bill123",4, cmt6);

         rankService.createRank(act5,"elon123",5, cmt4);
         rankService.createRank(act5,"steve123",5, cmt1);
         rankService.createRank(act5,"bill123",4, cmt6);

         rankService.createRank(act6,"elon123",5, cmt1);
         rankService.createRank(act6,"steve123",5, cmt5);
         rankService.createRank(act6,"bill123",5, cmt6);

        rankService.createRank(act7,"elon123",5, cmt6);
        rankService.createRank(act7,"steve123",5, cmt6);
        rankService.createRank(act7,"bill123",3, cmt6);

         rankService.createRank(act8,"elon123",5, cmt6);
         rankService.createRank(act8,"steve123",4, cmt4);
         rankService.createRank(act8,"bill123",4, cmt1);

         rankService.createRank(act9,"elon123",3, cmt2);
         rankService.createRank(act9,"steve123",5, cmt4);
         rankService.createRank(act9,"bill123",4, cmt6);

         rankService.createRank(act10,"elon123",2, cmt7);
         rankService.createRank(act10,"steve123",3, cmt2);
         rankService.createRank(act10,"bill123",5, cmt6);

         /*
         rankService.createRank(act11,"elon123",1, cmt7);
         rankService.createRank(act11,"steve123",2, cmt3);
         rankService.createRank(act11,"bill123",5, cmt6);

         rankService.createRank(act12,"elon123",5, cmt1);
         rankService.createRank(act12,"steve123",4, cmt2);
         rankService.createRank(act12,"bill123",5, cmt4);

         rankService.createRank(act13,"elon123",2, cmt3);
         rankService.createRank(act13,"steve123",5, cmt4);
         rankService.createRank(act13,"bill123",5, cmt6);

         rankService.createRank(act14,"elon123",2, cmt7);
         rankService.createRank(act14,"steve123",3, cmt7);
         rankService.createRank(act14,"bill123",4, cmt6);

         rankService.createRank(act15,"elon123",2, cmt1);
         rankService.createRank(act15,"steve123",3, cmt2);
         rankService.createRank(act15,"bill123",5, cmt4);

         */

    }


//From the course repo
    private  <T> T attempt(Supplier<T> lambda){
        try{
            return lambda.get();
        }catch (Exception e){
            return null;
        }
    }
}
