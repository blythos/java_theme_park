package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canGetDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0);
    }

    @Test
    public void canChargeVisitor__short(){
        Visitor shorty = new Visitor(25, 165, 300);
        assertEquals(8.40, rollerCoaster.pricefor(shorty), 0);
    }

    @Test
    public void canChargeVisitor_tall(){
        Visitor tallBoi = new Visitor(34, 230, 300);
        assertEquals(16.80, rollerCoaster.pricefor(tallBoi), 0);
    }

    @Test
    public void visitorIsAllowed(){
        Visitor dad = new Visitor(44, 180, 500);
        assertTrue(rollerCoaster.isAllowedTo(dad));
    }

    @Test
    public void visitorIsNotAllowed(){
        Visitor son = new Visitor(10, 134, 30);
        assertFalse(rollerCoaster.isAllowedTo(son));
    }

    
}
