/**
 * 
 */
package com.vks.xebia.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vks.xebia.app.model.Article;

/**
 * @author Admin
 *
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {

}
