# noname技术论坛
## 线上演示地址
http://47.115.23.189:8080/

## 项目效果图
 

## 本地运行指南
1、确保本地安装了JDK8以及Maven等工具
2、将代码clone到本地  
`git clone httpgit@github.com:gakei/noname.git`  
3、运行打包命令  
`mvn package`  
5、导入数据表  
使用`mvn flyway:migrate`导入数据表  
4、运行项目  
`java -jar target/gs-spring-boot-0.1.0.jar`  
6、访问项目  
在浏览器访问栏输入`http://localhost:8080`进行访问

## 功能列表
开源论坛、问答系统，现有功能提问、回复、通知、最新等功能。

## 线上部署
本项目利用了Docker进行线上部署，请确保你的服务器安装了Docker  
1、将`gs-spring-boot-0.1.0.jar`和Dockerfile上传至服务器  
2、使用`docker build . -t my-app`将`gs-spring-boot-0.1.0.jar`打包成Docker image  
3、使用`docker run -it -p 8080:8080 my-app`创建一个新的容器运行命令  
部署完成
