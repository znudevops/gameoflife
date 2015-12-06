package be.cegeka.status;

import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fransg on 02/12/15.
 */
@RestController
@RequestMapping(value = "/status")
public class StatusController {

    private List<List<Boolean>> world;

    @RequestMapping(value = "/name")
    @ResponseBody
    public String getApplicationName(){
        return "{\"name\": \"Game of Life\"}";
    }
    @RequestMapping(value = "/world")
    @ResponseBody
    public List<List<Boolean>> getWorld(){
        List<Boolean> row = Lists.newArrayList(false, true, true, false, false);
        world = Lists.newArrayList(row, row, row);
        return world;
    }
}
