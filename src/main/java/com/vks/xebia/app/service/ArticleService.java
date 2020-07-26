/**
 * 
 */
package com.vks.xebia.app.service;

import java.util.List;

import com.vks.xebia.app.model.Article;

/**
 * @author Admin
 *
 */
public interface ArticleService {
	
	public List<Article> getArticles();
	public Article createArticle(Article article);
	public Article updateArticle(Article article);
	public Article getArticle(Integer articleId);
	public Boolean deleteArticle(Integer articleId);

}
