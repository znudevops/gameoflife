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
                nextWorld.get(row).add(isCellAliveInNextIteration(deadNeighbours, currentWorld.get(row).get(column)));
            }
        }
        return nextWorld;
    }

    public int countDeadNeighbours(List<List<Boolean>> world, int x, int y) {
        int numberOfDeadNeighbours = 0;
        for (int row = x - 1; row <= x + 1; row++) {
            for (int column = y - 1; column <= y + 1; column++) {
                if (belowLowerBoundOfWorld(world, row, column)) {
                    numberOfDeadNeighbours++;
                } else {
                    boolean cell = world.get(row).get(column);
                    if (dead(cell) && isNotTheMiddleCell(x, y, row, column)) {
                        numberOfDeadNeighbours++;
                    }
                }
            }
        }
        return numberOfDeadNeighbours;
    }

    public boolean isCellAliveInNextIteration(int numberOfDeadNeighbours, boolean cell) {
        if (underpopulation(numberOfDeadNeighbours, cell)) {
            return false;
        } else if (sustenance(numberOfDeadNeighbours, cell)) {
            return true;
        } else if (overpopulation(numberOfDeadNeighbours, cell)) {
            return false;
        } else if (reproduction(numberOfDeadNeighbours, cell)) {
            return true;
        }
        return cell;
    }

    private boolean isNotTheMiddleCell(int x, int y, int row, int column) {
        return !(row == x && column == y);
    }

    private boolean dead(boolean cell) {
        return !cell;
    }

    private boolean belowLowerBoundOfWorld(List<List<Boolean>> world, int row, int column) {
        return row < 0 || column < 0 || row >= world.size() || column >= world.size();
    }

    private List<List<Boolean>> buildNewWorld() {
        ArrayList<List<Boolean>> result = new ArrayList<>();
        return result;
    }

    private boolean reproduction(int numberOfDeadNeighbours, boolean cell) {
        return dead(cell) && numberOfDeadNeighbours == 5;
    }

    private boolean overpopulation(int numberOfDeadNeighbours, boolean cell) {
        return numberOfDeadNeighbours < 5 && cell;
    }

    private boolean sustenance(int numberOfDeadNeighbours, boolean cell) {
        return (numberOfDeadNeighbours == 5 || numberOfDeadNeighbours == 6) && cell;
    }

    private boolean underpopulation(int numberOfDeadNeighbours, boolean cell) {
        return numberOfDeadNeighbours > 6 && cell;
    }
}
