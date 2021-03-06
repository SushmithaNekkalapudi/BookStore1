package com.cg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.dao.BookyDao;
import com.cg.dao.CategoryDao;
import com.cg.entity.Book;
import com.cg.entity.Category;
import com.cg.service.AdminService;
//import com.cg.sprint.bean.Appointment;
//import com.cg.sprint.dao.AdminRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class OnlineBookStoreApplicationTests {

	@Autowired
	private AdminService as;
		
	@MockBean
	CategoryDao crep;
	
	@Mock
	private BookyDao bd;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addCategoryTest() {
		Category c=new Category(101,"Horror",null);
		as.addCategory(c);
		assertEquals("Horror",c.getCategoryName());
	}
	
	@Test
	public void UpdateCategoryTest() {
		Category c=new Category(101,"Horror",null);
		as.addCategory(c);
		c.setCategoryName("fantasy");
		as.UpdateCategory(c);
		//verify(crep,times(1)).save(c);
		assertEquals("fantasy",c.getCategoryName());
	}
	
	
	/*
	@Test
	public void removeCategoryTest() {
		Category c=new Category(101,"Horror",null);
		as.removeCategory(c.getCategoryId());
		verify(crep,times(1)).delete(c);
		
	}
	*/
	@Test
	public void updateBookTest() throws java.text.ParseException{
		Book b=new Book(201,"The subtle art","Mark Manson","it's a breathtaking exp",3001,204.5,true);
		bd.findById(201);
		bd.save(b);
		verify(bd,Mockito.times(1)).save(b);
	}
	
	

}
