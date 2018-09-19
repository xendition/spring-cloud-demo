package com.michael.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Token 过滤,过滤器如果需要被使用,需要被实例化
 * <pre>
 *  _@Bean
 *  public TokenFilter tokenFilter(){
 *      return new TokenFilter();
 *  }
 *
 * </pre>
 *
 * @author Michael
 * @date 2018/9/17.
 */
public class TokenFilter extends ZuulFilter {

    /**
     * <pre>
     *  四种类型：pre,routing,error,post
     *  1. pre：主要用在路由映射的阶段是寻找路由映射表的
     *  2. routing:具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用
     *  3. error:一旦前面的过滤器出错了，会调用error过滤器。
     *  4. post:当routing，error运行完后才会调用该过滤器，是在最后阶段的
     * </pre>
     *
     * @return 当前过滤器类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 自定义过滤器执行的顺序，数值越大越靠后执行，越小就越先执行
     *
     * @return 当前过滤器执行编号, 编号越小越靠前
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 控制过滤器生效不生效，可以在里面写一串逻辑来控制
     *
     * @return 当前过滤器是否生效
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 执行过滤逻辑
     */
    @Override
    public Object run() {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        // Token 应该从请求头里面获取,此处简化
        String token = request.getParameter("token");
        if (token == null) {

            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            context.setResponseBody("{\"errorMsg\":\"非法的Token\"}");

            context.getResponse().setContentType("application/json;charset=utf-8");
        }
        return null;
    }
}
