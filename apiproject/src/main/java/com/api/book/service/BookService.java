package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Books;




@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

//	private static List<Books> list = new ArrayList<>();
//	static
//	{
//		list.add(new Books(1,"Java","James Goslin"));
//		list.add(new Books(2,"Python","Adam"));
//		list.add(new Books(3,"C++","Moruee"));
//	}
	
	//get all books
	public List<Books> getAllBooks()
	{
		List<Books> list = ( List<Books>) this.bookRepository.findAll();
		return list;
	}
	
	//get book by id
	public Books getBookById(int id)
	{
		Books books  = null;
		try {
//			books = list.stream().filter(e ->e.getId()==id).findFirst().get();
			books = this.bookRepository.findById(id);
		} catch (Exception e2) {
			
			System.out.println("No Such element found");
		}
		
		return books;
	}
	
	//Add Books using post method
	public Books addBook(Books books)
	{
//		list.add(books);
		Books b= this.bookRepository.save(books);
		return b;
	}
	
	//Delete Book 
	
	public void deleteBook(int id)
	{
//		list = list.stream().filter(b -> b.getId()!=id).collect(Collectors.toList());
		this.bookRepository.deleteById(id);
	}
	
	//Update Books
	
	public void updateBook(Books books,int id)
	{
//		list = list.stream().map(b -> {
//			if(b.getId()==id)
//			{
//				b.setId(books.getId());
//				b.setTitle(books.getTitle());
//				b.setAuthor(b.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		bookRepository.save(books);
	}
}
