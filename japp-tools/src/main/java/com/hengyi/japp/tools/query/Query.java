/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hengyi.japp.tools.query;

import java.util.List;

/**
 *
 * @author jzb
 */
public class Query {

    protected String q;
    protected List result;

    public String getQ() {
        return q;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
