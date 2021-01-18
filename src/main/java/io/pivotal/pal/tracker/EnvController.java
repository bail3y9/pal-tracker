package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    
    String portVal;
    String memLimitVal;
    String cfInstanceIndexVal;
    String cfInstanceAddressVal;
    final String PORT = "PORT";
    final String MEMORY_LIMIT = "MEMORY_LIMIT";
    final String CF_INSTANCE_INDEX = "CF_INSTANCE_INDEX";
    final String CF_INSTANCE_ADDR = "CF_INSTANCE_ADDR";
    public EnvController(@Value("${cf.port:NOT SET}")String portVal, @Value("${cf.memory.limit:NOT SET}")String memLimitVal, @Value("${cf.instance.index:NOT SET}")String cfInstanceIndexVal, @Value("${cf.instance.addr:NOT SET}")String cfInstanceAddressVal){
        this.portVal = portVal;
        this.memLimitVal = memLimitVal;
        this.cfInstanceIndexVal = cfInstanceIndexVal;
        this.cfInstanceAddressVal = cfInstanceAddressVal;
    }

    @GetMapping("/env")
    public Map<String, String> genEnv(){
        Map<String, String> envVars = new HashMap<>();
        envVars.put(PORT, portVal);
        envVars.put(MEMORY_LIMIT, memLimitVal);
        envVars.put(CF_INSTANCE_INDEX, cfInstanceIndexVal);
        envVars.put(CF_INSTANCE_ADDR, cfInstanceAddressVal);
        return envVars;

    }
}
