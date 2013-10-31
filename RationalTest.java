import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    // Test for zero as denominator
    public void testZeroDenominator() {
    	assertFalse(!(new Rational(2,0).denominator() == 0));
	}
	
    // Test to set rational to 0/1 if numerator is zero
	public void testZeroRational() {
		assertEquals(new Rational(0,2), new Rational(0,1));
	}

    // Test for GCD
	public void testGCD() {
		assertEquals(new Rational(3,4), new Rational(3000,4000));
	}

    // Test for plus {
	public void testPlus() {
		Rational a = new Rational(0,1);
		assertEquals(a.plus(new Rational(2,3)), new Rational(2,3));
		Rational b = new Rational(4,2);
                assertEquals(b.plus(new Rational(1,1)), new Rational(3,1));
		Rational c = new Rational(-3,2);
                assertEquals(c.plus(new Rational(3,2)), new Rational(0,1));
		Rational d = new Rational(0,1);
                assertEquals(a.plus(new Rational(0,1)), new Rational(0,1));
	}

    // Test for minus
	public void testMinus() {
		Rational a = new Rational(0,1);
		assertEquals(a.minus(new Rational(0,1)), new Rational(0,1));
	}

    // Test for times
	public void testTimes() {
		Rational a = new Rational(3,1);
		assertEquals(a.times(new Rational(1,3)), new Rational(1,1));
		Rational b = new Rational(0,3);
		assertEquals(b.times(new Rational(1,3)), new Rational(0,1));
	}

   // Test for divide
	public void testDivides() {
		Rational a = new Rational(3,2);
		assertEquals(a.divides(new Rational(3,2)), new Rational(1,1));
		assertEquals(a.divides(new Rational(1,1)), new Rational(3,2));
		assertEquals(a.divides(new Rational(0,1)), new Rational(2147483647,1));
	}

   // Test for abs
	public void testAbs() {
		Rational a = new Rational(-1,1);
		assertEquals(a.abs(), new Rational(1,1));
		Rational b = new Rational(0,1);
		assertEquals(b.abs(), new Rational(0,1));
		Rational c = new Rational(-3,-3);
		assertEquals(c.abs(), new Rational(1,1));
	}

   // Test for less than
	public void testIsLessThan() {
		Rational a = new Rational(3,2);
		assertEquals(a.isLessThan(new Rational(2,3)), false);
		Rational b = new Rational(-3,2);
		assertEquals(b.isLessThan(new Rational(3,2)), true);
		Rational c = new Rational(0,1);
		assertEquals(c.isLessThan(new Rational(0,1)), false);
	}

  // Test for tolerance
	public void testTolerance() {
		Rational a = new Rational(1,100000);
		Rational.setTolerance(a);
		assertEquals(Rational.getTolerance(), a);
	}
	

    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }

    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}
