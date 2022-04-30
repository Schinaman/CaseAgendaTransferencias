//package com.guigo.projeto.resources;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/articles")
//public class ArticleResource {
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public String listar(){
//		return "Rest funcionando";
//	}
//	
////	@Autowired
////	private ArticleService service;
////	
////	
////	@RequestMapping(method=RequestMethod.GET)
////	public ResponseEntity<List<ArticleDTO>> findAll(){
////		List<Article> list = service.findAll();
////		List<ArticleDTO> listDto = list.stream().map(obj -> new ArticleDTO(obj)).collect(Collectors.toList());
////		return ResponseEntity.ok(listDto);
////	}
//}