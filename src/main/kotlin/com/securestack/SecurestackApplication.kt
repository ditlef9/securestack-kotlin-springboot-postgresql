package com.securestack

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecurestackApplication

fun main(args: Array<String>) {
	runApplication<SecurestackApplication>(*args)
}
