package com.motek.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HolidaysCountDown {
    @WebMethod
    public Long getCount();
}
