package com.example.cloud.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ValidateTokenFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext() ;
		HttpServletRequest request = context.getRequest() ;
		
		Boolean bool = Boolean.valueOf(request.getParameter("token")) ;
		
		if(bool) {
			context.setResponseStatusCode(200);
			context.setSendZuulResponse(true);
			context.set("isSuccess", true);
		}else {
			context.setResponseStatusCode(400);
			context.setSendZuulResponse(false);
			context.set("isSuccess", false);			
		}
		
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 100;
	}

}
