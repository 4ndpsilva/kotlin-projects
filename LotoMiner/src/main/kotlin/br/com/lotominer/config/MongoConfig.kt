package br.com.lotominer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext

@Configuration
class MongoConfig(var factory: MongoDbFactory, var mappingContext: MongoMappingContext) {
    @Bean
    fun mappingMongoConverter(): MappingMongoConverter{
        val resolver = DefaultDbRefResolver(factory)
        val converter = MappingMongoConverter(resolver, mappingContext)
        converter.setTypeMapper(DefaultMongoTypeMapper(null))
        return converter
    }
}