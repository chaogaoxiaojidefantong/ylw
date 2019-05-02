package com.canteen.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * 京淘商城自定义响应结构
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class BiliResult implements Serializable{
	private static final long serialVersionUID = 1L;

	// 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    /*
     * 200	成功
     * 201	错误
     * 400	参数错误
     */
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static BiliResult build(Integer status, String msg, Object data) {
        return new BiliResult(status, msg, data);
    }

    public static BiliResult oK(Object data) {
        return new BiliResult(data);
    }

    public static BiliResult oK() {
        return new BiliResult(null);
    }

    public BiliResult() {

    }

    public static BiliResult build(Integer status, String msg) {
        return new BiliResult(status, msg, null);
    }

    public BiliResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public BiliResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    
    public Boolean isOk() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为SysResult对象
     * 
     * @param jsonData json数据
     * @param clazz SysResult中的object类型
     * @return
     */
    public static BiliResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, BiliResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }

    /**
     * 没有object对象的转化
     * 
     * @param json
     * @return
     */
    public static BiliResult format(String json) {
        try {
            return MAPPER.readValue(json, BiliResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     * 
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static BiliResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }

}
