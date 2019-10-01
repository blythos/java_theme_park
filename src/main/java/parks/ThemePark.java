package parks;

import attractions.*;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {


    private ArrayList<IReviewed> reviews;

    public ThemePark(){
        reviews = new ArrayList<>();
    }

    public void addAttraction(IReviewed review){
        reviews.add(review);
    }


    public ArrayList<IReviewed> getAllReviews() {
        return reviews;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addVisitedAttractions(attraction);
        attraction.increaseVisitCount();
    }

    public HashMap<String, Integer> reviewMap(){
        HashMap<String, Integer> mapOfReviews =  new HashMap<>();
        for (IReviewed reviewed : this.getAllReviews()){
            mapOfReviews.put(reviewed.getName(), reviewed.getRating());
        }
        return mapOfReviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
        ArrayList<IReviewed> isAllowed = new ArrayList<>();
        for (IReviewed reviewed : this.reviews){
            if (reviewed instanceof ISecurity){
                if (((ISecurity) reviewed).isAllowedTo(visitor)){
                    isAllowed.add(reviewed);
                }
            } else {
                isAllowed.add(reviewed);
            }
        }
        return isAllowed;
    }


}
