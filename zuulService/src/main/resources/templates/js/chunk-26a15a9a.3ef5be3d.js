(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-26a15a9a"],{7071:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"comment-page"},[a("Row",{staticClass:"row"},[a("Col",{attrs:{span:"5",push:"3"}},[a("img",{staticClass:"canteen-img",attrs:{src:t.canteenObj.canteenImage}})]),a("Col",{staticClass:"row-b",attrs:{span:"12"}},[a("b",[t._v(t._s(t.canteenObj.canteenName))])])],1),a("hr"),a("p",{staticClass:"pp"},[t._v("评价")]),t._l(t.commentList,function(e){return[a("Card",{key:e.commentId,staticClass:"card"},[a("p",[t._v("评论时间:"+t._s(e.order.createdTime))]),a("p",[t._v("用户名:"+t._s(e.user.userName))]),a("p",[t._v("评论内容:"+t._s(e.commentContent))])])]})],2)},s=[],c=a("4ec3"),r={data(){return{canteenId:this.$route.query.canteenId,canteenObj:"",commentList:[]}},mounted(){let t={canteenId:this.canteenId};Object(c["A"])(t).then(t=>{this.commentList=t.data.data}),Object(c["r"])(t).then(t=>{this.canteenObj=t.data.data},t=>{this.$Message.error("网络错误")})}},i=r,o=(a("74fc"),a("2877")),u=Object(o["a"])(i,n,s,!1,null,null,null);e["default"]=u.exports},"74fc":function(t,e,a){"use strict";var n=a("7731"),s=a.n(n);s.a},7731:function(t,e,a){}}]);
//# sourceMappingURL=chunk-26a15a9a.3ef5be3d.js.map