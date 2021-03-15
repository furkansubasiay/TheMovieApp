package com.furkansubasiay.themovie.util

/**
 * Created by FURKAN SUBAŞIAY on 12.03.2021.
 */
interface EntityMapper<Entity,DomainModel> {
    fun mapFromEntity(page:Int,entity: Entity):DomainModel

    fun mapToEntity(page:Int,domainModel: DomainModel):Entity
}