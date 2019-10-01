package parks;

import attractions.*;
import behaviours.IReviewed;
import org.w3c.dom.Attr;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.TobaccoStall;

import java.util.ArrayList;

public class ThemePark {

    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;

    public ThemePark(Dodgems dodgems, Park park, Playground playground, RollerCoaster rollerCoaster, CandyflossStall candyflossStall, IceCreamStall iceCreamStall, TobaccoStall tobaccoStall){
        this.dodgems = dodgems;
        this.park = park;
        this.playground = playground;
        this.rollerCoaster = rollerCoaster;
        this.candyflossStall = candyflossStall;
        this.iceCreamStall = iceCreamStall;
        this.tobaccoStall = tobaccoStall;
    }


    public ArrayList<IReviewed> getAllReviews() {
        ArrayList<IReviewed> allReviews = new ArrayList<>();
        allReviews.add(dodgems);
        allReviews.add(park);
        allReviews.add(playground);
        allReviews.add(rollerCoaster);
        allReviews.add(candyflossStall);
        allReviews.add(iceCreamStall);
        allReviews.add(tobaccoStall);
        return allReviews;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addVisitedAttractions(attraction);
        attraction.increaseVisitCount();
    }
}
