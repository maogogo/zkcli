package com.maogogo.zkcli.services;

import com.maogogo.zkcli.model.ZKBean;

import java.util.List;

/**
 * Created by Toan on 2017/1/1.
 */
public interface ZKService {

    Object getRoot(String text) throws Exception;
    String getData(String text) throws Exception;

}
