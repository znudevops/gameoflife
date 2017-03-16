package be.cegeka.fizzbuzz;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzServiceTest {

    private FizzBuzzService fizzBuzzService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        fizzBuzzService = new FizzBuzzService();
    }

    @Test
    public void fizzBuzz() {
        Integer[] fizzBuzzSequence = fizzBuzzService.fizzBuzz(2);
        assertThat(fizzBuzzSequence).hasSize(2);
        assertThat(fizzBuzzSequence).containsExactly(1, 2);
    }

    @Test
    public void fizzBuzz_givenSequenceNumberLowerOrEqualThan1_thenThrowException() {
//        expectedException.expect(IllegalArgumentException.class);
//        expectedException.expectMessage("SequenceNumber should be higher than 1");
//        fizzBuzzService.fizzBuzz(1);
    }

    @Test
    public void fizzBuzz_whenNumberDivisibleBy3_thenPrintFizz() {
//        Integer[] fizzBuzzSequence = fizzBuzzService.fizzBuzz(3);
//        Assertions.assertThat(fizzBuzzSequence).containsExactly(1, 2, "Fizz");
    }

}
