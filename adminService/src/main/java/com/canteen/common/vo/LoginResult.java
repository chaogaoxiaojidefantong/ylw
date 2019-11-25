	package com.canteen.common.vo;
	
	import java.io.Serializable;

    public class LoginResult implements Serializable{
         private Object data;
         private String token;
        public Object getData() {
            return data;
        }
        public void setData(Object data) {
            this.data = data;
        }
        public String getToken() {
            return token;
        }
        public void setToken(String token) {
            this.token = token;
        }
        public LoginResult(Object data, String token) {
            super();
            this.data = data;
            this.token = token;
        }


    }
