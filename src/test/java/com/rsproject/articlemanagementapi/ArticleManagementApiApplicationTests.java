package com.rsproject.articlemanagementapi;

import com.rsproject.articlemanagementapi.model.Article;
import com.rsproject.articlemanagementapi.repo.ArticleRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArticleManagementApiApplicationTests {

		@Autowired
		ArticleRepo articleRepo;

		@Test
		@Order(1)
		public void testCreate() {
			Article article = new Article();
			article.setId(1L);
			article.setTitle("Testing create method");
			article.setAbstrct("Abstract of testing create article");
			article.setArticle("This article is from the testCreate JUnit");
			List<String> authors = Arrays.asList("author1", "author2", "author3");
			article.setAuthors(authors);
			articleRepo.save(article);
			Assertions.assertNotNull(articleRepo.findById(1L));
		}

		@Test
		@Order(2)
		public void testReadAll() {
			List<Article> all_articles = articleRepo.findAll();
			assertThat(all_articles).size().isGreaterThan(0);
		}

		@Test
		@Order(3)
		public void testReadSingle() {
			Article searchedArticle = articleRepo.findById(1L).get();
			Assertions.assertEquals("This article is from the testCreate JUnit", searchedArticle.getArticle());
			assertThat(searchedArticle).toString().equals("Article{id=1, title='Testing create method', " +
					"authors='[author1, author2, author3]', abstrct='Abstract of testing create article', " +
					"article='This article is from the testCreate JUnit', approved=false}");
		}

		@Test
		@Order(4)
		public void testUpdate() {
			Article article = articleRepo.findById(1L).get();
			article.setTitle("testCreate article was update by testUpdate");
			articleRepo.save(article);
			Assertions.assertEquals("testCreate article was update by testUpdate", articleRepo.findById(1L).get().getTitle());
		}

		@Test
		@Order(5)
		public void testDelete() {
			articleRepo.deleteById(1L);
			assertThat(articleRepo.existsById(1L)).isFalse();
		}
}
