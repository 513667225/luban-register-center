# luban-register-center



具体的业务代码并未发布() 主要是吧项目架构与功能衔接发布出来了  业务实现你们可以根据自己的想法去实现 并且探索更优的方案 实现思路我有在视频介绍里面讲解

如果需要吧这个项目跑起来的话

首先得吧server 模块 和 server-spring-boot-start模块打包成你的maven 本地依赖

或者你直接在luban-register-center里面建立你自己的模块也行  这样能直接依赖

maven打包本地依赖教学我写在了server 的pom里面 也可以自行百度


测试链接在server模块里面的ApplicationController里面

视频介绍地址:https://www.bilibili.com/video/av74029764


后面有一些改动没有做视频解释 后续有时间会出视频
视频未解释的内容：
  1:LubanDispatcherServlet 里面加了解析jar包的改动 主要是解决 吧模块打成jar包之后解析不到class文件(主要是解析不到ApplicationController)的问题
  2: 吧原来server里面的cloud包独立出来成为server-spring-boot-start模块


client暂时还未去设计 等有时间的时候会提交 你们也可以根据server来扩展client
  
  
  
  
  
