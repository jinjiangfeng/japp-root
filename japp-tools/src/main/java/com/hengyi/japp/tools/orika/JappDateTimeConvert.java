/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hengyi.japp.tools.orika;

import static com.hengyi.japp.tools.DateTimeUtil.fromDateTimeString;
import static com.hengyi.japp.tools.DateTimeUtil.toDateTimeString;
import java.util.Date;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

/**
 *
 * @author jzb
 */
public class JappDateTimeConvert extends BidirectionalConverter<Date, String> {

    @Override
    public String convertTo(Date source, Type<String> destinationType) {
        return toDateTimeString(source);
    }

    @Override
    public Date convertFrom(String source, Type<Date> destinationType) {
        return fromDateTimeString(source);
    }

}
