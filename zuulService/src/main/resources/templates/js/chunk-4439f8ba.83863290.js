(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4439f8ba"],{"24de":function(t,e,s){"use strict";s.r(e);var a=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("Row",{staticClass:"row"},[s("Col",{attrs:{span:"5",push:"3"}},[s("img",{staticClass:"canteen-img",attrs:{src:t.canteenObj.canteenImage}})]),s("Col",{staticClass:"row-b",attrs:{span:"12"}},[s("b",[t._v(t._s(t.canteenObj.canteenName))])]),s("Col",{attrs:{span:"6",push:"2"}},[t.collectState?t._e():s("Button",{staticClass:"row-co",attrs:{type:"warning",shape:"circle",size:"large"},on:{click:t.collect}},[t._v("收藏")]),t.collectState?s("Button",{staticClass:"row-co",attrs:{type:"success",shape:"circle",ghost:!0,size:"large"},on:{click:t.collect}},[t._v("取消收藏")]):t._e()],1)],1),s("hr"),s("Menu",{attrs:{mode:"horizontal",theme:"light","active-name":"1"}},[s("MenuItem",{staticClass:"menu-b",attrs:{name:"1"},nativeOn:{click:function(e){return t.getFoodList(e)}}},[t._v("           \r\n            更新时间\r\n             "),s("Divider",{attrs:{type:"vertical"}})],1),s("MenuItem",{staticClass:"menu-b",attrs:{name:"2"},nativeOn:{click:function(e){return t.foodDesc(e)}}},[t._v("         \r\n            销量\r\n             "),s("Divider",{attrs:{type:"vertical"}})],1),s("MenuItem",{staticClass:"menu-b",attrs:{name:"3"},nativeOn:{click:function(e){return t.commentPage(e)}}},[t._v("          \r\n            评价\r\n        ")]),s("Input",{staticClass:"clientsearchInput",attrs:{search:"","enter-button":"",placeholder:"搜索食品",size:"large"},on:{"on-search":t.selectName}})],1),s("hr"),s("div",[s("div",{staticClass:"div-middle"},[t._l(this.foodList,function(e){return[s("Card",{key:e.foodId,staticClass:"food-card"},[s("div",{attrs:{slot:"title"},slot:"title"},[s("p",[t._v(t._s(e.foodName))]),s("Rate",{attrs:{"allow-half":"",value:e.foodRate}})],1),s("img",{staticClass:"food-img",attrs:{src:e.foodImage}}),s("b",{staticClass:"food-font"},[t._v("$"+t._s(e.foodPrice))]),s("br"),s("b",{staticClass:"food-font"},[t._v("销量:"+t._s(e.foodSale))]),s("br"),t._l(t.shopcartList,function(a){return[a.foodId==e.foodId?s("ButtonGroup",{key:a.foodId},[s("Button",{attrs:{type:"primary"},on:{click:function(e){return t.cartReduceOneFood(a)}}},[t._v("-")]),s("Button",[t._v(t._s(a.foodNum))]),s("Button",{attrs:{type:"primary"},on:{click:function(e){return t.foodAddNum(a)}}},[t._v("+")])],1):t._e()]}),s("br"),s("Button",{staticClass:"foodButton",attrs:{type:"primary",shape:"circle"},on:{click:function(s){return t.foodAddNum(e)}}},[t._v("加入购物车")])],2)]}),t._l(t.commentList,function(e){return[s("Card",{key:e.commentId,staticClass:"card"},[s("p",[t._v("评论时间:"+t._s(e.order.createdTime))]),s("p",[t._v("用户名:"+t._s(e.user.userName))]),s("p",[t._v("评论内容:"+t._s(e.commentContent))])])]})],2),s("div",{staticClass:"cart-div"},[s("Card",{staticClass:"shopcart"},[s("p",{attrs:{slot:"title"},slot:"title"},[t._v("购物车")]),s("a",{attrs:{slot:"extra"},on:{click:t.clearCartButton},slot:"extra"},[t._v("清空")]),t._l(t.shopcartList,function(e){return[s("div",{key:e.foodId},[s("hr"),s("Row",[s("Col",{attrs:{span:"5"}},[t._v(t._s(e.foodName))]),s("Col",{attrs:{span:"10"}},[s("ButtonGroup",{key:e.foodId},[s("Button",{attrs:{type:"primary"},on:{click:function(s){return t.cartReduceOneFood(e)}}},[t._v("-")]),s("Button",[t._v(t._s(e.foodNum))]),s("Button",{attrs:{type:"primary"},on:{click:function(s){return t.foodAddNum(e)}}},[t._v("+")])],1)],1),s("Col",{attrs:{span:"5"}},[t._v("数量:"+t._s(e.foodNum))])],1)],1)]}),s("hr"),s("b",{staticClass:"allPrice"},[t._v("￥"+t._s(t.cartObj.allPrice))]),s("Button",{staticClass:"makebutton",attrs:{type:"success"},on:{click:t.goOrderPage}},[t._v("去结算")])],2)],1)])],1)},o=[],c=s("4ec3"),n=s("5118"),r={data(){return{canteenId:this.$route.query.canteenId,canteenObj:{},collectState:!1,user:"",foodList:"",shopcartList:[],cartButtonShow:!0,cartObj:"",commentList:[]}},mounted(){this.user=JSON.parse(localStorage.getItem("user"));let t={canteenId:this.canteenId};this.getFoodList(),Object(c["r"])(t).then(t=>{this.canteenObj=t.data.data},t=>{this.$Message.error("网络错误")});let e={canteenId:this.canteenId,userId:this.user.userId};Object(c["G"])(e).then(t=>{t.data.data?this.collectState=!0:this.collectState=!1},t=>{this.$Message.error("网络错误")});let s={userId:this.user.userId};Object(c["D"])(s).then(t=>{let e=t.data.data;this.shopcartList=e.foodVoList,this.cartObj=e.cart})},methods:{getFoodList(){this.commentList=[];let t={canteenId:this.canteenId};Object(c["B"])(t).then(t=>{this.foodList=t.data.data})},foodDesc(){this.commentList=[];let t={canteenId:this.canteenId};Object(c["C"])(t).then(t=>{this.foodList=t.data.data})},commentPage(){this.foodList=[];let t={canteenId:this.canteenId};Object(c["A"])(t).then(t=>{this.commentList=t.data.data})},goOrderPage(){0!=this.shopcartList.length?this.$router.push({name:"orderpage"}):this.$Message.error("亲，还没选择商品")},selectName(t){let e={foodName:t,canteenId:this.canteenId};Object(c["y"])(e).then(t=>{this.foodList=t.data.data})},clearCartButton(){let t={cartId:this.user.cartId};Object(c["h"])(t).then(t=>{this.$router.push({name:"blank"}),Object(n["setTimeout"])(()=>{this.$router.push({name:"clientFoodList",query:{canteenId:this.canteenId}})},1)})},foodAddNum(t){let e={foodId:t.foodId,cartId:this.user.cartId,userId:this.user.userId};Object(c["n"])(e).then(t=>{let e=t.data.data;this.shopcartList=e.foodVoList,this.cartObj=e.cart})},cartReduceOneFood(t){let e={foodId:t.foodId,cartId:this.user.cartId,userId:this.user.userId};Object(c["o"])(e).then(t=>{let e=t.data.data;this.shopcartList=e.foodVoList,this.cartObj=e.cart})},collect(){let t={userId:this.user.userId,canteenId:this.canteenObj.canteenId};this.collectState?Object(c["f"])(t).then(t=>{200==t.data.status&&this.$Message.success("取消收藏成功")}):Object(c["i"])(t).then(t=>{200==t.data.status&&this.$Message.success("收藏成功")}),this.collectState=!this.collectState}}},i=r,d=(s("aaba"),s("2877")),l=Object(d["a"])(i,a,o,!1,null,"4f9c6ba3",null);e["default"]=l.exports},aaba:function(t,e,s){"use strict";var a=s("e3b0"),o=s.n(a);o.a},e3b0:function(t,e,s){}}]);
//# sourceMappingURL=chunk-4439f8ba.83863290.js.map