package be.cegeka.status;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fransg on 02/12/15.
 */
public class StatusControllerTest {

    private StatusController statusController = new StatusController();

    @Test
    public void testGetApplicationName_ShouldReturnName() throws Exception {
        assertThat(statusController.getApplicationName()).isEqualTo("{\"name\": \"Game of Life\"}");
    }
}
