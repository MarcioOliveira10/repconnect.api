package com.repconnect.api.applicationn.gateway;


import com.repconnect.api.core.domain.Phone;

import java.util.List;

public interface IPhoneGateway {
    Phone createPhone(Phone phone);

     List<Phone> getAllPhones();
}
