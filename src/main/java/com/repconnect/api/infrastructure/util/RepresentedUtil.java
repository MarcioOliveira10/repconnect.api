package com.repconnect.api.infrastructure.util;

import com.repconnect.api.core.domain.Represented;

import com.repconnect.api.infrastructure.entity.RepresentedEntity;


public class RepresentedUtil {

    public static RepresentedEntity createRepresentedEntity(Represented represented){
        RepresentedEntity representedEntity = new RepresentedEntity();
        representedEntity.setName(represented.name());
        representedEntity.setEmail(represented.email());
        representedEntity.setWebSite(representedEntity.getWebSite());
        representedEntity.setAddress(represented.address());
        representedEntity.setPhones(represented.phones());
        return representedEntity;
    }
}
