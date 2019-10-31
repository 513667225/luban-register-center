package com.luban.moudle.servlet;

import com.luban.moudle.annotation.Resources;
import com.luban.moudle.annotation.ResourcesMapping;
import com.luban.moudle.annotation.ResponseResources;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * 需要咨询JAVA高级VIP课程的可以加若曦老师：2408349392
 * 需要视频资料或者咨询课程的可以加安其拉老师：2246092212
 * author：鲁班学院-商鞅老师
 */

public class LuBanDispatcherServlet extends HttpServlet {
    String projectPath = this.getClass().getResource("/").getPath();
    String prefix = "";
    String suffix = "";
    Map<String,Method>  methodMap = new HashMap();

    //初始化
    @Override
    public void init(ServletConfig config) throws ServletException {
        String xmlPathLoacl = config.getInitParameter("XmlPathLoacl");
        //URL解码 空格 会变成 %20
        projectPath = projectPath.replaceAll("%20"," ");
        scanProjectByPath(projectPath+"/");
    }

    public void scanProjectByPath(String path){
        File file = new File(path);
        scanFile(file);
    }





    public void scanFile(File file){
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                scanFile(file1);
            }
        }else{
            String path = file.getPath();
            //....class    Class
            //c://project//luban//test-mvc//java//com//controler//TestController.class
            //Class.forName(className)
            //className: com.controller.TestController
            /**
             * 正在模拟Spring MVC 初始化代码
             */
            if (path.substring(path.lastIndexOf(".")).equals(".class")){
                // com\\controller\\TestController.class
                String classPath  =  path.replace(new File(projectPath).getPath()+"\\","");
                classPath = classPath.replaceAll("\\\\",".");
                String className = classPath.substring(0,classPath.lastIndexOf("."));
                try {
                    Class<?> clazz = Class.forName(className);
                    boolean annotationPresent = clazz.isAnnotationPresent(Resources.class);
                    if (annotationPresent){
                        ResourcesMapping annotation = clazz.getAnnotation(ResourcesMapping.class);
                        String classRequestMappingPath = annotation.value();
                        //解析所有方法
                        for (Method method : clazz.getMethods()) {
                            ResourcesMapping methodResourcesMapping = method.getAnnotation(ResourcesMapping.class);
                            if (methodResourcesMapping != null) {
                                String requestMapping = methodResourcesMapping.value();
                                methodMap.put(classRequestMappingPath+requestMapping,method);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String requestURI = request.getRequestURI();
            Method method = methodMap.get(requestURI);
            if (method!=null){
                Parameter[] parameters = method.getParameters();
                Object[] objects = new Object[parameters.length];

                for (int i = 0; i < parameters.length; i++) {
                    Parameter parameter = parameters[i];
                    //
                    String name = parameter.getName();
                    Class<?> type = parameter.getType();
                    if (type.equals(HttpServletRequest.class)){
                        objects[i]=request;
                    }else if(type.equals(HttpServletResponse.class)){
                        objects[i]=response;
                    }else if(type.equals(String.class)){
                        objects[i]= request.getParameter(name);
                    }else{
                        Object o = type.newInstance();
                        for (Field field : type.getDeclaredFields()) {
                            field.setAccessible(true);
                            String fieldName = field.getName();
                            field.set(o,request.getParameter(fieldName));
                        }
                        objects[i] = o;
                    }
                }
                Class<?> declaringClass = method.getDeclaringClass();
                Object invoke = method.invoke(declaringClass.newInstance(), objects);
                String s = String.valueOf(invoke);
                if (method.isAnnotationPresent(ResponseResources.class)){
                    response.getWriter().write(s);
                }else{
                    if (invoke.getClass().equals(String.class)){

                        request.getRequestDispatcher(prefix+s+suffix).forward(request,response);
//                    response.sendRedirect();
                    }
                }

            }else{
                response.setStatus(404);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //   /test/test.do




    }
}
