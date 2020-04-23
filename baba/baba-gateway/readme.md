
调试完成后，以下链接，可通过网关去访问：
http://localhost:10100/api/user-service/user/list2
http://localhost:10100/api/user-service/user/03e5205e8899fcba680671b900bae271

健康检查，不用去写controller写接口来测试了，使用actuator框架
http://127.0.0.1:10100/api/user/actuator/info
