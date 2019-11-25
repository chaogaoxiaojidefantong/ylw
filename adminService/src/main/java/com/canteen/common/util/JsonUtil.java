	package com.canteen.common.util;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
    public class JsonUtil<T> {
        /**
         * 把保存json对象的数组的字符串转为JSON对象的集合
         * @param arrayString 在前端保存json对象的数组转为字符串
         * @return
         */

        private ObjectMapper objectMapper=new ObjectMapper();

        /**
         * 将对象转化为json的String类型
         * @param object
         * @return
         */
        public String writeObjToJsonString(Object object)
        {
            try {
                String json=objectMapper.writeValueAsString(object);
                return json;
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
            return null;
        }


        public static List<String>arrayStringToList(String arrayString){
            List<String>listJSON=new ArrayList<>();
            String videosObj[]=arrayString.split("},");
            for(int i=0;i<videosObj.length;i++) {
                if(i!=videosObj.length-1) {
                    videosObj[i]=videosObj[i]+"}";
                }
                listJSON.add(videosObj[i]);
            }
            return listJSON;
        }

        /**
         * JSON的string类型转为list的对象集合
         * @param JSONString
         * @param cls
         * @return
         */
        public static List JSONstringToList(String JSONString,Class<?>cls) {
            //JSONArray j1=JsonArray.fromObject();
            JSONArray j1=JSONArray.parseArray(JSONString);
             return j1.toJavaList(cls);
        }

        /**
         * 对象的集合转为JSON的String型
         * @param list
         * @return
         */
        public static String listToJSONString(List list) {
            //JSONArray j1=JSONArray.fromObject();

            return JSONArray.toJSONString(list);
        }

        /**
         * 将String类型的json数据转化为对象
         * @param json
         * @param cls
         * @return
         */
        public T writeJsonStringToObj(String json,Class<T>cls) {
            try {
                return objectMapper.readValue(json,cls);
            }
            catch (Exception e) {
                e.getStackTrace();
            }
            return null;
        }

        }
