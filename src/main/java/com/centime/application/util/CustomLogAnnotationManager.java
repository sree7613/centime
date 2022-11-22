package com.centime.application.util;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CustomLogAnnotationManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomLogAnnotationManager.class);

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Around("execution(* *(..)) && @annotation(io.lenar.examples.spring.log.LogThat)")
	public void logMethods(ProceedingJoinPoint jp) throws Throwable {

		String[] argNames = ((MethodSignature) jp.getSignature()).getParameterNames();
		Object[] values = jp.getArgs();
		Map<String, Object> params = new HashMap<>();
		if (argNames.length != 0) {
			for (int i = 0; i < argNames.length; i++) {
				params.put(argNames[i], values[i]);
			}
		}

		LOGGER.info("-> method " + jp.getSignature().getName() + " invocation", true);
		if (!params.isEmpty()) {
			LOGGER.info(gson.toJson(params), true);
		}
	}
}
