//package com.spring.pos.controller;
//
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TestController {
//
////	@GetMapping("/test")
////	public List<String> test(HttpServletRequest request) {
////		List<String> names = new ArrayList<String>();
////		names.add("jame");
////		names.add("john");
////		return names;
////	}
////
////	@GetMapping("/url")
////	public List<String> url(HttpServletRequest request) {
////		UrlPathHelper helper = new UrlPathHelper();
////		List<String> urls= new ArrayList<String>();
////		urls.add(helper.getContextPath(request));
////		urls.add(helper.getLookupPathForRequest(request));
////		urls.add(helper.getOriginatingContextPath(request));
////		urls.add(helper.getOriginatingQueryString(request));
////		urls.add(helper.getOriginatingServletPath(request));
////		urls.add(helper.getPathWithinApplication(request));
////		urls.add(helper.getRequestUri(request));
////		urls.add(helper.getServletPath(request));
//////		urls.add(helper.getResolvedLookupPath(request));
////		String serverName = request.getServerName();
////		int portNumber = request.getServerPort();
////		urls.add(serverName + ":" + portNumber);
////		return urls;
////	}
//	
////	@PostMapping(value = "/post", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
////	public ResponseStatus status(@Parameter(content = {Content = ME}) @RequestParam ProductForm name, @RequestParam(required = false) MultipartFile photo, HttpServletRequest request) {
////		ResponseStatus responseStatus = new ResponseStatus();
////		responseStatus.addMessage(name.toString());
////		responseStatus.addMessage("Phone is null = "+ (photo == null));
////		return responseStatus;
////	}
//
//}
