package com.maogogo.zkcli.services.impl;

import com.maogogo.zkcli.model.ZKBean;
import com.maogogo.zkcli.services.ZKService;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toan on 2017/1/1.
 */
@Service
public class ZKServiceImpl extends Watcher implements ZKService {

    public Object getRoot(String text) throws Exception {
        System.out.println("text ====>>>>>" + text);
        if (text == null || "#".equals(text) || "".equals(text))
            return getRootPath();
        else
            return getChildPath(text);
    }

    public String getData(String text) throws Exception {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, this);

        text = text == null || "".equals(text) ? "/" : text;

        byte[] bs = zk.getData(text, false, null);

        return bs == null ? "null" : new String(bs);
    }

    private ZKBean getRootPath() throws Exception {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, this);
        System.out.println("111111111122222");
        List<String> zkKist = zk.getChildren("/", false);
        System.out.println("zkKist ==== .>>>" + zkKist);
        ZKBean zkBean = new ZKBean();

        zkBean.setText("/");
        zkBean.setChildren(true);
        List<ZKBean> result = strToBeans("", zkKist);

        zk.close();

        zkBean.setChildren(result);
        return zkBean;
    }

    private List<ZKBean> getChildPath(String path) throws Exception {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, this);
        System.out.println("11111" + path);

        List<String> zkKist = zk.getChildren(path, false);
        System.out.println("path ===>>>>" + path);
        List<ZKBean> result = strToBeans(path, zkKist);
        zk.close();

        return result;
    }

    public List<ZKBean> strToBeans(String path, List<String> list) {
        List<ZKBean> result = new ArrayList<ZKBean>();

        for (String s : list) {
            ZKBean bean = new ZKBean();
            bean.setId(s);
            bean.setText(path + "/" + s);
            bean.setChildren(true);
            result.add(bean);
        }

        return result;
    }

    public void process(WatchedEvent watchedEvent) {
        if (Event.EventType.None != watchedEvent.getType())
            System.out.println("===event>>>>" + watchedEvent);
    }

}
