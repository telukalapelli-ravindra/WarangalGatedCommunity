package com.util;




import jakarta.servlet.http.HttpServletRequest;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class RequestMapper  {

	public  static <T> T mapRequest(Class<T> clazz, HttpServletRequest req){
		
		
		T instance=null;
		
		try {
			instance = clazz.getDeclaredConstructor().newInstance();
			
			BeanUtils.populate(instance, req.getParameterMap());
			
			return instance;
			
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
			
	}
	
		public  static <T> T mapRequest(Class<T> clazz, Map<String,String[]> reqParameter){
		
		
		T instance=null;
		
		try {
			instance = clazz.getDeclaredConstructor().newInstance();
			
			BeanUtils.populate(instance, reqParameter);
			
			
			return instance;
			
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
			
	}
		
		public static  <T> T mapRequest(Class<T> clazz, Object obj){
			
			
			T instance=null;
			
			try {
				instance = clazz.getDeclaredConstructor().newInstance();
				
				BeanUtils.copyProperties(instance, obj);
				
				
				return instance;
				
			}
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return null;
			}
				
		}
		
		
		public static void mapRequest(Object objDestinaion, Object objSource){
			
			
			try {
				
				BeanUtils.copyProperties(objDestinaion,objSource);
				
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				
				e.printStackTrace();
			}
				
		}
	
}
