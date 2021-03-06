package com.vance.girlfriend

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.*
import javax.annotation.PostConstruct


@SpringBootApplication
class GirlfriendApplication : SpringBootServletInitializer(), WebMvcConfigurer {

    companion object {
        val jacksonMapper = ObjectMapper().registerKotlinModule()
                .setSerializationInclusion(JsonInclude.Include.NON_ABSENT)
                .enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
    }

    @PostConstruct
    fun init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Taipei"))
    }

}

fun main(args: Array<String>) {
    println("starting application...")
    runApplication<GirlfriendApplication>(*args)
}