(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0d3e04"],{"5f41":function(e,s,r){"use strict";r.r(s);var t=function(){var e=this,s=e.$createElement,r=e._self._c||s;return r("Form",{ref:"formInline",attrs:{model:e.formInline,rules:e.ruleInline}},[r("FormItem",{attrs:{prop:"user"}},[r("Input",{attrs:{type:"text",placeholder:"Username"},model:{value:e.formInline.user,callback:function(s){e.$set(e.formInline,"user",s)},expression:"formInline.user"}},[r("Icon",{attrs:{slot:"prepend",type:"ios-person-outline"},slot:"prepend"})],1)],1),r("FormItem",{attrs:{prop:"password"}},[r("Input",{attrs:{type:"password",placeholder:"Password"},model:{value:e.formInline.password,callback:function(s){e.$set(e.formInline,"password",s)},expression:"formInline.password"}},[r("Icon",{attrs:{slot:"prepend",type:"ios-lock-outline"},slot:"prepend"})],1)],1),r("FormItem",[r("Button",{attrs:{type:"primary"},on:{click:function(s){return e.handleSubmit()}}},[e._v("修改")])],1)],1)},n=[],a=r("4ec3"),o=r("2f62"),l={data(){return{user:"",formInline:{user:"",password:""},ruleInline:{user:[{required:!0,message:"Please fill in the user name",trigger:"blur"},{type:"string",min:1,message:"The password length cannot be less than 1 bits",trigger:"blur"}],password:[{required:!0,message:"Please fill in the password.",trigger:"blur"},{type:"string",min:1,message:"The password length cannot be less than 1 bits",trigger:"blur"}]}}},methods:{...Object(o["b"])(["updateUser"]),handleSubmit(){let e={userId:this.user.userId,userName:this.formInline.user,userPwd:this.formInline.password};this.updateUser(e).then(e=>{201!=e.data.status?(this.$Message.success("修改成功"),this.$router.push({name:"blank"}),setTimeout(()=>{this.$router.push({name:"canteenList"})},1)):this.$Message.success("密码修改失败")})}},mounted(){this.user=JSON.parse(localStorage.getItem("user"));let e={userId:this.user.userId};Object(a["F"])(e).then(e=>{let s=e.data.data;this.formInline.user=s.userName})}},u=l,i=r("2877"),p=Object(i["a"])(u,t,n,!1,null,null,null);s["default"]=p.exports}}]);
//# sourceMappingURL=chunk-2d0d3e04.fa8cbddd.js.map