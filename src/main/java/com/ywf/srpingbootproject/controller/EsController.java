package com.ywf.srpingbootproject.controller;

import com.ywf.srpingbootproject.service.IEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private IEsService esService;

    @RequestMapping("/index")
    public String index(@RequestParam String index, @RequestParam String type, @RequestParam String id) {
        esService.index(index, type, id);
        return "success";
    }

    @RequestMapping("/get")
    public Object get(@RequestParam String index, @RequestParam String type, @RequestParam String id) {
        return esService.get(index, type, id);
    }

    @RequestMapping("/exists")
    public Object exists(@RequestParam String index, @RequestParam String type, @RequestParam String id) {
        return esService.exists(index, type, id);
    }

    @RequestMapping("/update")
    public Object update(@RequestParam String index, @RequestParam String type, @RequestParam String id) {
        return esService.update(index, type, id);
    }

    @RequestMapping("/delete")
    public Object delete(@RequestParam String index, @RequestParam String type, @RequestParam String id) {
        return esService.delete(index, type, id);
    }

    @RequestMapping("/searchByDFSQueryThenFetch")
    public Object searchByDFSQueryThenFetch(@RequestParam String index, @RequestParam String key) {
        return esService.searchByDFSQueryThenFetch(index, key);
    }

    @RequestMapping("/searchByQueryThenFetch")
    public Object searchByQueryThenFetch(@RequestParam String index, @RequestParam String key) {
        return esService.searchByQueryThenFetch(index, key);
    }

    @RequestMapping("/query")
    public Object query(@RequestParam String index, @RequestParam String key, @RequestParam int pageNum, @RequestParam int pageSize) {
        return esService.query(index, key, pageNum, pageSize);
    }

}
