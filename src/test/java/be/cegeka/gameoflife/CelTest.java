package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CelTest {

    @Test
    public void givenTrue_WhenOf_ThenReturnsLivingCell(){
        Assertions.assertThat(Cel.of(true)).isEqualTo(Cel.LIVING);
    }

    @Test
    public void givenFalse_WhenOf_ThenReturnsDeadCell(){
        Assertions.assertThat(Cel.of(false)).isEqualTo(Cel.DEAD);
    }
}
