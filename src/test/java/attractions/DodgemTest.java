package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void canGetDefaultPrice(){
        assertEquals(4.50, dodgems.defaultPrice(), 0);
    }

    @Test
    public void canChargeVisitor__younger(){
        Visitor son = new Visitor(10, 135, 300);
        assertEquals(2.25, dodgems.priceFor(son), 0);
    }

    @Test
    public void canChargeVisitor_older(){
        Visitor dad = new Visitor(34, 230, 300);
        assertEquals(4.50, dodgems.priceFor(dad), 0);
    }
}
