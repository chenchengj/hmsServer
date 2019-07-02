package util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ai.appframe2.bo.DataContainer;

import net.sf.json.JSONObject;

public class JsonUtils {
	public static JSONObject object2Json(Object object) throws Exception {
			JSONObject json = new JSONObject();
			if (object != null) {
				if (object instanceof DataContainer) {
					Field[] fields = object.getClass().getFields();
					Method[] methods = object.getClass().getMethods();
					Map<String, Method> methodMap = new HashMap<String, Method>();
					for (int i = 0; i < methods.length; i++) {
						String methodName = methods[i].getName();
						methodMap.put(methodName, methods[i]);
					}
					for (int j = 0; j < fields.length; j++) {
						if (Modifier.isFinal(fields[j].getModifiers())
								&& !fields[j].get(object).equals("MROWID___")) {
							String fieldName = (String) fields[j].get(object);
							String[] s = fieldName.split("_");
							String getMethodName = "get";
							for (int k = 0; k < s.length; k++) {
								String first = s[k].substring(0, 1).toUpperCase();
								String a = first
										+ s[k].toLowerCase().substring(1,
												s[k].length());
								getMethodName = getMethodName + a;
							}
							Method method = methodMap.get(getMethodName);
							Object returnVal = null;
							if (method != null) {
								returnVal =  method.invoke(object, null);
							} else {
								throw new Exception("属性" + fieldName + "没有定义get方法");
							}
							json.put(fieldName, returnVal);
						}
					}
				} else {
					json = JSONObject.fromObject(object);
				}
			}
			return json;
		}
		
		public static Object json2Object(String jsonStr,Class beanClass) throws Exception{
			JSONObject json = JSONObject.fromObject(jsonStr);
			Map<String, Method> methodMap = new HashMap<String, Method>();
			Iterator<String> it = null;
			Object object = beanClass.newInstance();
			if(json != null){
				if(object instanceof DataContainer){
					Method[] methods = beanClass.getMethods();
					for(int i = 0 ; i < methods.length ; i++){
						methodMap.put(methods[i].getName(), methods[i]);
					}
					it = json.keys();
					while(it.hasNext()){
						String attrName = it.next();
						String[] s = attrName.split("_");
						String setMethodName = "set";
						for (int k = 0; k < s.length; k++) {
							String first = s[k].substring(0, 1).toUpperCase();
							String a = first
									+ s[k].toLowerCase().substring(1,
											s[k].length());
							setMethodName = setMethodName + a;
						}
						if(methodMap.get(setMethodName) != null){
							Method method = methodMap.get(setMethodName);
							method.invoke(object, new Object[]{json.get(attrName)});
						}else{
							throw new Exception(beanClass.getName()+"的属性"+attrName+"没有定义set方法");
						}
					}
				}else{
					object = JSONObject.toBean(json,beanClass);
				}
			}
			
			return object;
		}
}

