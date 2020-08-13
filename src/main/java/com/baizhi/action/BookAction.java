package com.baizhi.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	private List<Book> list;
	private String key;
	private String content;
	private Book book;
	private File cover;
	private String coverFileName;
	private String coverContentType;
	private List<Category> clist;
	private List<Book> recommends;
	private List<Book> hots;
	private List<Book> news;
	private List<Book> newAndHot;
	private String fid;
	private String sid;
	private Category category;
	private Integer pageSize=4;
	private Integer pageNum;
	private Integer count;
	
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Book> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<Book> recommends) {
		this.recommends = recommends;
	}

	public List<Book> getHots() {
		return hots;
	}

	public void setHots(List<Book> hots) {
		this.hots = hots;
	}

	public List<Book> getNews() {
		return news;
	}

	public void setNews(List<Book> news) {
		this.news = news;
	}

	public List<Book> getNewAndHot() {
		return newAndHot;
	}

	public void setNewAndHot(List<Book> newAndHot) {
		this.newAndHot = newAndHot;
	}

	public List<Category> getClist() {
		return clist;
	}

	public void setClist(List<Category> clist) {
		this.clist = clist;
	}

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public String getCoverContentType() {
		return coverContentType;
	}

	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}
	//展示所有页面
	public String queryAll(){
		BookService service=new BookServiceImpl();
		list=service.queryAll();
		return "success";
	}
	//按条件模糊查询
	public String queryByKey(){
		BookService service=new BookServiceImpl();
		list=service.queryByKey(key, content);
		return "success";
	}
	//添加图书
	public String addOneBook(){
		BookService service=new BookServiceImpl();
		
		book.setCover(coverFileName);
		boolean tag=service.addOneBook(book);
		if(tag==true){
			String path=ServletActionContext.getServletContext().getRealPath("/back/img");
			try {
				FileUtils.copyFile(cover, new File(path+"//"+coverFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
		return "success";
	}
	//根据id查询图书
	public String queryById(){
		BookService service=new BookServiceImpl();
		book=service.queryById(book.getId());
	
		CategoryService cservice=new CategoryServiceImpl();
		clist=cservice.queryAllSecond();
		
		return "success";
	}
	//更新图书
	public String updateOneBook(){
		//System.out.println("1");
		BookService service=new BookServiceImpl();
		if(coverFileName!=null){
			String path=ServletActionContext.getServletContext().getRealPath("/back/img");
			try {
				FileUtils.copyFile(cover, new File(path+"//"+coverFileName));
				book.setCover(coverFileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		//System.out.println("2");
		service.updateOneBook(book);
		//System.out.println("3");
		return "success";
	}
	
	//删除图书
	public String deleteOneBook(){
		BookService service=new BookServiceImpl();
		service.deleteOneBook(book.getId());
		return "success";
	}
	//展示一级页面
	public String main(){
		CategoryService cservice=new CategoryServiceImpl();
		BookService service=new BookServiceImpl();
		clist=cservice.queryFirst();
		recommends=service.queryRecommend();
		hots=service.queryHots();
		news=service.queryNews();
		newAndHot=service.queryNewAndHot();
		return "success";
	}
	//展示二级页面
	public String second(){
		BookService service=new BookServiceImpl();
		count=service.queryCount(fid, sid, pageSize);
		if(pageNum==null || pageNum<=0) {
			pageNum=1;
		}			
		if(pageNum>count){
			pageNum=count;
		} 
		CategoryService cservice=new CategoryServiceImpl();
		
		category=cservice.queryOneFirst(fid);
		list=service.querySecondByPage(fid, sid,pageSize,pageNum);
		return "success";
	}
	//展示图书详细信息
	public String showDetail(){
		BookService service=new BookServiceImpl();
		book=service.queryById(book.getId());
		return "success";
	}
}
