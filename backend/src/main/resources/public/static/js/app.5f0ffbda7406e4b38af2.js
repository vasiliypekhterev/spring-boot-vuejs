webpackJsonp([0],{0:function(e,t){},"23Sm":function(e,t){},IvWp:function(e,t,n){e.exports=n.p+"static/img/spring-boot-vuejs-logo.3ad77c6.png"},NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=n("7+uW"),o={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var r=n("VU/8")({name:"app"},o,!1,function(e){n("wL4e")},null,null).exports,a=n("/ocq"),i={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"hello"},[s("img",{attrs:{src:n("IvWp")}}),e._v(" "),s("h1",[e._v(e._s(e.msg))]),e._v(" "),s("h2",[e._v("See the sources here: ")]),e._v(" "),e._m(0),e._v(" "),s("h3",[e._v("This site contains more stuff :)")]),e._v(" "),e._m(1)])},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("ul",[t("li",[t("a",{attrs:{href:"https://github.com/jonashackt/spring-boot-vuejs",target:"_blank"}},[this._v("github.com/jonashackt/spring-boot-vuejs")])])])},function(){var e=this.$createElement,t=this._self._c||e;return t("ul",[t("li",[this._v("HowTo call REST-Services:")]),this._v(" "),t("li",[t("a",{attrs:{href:"/#/callservice/",target:"_blank"}},[this._v("/callservice")])]),this._v(" "),t("li",[this._v("HowTo to play around with Bootstrap UI components:")])])}]};var c=n("VU/8")({name:"hello",data:function(){return{msg:"Welcome to your Vue.js powered Spring Boot App"}}},i,!1,function(e){n("hHHK")},"data-v-4c9c1294",null).exports,l={name:"service",data:function(){return{msg:"HowTo call REST-Services:",response:[],errors:[]}},methods:{callRestService:function(){this.$http.get("api/hello").then(function(e){this.msg=e.data,this.response=e.data.body,console.log(e.data),console.log(e.data.body)})}}},v={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"service"},[n("h1",[e._v(e._s(e.msg))]),e._v(" "),n("h2",[e._v("REST service call results")]),e._v(" "),n("button",{on:{click:function(t){e.callRestService()}}},[e._v("CALL Spring Boot REST backend service")]),e._v(" "),n("h4",[e._v("Backend response: "+e._s(e.response))])])},staticRenderFns:[]};var u=n("VU/8")(l,v,!1,function(e){n("23Sm")},"data-v-bafa97de",null).exports;s.a.use(a.a);var p=new a.a({routes:[{path:"/",name:"Hello",component:c},{path:"/callservice",name:"Service",component:u}]}),h=n("8+8L");s.a.use(h.a),s.a.config.productionTip=!1,new s.a({el:"#app",router:p,template:"<App/>",components:{App:r}})},hHHK:function(e,t){},wL4e:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.5f0ffbda7406e4b38af2.js.map