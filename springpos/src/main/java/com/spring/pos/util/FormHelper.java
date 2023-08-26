package com.spring.pos.util;

import java.util.Arrays;
import java.util.Enumeration;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.BooleanUtils;

import jakarta.servlet.http.HttpServletRequest;

public class FormHelper {
	
	public static void setOnlyRequest(HttpServletRequest request, Object source, Object target) throws Exception {
		
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			
			boolean isOkay = BooleanUtils.and(new boolean[] {PropertyUtils.isReadable(source, paramName), PropertyUtils.isWriteable(target, paramName)});
			if(!isOkay) {
				continue;
			}
			
			Object value = PropertyUtils.getProperty(source, paramName);
			PropertyUtils.setProperty(target, paramName, value);
			
			System.out.println("Set Property for bean [" + target.getClass().getName() + "] : value " + Arrays.toString(request.getParameterValues(paramName)));
		}
		
		
	}

}
