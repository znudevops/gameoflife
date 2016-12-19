package be.cegeka.gameoflife;

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

    @RequestMapping(value = "/world", method = POST)
    @ResponseBody
    public List<List<Boolean>> getWorld(@RequestBody List<List<Boolean>> currentWorld) {
        List<List<Boolean>> nextWorld = buildNewWorld();
        for (int row = 0; row < currentWorld.size(); row++) {
            nextWorld.add(new ArrayList<>());
            for (int column = 0; column < currentWorld.get(row).size(); column++) {
                int deadNeighbours = countDeadNeighbours(currentWorld, row, column);
                nextWorld.get(row).add(this.isCellAliveInNextIteration(deadNeighbours, currentWorld.get(row).get(column)));
            }
        }
        return nextWorld;
    }

    private List<List<Boolean>> buildNewWorld() {
        ArrayList<List<Boolean>> result = new ArrayList<>();
        return result;
    }

    public int countDeadNeighbours(List<List<Boolean>> world, int x, int y) {
        int numberOfDeadNeighbours = 0;
        for (int row = x - 1; row <= x + 1; row++) {
            for (int column = y - 1; column <= y + 1; column++) {
                if (row < 0 || column < 0 || row >= world.size() || column >= world.size()) {
                    numberOfDeadNeighbours++;
                } else {
                    boolean cell = world.get(row).get(column);
                    if (!cell && !(row == x && column == y)) {
                        numberOfDeadNeighbours++;
                    }
                }
            }
        }
        return numberOfDeadNeighbours;
    }

    public boolean isCellAliveInNextIteration(int numberOfDeadNeighbours, boolean cell) {
        if (numberOfDeadNeighbours > 6 && cell) {
            // underpopulation
            return false;
        } else if ((numberOfDeadNeighbours == 5 || numberOfDeadNeighbours == 6) && cell) {
            // sustenance
            return true;
        } else if (numberOfDeadNeighbours < 5 && cell) {
            // overpopulation
            return false;
        } else if (!cell && numberOfDeadNeighbours == 5) {
            return true;
        }
        return cell;
    }
}
