package com.maogogo.zkcli.rest;

import com.maogogo.zkcli.model.ZKBean;
import com.maogogo.zkcli.services.ZKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Toan on 2017/1/1.
 */
@RestController
public class TestRestful {

    @Autowired
    private ZKService zkService;

    @RequestMapping("/hello")
    public Object hello(String text) throws Exception {
        System.out.println("path ===>>>" + text);
        return zkService.getRoot(text);
    }

    @RequestMapping("/data")
    public String data(String text) throws Exception {
        System.out.println("path ===>>>" + text);
        return zkService.getData(text);
    }

}
