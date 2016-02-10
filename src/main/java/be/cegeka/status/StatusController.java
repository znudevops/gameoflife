package be.cegeka.status;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by fransg on 02/12/15.
 */
@RestController
@RequestMapping(value = "/status")
public class StatusController {

    private static Logger logger = Logger.getLogger(StatusController.class);

    @RequestMapping(value = "/name")
    @ResponseBody
    public String getApplicationName(){
        return "{\"name\": \"Game of Life\"}";
    }

    @RequestMapping(value = "/world", method = POST)
    @ResponseBody
    public List<List<Boolean>> getWorld(@RequestBody List<List<Boolean>> currentWorld){
        logger.info(currentWorld);
        return currentWorld;
    }
}
