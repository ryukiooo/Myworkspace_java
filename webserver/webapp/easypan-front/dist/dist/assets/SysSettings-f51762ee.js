import{j as v,r as d,ag as m,o as y,c as b,V as r,P as s,a3 as V,T as _}from"./@vue-3886a262.js";import{u as x,b as E}from"./vue-router-6d9ab4b6.js";import{_ as C}from"./index-db517136.js";import"./element-plus-485a4a99.js";import"./lodash-es-36eb724a.js";import"./@vueuse-08bf1a74.js";import"./@element-plus-4ca69592.js";import"./@popperjs-c75af06c.js";import"./@ctrl-f8748455.js";import"./dayjs-5d216acc.js";import"./aplayer-585df14e.js";import"./async-validator-10c6301d.js";import"./memoize-one-297ddbcb.js";import"./escape-html-9626137c.js";import"./normalize-wheel-es-ed76fb12.js";import"./@floating-ui-8a8891e3.js";import"./vue-cookies-fc2d14d9.js";import"./@highlightjs-e10ea536.js";import"./highlight.js-6845818c.js";import"./axios-4a70c6fc.js";import"./docx-preview-8cc7001d.js";import"./jszip-1f4bc9a3.js";import"./xlsx-74460a39.js";import"./vue-pdf-embed-608804e8.js";import"./vue-0ba3f033.js";import"./dplayer-d4a41b2a.js";import"./vue-clipboard3-6d269bab.js";import"./clipboard-65322c36.js";const U={class:"sys-setting-panel"},I={__name:"SysSettings",setup(R){const{proxy:l}=v();x(),E();const p={getSysSettings:"/admin/getSysSettings",saveSettings:"/admin/saveSysSettings"},t=d({}),u=d(),c={registerEmailTitle:[{required:!0,message:"请输入注册邮件验证码邮件标题"}],registerEmailContent:[{required:!0,message:"请输入注册邮件验证码邮件内容"}],userInitUseSpace:[{required:!0,message:"请输入初始化空间大小"},{validator:l.Verify.number,message:"空间大小只能是数字"}]};(async()=>{let a=await l.Request({url:p.getSysSettings});a&&(t.value=a.data)})();const g=async()=>{u.value.validate(async a=>{if(!a)return;let e=Object.assign({},t.value);await l.Request({url:p.saveSettings,params:e})&&l.Message.success("保存成功")})};return(a,e)=>{const i=m("el-input"),n=m("el-form-item"),f=m("el-button"),S=m("el-form");return y(),b("div",U,[r(S,{model:t.value,rules:c,ref_key:"formDataRef",ref:u,"label-width":"150px",onSubmit:e[3]||(e[3]=V(()=>{},["prevent"]))},{default:s(()=>[r(n,{label:"注册邮件标题",prop:"registerEmailTitle"},{default:s(()=>[r(i,{clearable:"",placeholder:"请输入注册邮件验证码邮件标题",modelValue:t.value.registerEmailTitle,"onUpdate:modelValue":e[0]||(e[0]=o=>t.value.registerEmailTitle=o)},null,8,["modelValue"])]),_:1}),r(n,{label:"注册邮件标题",prop:"registerEmailContent"},{default:s(()=>[r(i,{clearable:"",placeholder:"请输入注册邮件验证码邮件内容%s占位符为验证码内容",modelValue:t.value.registerEmailContent,"onUpdate:modelValue":e[1]||(e[1]=o=>t.value.registerEmailContent=o)},null,8,["modelValue"])]),_:1}),r(n,{label:"初始空间大小",prop:"userInitUseSpace"},{default:s(()=>[r(i,{clearable:"",placeholder:"初始空间大小",modelValue:t.value.userInitUseSpace,"onUpdate:modelValue":e[2]||(e[2]=o=>t.value.userInitUseSpace=o)},{suffix:s(()=>[_("MB")]),_:1},8,["modelValue"])]),_:1}),r(n,{label:"",prop:""},{default:s(()=>[r(f,{type:"primary",onClick:g},{default:s(()=>[_("保存")]),_:1})]),_:1})]),_:1},8,["model"])])}}},se=C(I,[["__scopeId","data-v-47267eef"]]);export{se as default};
