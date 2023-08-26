package com.spring.pos.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.pos.model.Category;
import com.spring.pos.model.Product;
import com.spring.pos.model.request.ProductForm;
import com.spring.pos.model.response.ProductResponse;
import com.spring.pos.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/product/{id}")
	public ResponseStatus getProductById(@PathVariable int id, @RequestParam(required = false) boolean detail,
			HttpServletRequest request) throws Exception {
		Product product = service.getById(id);
		ResponseStatus response = new ResponseStatus(ResponseStatus.STATUS_NOTFOUND, "Product can not be found with id [" + id + "]");
		if (product == null) {
			return response;
		}
		
		String url = generateUrl(request, product);
		Object result = product;

		if (!detail) {
			result = new ProductResponse();
			BeanUtils.copyProperties(product, result);

			
			Category category = product.getCategory();
			int categoryId = category != null ? category.getCategoryID() : -1;
			
			((ProductResponse) result).setCategoryID(categoryId);
			((ProductResponse) result).setPhotoUrl(url);
			url = "";
		}

		response.setStatus(ResponseStatus.STATUS_FOUND);
		response.setResult(result);
		response.setMessages(url);
		return response;
	}

	//use postman with this since Swagger UI messed up the field
	@PostMapping(value = "/product", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseStatus insertProduct(@ModelAttribute ProductForm form, BindingResult binding, @RequestPart(required = false) MultipartFile photo, HttpServletRequest request) throws Exception {
		ResponseStatus responseStatus = new ResponseStatus(ResponseStatus.STATUS_USER_ERROR, "Input Error");
		Product product = service.insert(form, photo, responseStatus);
		if(product == null) {
			return responseStatus;
		}
		
		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);
		
		if(product.getPhoto() !=null && product.getPhoto().length > 0)
			productResponse.setPhotoUrl(generateUrl(request, productResponse.getProductID()));

		responseStatus.setStatus(ResponseStatus.STATUS_SUCCESS);
		responseStatus.setMessages("Product has been inserted");
		responseStatus.setResult(productResponse);

		return responseStatus;
	}

	@PatchMapping("/product/{id}")
	public ResponseStatus updateProduct(@PathVariable int id, @ModelAttribute ProductForm form, BindingResult binding,
			@RequestPart(required = false) MultipartFile photo, HttpServletRequest request) throws Exception {
		ResponseStatus response = new ResponseStatus(ResponseStatus.STATUS_NOTFOUND,
				"Product can not be found with id [" + id + "]");
		Product product = service.updateProductById(id, request, form, photo, response);
		if (product == null) {
			return response;
		}

		if (binding.hasErrors()) {
			List<ObjectError> errors = binding.getAllErrors();
			response.setStatus(ResponseStatus.STATUS_USER_ERROR);
			for (ObjectError error : errors) {
				response.addMessage(error.getDefaultMessage());
			}
			return response;
		}

		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);
		productResponse.setPhotoUrl(ProductController.generateUrl(request, product));

		response.setStatus(ResponseStatus.STATUS_SUCCESS);
		response.setMessages("");
		response.setResult(productResponse);
		return response;
	}

	@GetMapping(value = "/product/{id}/image", produces = { MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	public byte[] generateImageFromProductId(@PathVariable int id, HttpServletResponse response) {
		byte[] imageByte = new byte[0];
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		Product product = service.getById(id);
		if (product != null && product.getPhoto() != null && product.getPhoto().length > 0) {
			imageByte = product.getPhoto();
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
		}

		return imageByte;
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseStatus deleteProductById(@PathVariable int id, @RequestParam(required = false) boolean hardDelete) {
		boolean isDelete = service.deleteById(id, hardDelete);
		ResponseStatus response = new ResponseStatus(ResponseStatus.STATUS_NOTFOUND, "Product can not be found with id [" + id + "]");
		if(isDelete) {
			response.setStatus(ResponseStatus.STATUS_SUCCESS);
			response.setMessages("Product has been deleted");
		}
		
		return response;
	}

	public static String generateUrl(HttpServletRequest request, Product product) {
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int portNumber = request.getServerPort();
		String contextPath = request.getContextPath();

		String url = "";

		if (product != null && product.getPhoto() != null && product.getPhoto().length > 0) {
			url = scheme + ":" + serverName + ":" + portNumber + contextPath + "/product" + "/" + product.getProductID()
					+ "/image";
		}
		return url;
	}

	private String generateUrl(HttpServletRequest request, int id) {
		return request.getRequestURL() + "/" + id + "/image";
	}

}
