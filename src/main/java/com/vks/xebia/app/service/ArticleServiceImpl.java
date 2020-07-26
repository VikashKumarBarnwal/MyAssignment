/**
 * 
 */
package com.vks.xebia.app.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vks.xebia.app.dao.ArticleDao;
import com.vks.xebia.app.model.Article;

/**
 * @author Admin
 *
 */

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleDao  articleDao;

	@Override
	public List<Article> getArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article createArticle(Article article) {
		Calendar cal =  Calendar.getInstance();
		article.setCreatedAt(cal.getTime());
		article.setUpdatedAt(cal.getTime());
		populateSlug(article);
		return articleDao.save(article);
	}

	private void populateSlug(Article article) {
		String slug = article.getTitle().replaceAll(" ", "-");
		article.setSlug(slug);
	}

	@Override
	public Article updateArticle(Article article) {
		Calendar cal =  Calendar.getInstance();
		
		Article articleSaved=articleDao.getOne(article.getId());
		articleSaved.setTitle(article.getTitle());
		articleSaved.setDescription(article.getDescription());
		articleSaved.setBody(article.getBody());
		populateSlug(articleSaved);
		articleSaved.setUpdatedAt(cal.getTime());
		return articleDao.save(articleSaved);
	}

	@Override
	public Article getArticle(Integer articleId) {
		Optional<Article> optional = articleDao.findById(articleId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Boolean deleteArticle(Integer articleId) {
		Boolean isSuccess = Boolean.FALSE;
		Optional<Article> optional = articleDao.findById(articleId);
		if(optional.isPresent()) {
			articleDao.deleteById(articleId);
			isSuccess = Boolean.TRUE;
		}
		return isSuccess;
	}

}
