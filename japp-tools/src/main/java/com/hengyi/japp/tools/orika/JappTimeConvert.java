/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hengyi.japp.tools.orika;

import static com.hengyi.japp.tools.DateTimeUtil.fromTimeString;
import static com.hengyi.japp.tools.DateTimeUtil.toTimeString;
import java.util.Date;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

/**
 *
 * @author jzb
 */
public class JappTimeConvert extends BidirectionalConverter<Date, String> {

    @Override
    public String convertTo(Date source, Type<String> destinationType) {
        return toTimeString(source);
    }

    @Override
    public Date convertFrom(String source, Type<Date> destinationType) {
        return fromTimeString(source);
    }

}
