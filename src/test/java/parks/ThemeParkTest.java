package parks;

import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ThemeParkTest {

    ThemePark themePark;

    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;

    Visitor visitor;


    @Before
    public void before(){
        themePark = new ThemePark();

        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Leafy Meadows", 9);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 5);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 5);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 7);

        visitor = new Visitor(45,320, 30000);

        themePark.addAttraction(dodgems);
        themePark.addAttraction(park);
        themePark.addAttraction(playground);
        themePark.addAttraction(rollerCoaster);
        themePark.addAttraction(candyflossStall);
        themePark.addAttraction(iceCreamStall);
        themePark.addAttraction(tobaccoStall);

    }

    @Test
    public void canGetReviews(){
        ArrayList<IReviewed> allReviews = themePark.getAllReviews();
        assertEquals(7, allReviews.size());
    }

    @Test
    public void visitorCanVisit(){
        themePark.visit(visitor, dodgems);
        assertEquals(1, visitor.visitedAttractionsLength());
        assertEquals(1, dodgems.getVisitCount());
    }

    @Test
    public void reviewsMapHasEntries(){
        assertFalse(themePark.reviewMap().isEmpty());
    }

    @Test
    public void customerIsAllowedOnAll(){
        assertEquals(6, themePark.getAllAllowedFor(visitor).size());
    }





}
