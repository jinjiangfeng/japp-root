/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hengyi.japp.tools.build;

/**
 *
 * @author jzb
 * @param <T>
 */
public abstract class AbstractBuilder<T> {

    protected T result;

    public T build() {
        return result;
    }
}
