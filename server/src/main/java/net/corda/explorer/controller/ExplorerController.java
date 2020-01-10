package net.corda.explorer.controller;

import net.corda.explorer.exception.GenericException;
import net.corda.explorer.model.response.MessageResponseEntity;
import net.corda.explorer.model.response.NetworkMap;
import net.corda.explorer.service.ExplorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ExplorerController {

    @Autowired
    private ExplorerService explorerService;

    @GetMapping("/network-map")
    public MessageResponseEntity<NetworkMap> networkMap(){
        try {
            NetworkMap networkMap = explorerService.getNetworkMap();
            return new MessageResponseEntity<>(networkMap);
        }catch (Exception e){
            throw new GenericException(e.getMessage());
        }
    }
}
