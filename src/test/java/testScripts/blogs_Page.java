package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pomPages.saadiyat_blog;

public class blogs_Page extends BaseClass {

	@Test
	public void blog_listing_page_tc() throws IOException, InterruptedException {
		saadiyat_blog blogs = new saadiyat_blog(driver);
		blogs.blog_Page(driver);
	}

	@Test
	public void blog_details_page_tc() throws IOException, InterruptedException {
		saadiyat_blog blogs = new saadiyat_blog(driver);
		blogs.blog_details();
		System.out.println("=============Social media ==================");
		blogs.social_media(driver);

		System.out.println("==========Trending posts======================");
		blogs.trending_posts(driver);

		System.out.println("==========Related posts======================");
		blogs.related_posts(driver);
	}
}
