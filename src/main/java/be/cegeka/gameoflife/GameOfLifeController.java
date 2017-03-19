package be.cegeka.gameoflife;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/gameoflife")
public class GameOfLifeController {

    private static Logger logger = Logger.getLogger(GameOfLifeController.class);

    @RequestMapping(value = "/world", method = POST)
    @ResponseBody
    public List<List<Boolean>> getWorld(@RequestBody List<List<Boolean>> currentWorld){
        List<List<Boolean>> newWorld = new ArrayList<>();
        for(int row = 0; row < currentWorld.size(); row++) {
            List<Boolean> newRow = new ArrayList<>();
            for(int column = 0; column < currentWorld.get(row).size(); column++) {
                newRow.add(new CelDeterminator().determineNextStatus(Cel.of(currentWorld.get(row).get(column)), new Neighbourhood(currentWorld, new Location(row, column)).getAmountOfLivingNeigbours()).getCelValue());
            }
            newWorld.add(newRow);
        }
        return newWorld;
    }

}
