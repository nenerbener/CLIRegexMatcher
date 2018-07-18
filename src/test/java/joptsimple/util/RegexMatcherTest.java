package joptsimple.util;
 
import joptsimple.ValueConversionException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
 
import static joptsimple.util.RegexMatcher.*;
import static org.junit.Assert.*;
//import org.junit.rules.ExpectedException.*;
 
/**
 * @author <a href="mailto:pholser@alumni.rice.edu">Paul Holser</a>
 */
public class RegexMatcherTest {
    @Rule public final ExpectedException thrown = ExpectedException.none();
 
    private RegexMatcher abc;
 
    @Before
    public void setUp() {
        abc = new RegexMatcher( "abc", 0 );
    }
 
    @Test
    public void shouldAttemptToMatchValueAgainstARegex() {
        assertEquals( "abc", abc.convert( "abc" ) );
    }
 
    @Test( expected = ValueConversionException.class )
    public void rejectsValueThatDoesNotMatchRegex() {
        abc.convert( "abcd" );
    }
 
    @Test
    public void raisesExceptionContainingValueAndPattern() {
        thrown.expect( ValueConversionException.class );
        thrown.expectMessage( "\\d+" );
        thrown.expectMessage( "asdf" );
 
        new RegexMatcher( "\\d+", 0 ).convert( "asdf" );
    }
 
    @Test
    public void shouldOfferConvenienceMethodForCreatingMatcherWithNoFlags() {
        assertEquals( "sourceforge.net", regex( "\\w+\\.\\w+" ).convert( "sourceforge.net" ) );
    }
 
    @Test
    public void shouldAnswerCorrectValueType() {
        assertEquals( String.class, abc.valueType() );
    }
 
    @Test
    public void shouldGiveCorrectValuePattern() {
        assertEquals( "abc", abc.valuePattern() );
    }
}