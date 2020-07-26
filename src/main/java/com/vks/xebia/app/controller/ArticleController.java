/**
 * 
 */
package com.vks.xebia.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vks.xebia.app.exception.ArticleNotFoundException;
import com.vks.xebia.app.model.Article;
import com.vks.xebia.app.service.ArticleService;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping("/ArticleService")
public class ArticleController {
	
	
	
	@Autowired
	ArticleService articleService;
	
	@GetMapping("/Articles/{articleId}")
	public ResponseEntity<Article>  getArticle(@PathVariable  Integer articleId) throws ArticleNotFoundException {
		Article article =articleService.getArticle(articleId);
		
		if (article== null) {
			throw new ArticleNotFoundException(articleId, "Article Not Found for Article Id="+articleId);
		}
		
		return new ResponseEntity<Article>(article,HttpStatus.FOUND);
		
	}
	
	@PostMapping("/Articles")
	public ResponseEntity<Article>  createArticle(@RequestBody  Article article) {
		if (StringUtils.isEmpty(article.getTitle()) || StringUtils.isEmpty(article.getDescription()) ||  StringUtils.isEmpty(article.getBody())) {
			return new ResponseEntity<Article>(HttpStatus.BAD_REQUEST);
		}
		Article articleSaved = articleService.createArticle(article);
		return new ResponseEntity<Article>(articleSaved,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/Articles")
	public ResponseEntity<Article>  updateArticle(@RequestBody  Article article) {
		if (StringUtils.isEmpty(article.getTitle()) || StringUtils.isEmpty(article.getDescription()) ||  StringUtils.isEmpty(article.getBody())) {
			return new ResponseEntity<Article>(HttpStatus.BAD_REQUEST);
		}
		Article articleSaved = articleService.updateArticle(article);
		return new ResponseEntity<Article>(articleSaved,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/Articles/{articleId}")
	public ResponseEntity<Article>  deletArticle(@PathVariable  Integer articleId) throws ArticleNotFoundException {
		Boolean isDeleted =articleService.deleteArticle(articleId);
		if (!isDeleted) {
			throw new ArticleNotFoundException(articleId, "Article Not Found for Article Id="+articleId);
		}
		return new ResponseEntity<Article>(HttpStatus.OK);
		
	}
	
	

}
