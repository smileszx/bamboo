### Spring MVC 请求流程
1. 请求到达前端控制器DispatcherServlet
2. DispatcherServlet查询处理映射器，确定请求应该发到哪个控制器
3. DispatcherServlet将请求发送给控制器
4. 控制器处理请求，产生模型及逻辑视图名，返回给DispatcherServlet
5. DispatcherServlet通过视图解析器将逻辑视图匹配为特定的视图实现
6. DispatcherServlet根据视图解析器确定的视图进行渲染实现
7. 视图使用模型数据渲染输出，通过相应对象传递给客户端


