package com.kic.shopping.goods.vo;

import java.sql.Date;

public class GoodsVO {
	private int goods_id;
	private String goods_sort;
	private String goods_title;
	private String goods_writer;
	private String goods_publisher;
	private int goods_price;
	private int goods_sales_price;
	private int goods_point;
	private Date goods_published_date;
	private int goods_total_page;
	private String goods_isbn;
	private int goods_delivery_price;
	private Date goods_delivery_date;
	private String goods_status;
	private String goods_intro;
	private String goods_writer_intro;
	private String goods_publisher_comment;
	private String goods_recommedndation;
	private String goods_contents_order;
	private Date goods_credate;
	public GoodsVO() {
		
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_sort() {
		return goods_sort;
	}
	public void setGoods_sort(String goods_sort) {
		this.goods_sort = goods_sort;
	}
	public String getGoods_title() {
		return goods_title;
	}
	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}
	public String getGoods_writer() {
		return goods_writer;
	}
	public void setGoods_writer(String goods_writer) {
		this.goods_writer = goods_writer;
	}
	public String getGoods_publisher() {
		return goods_publisher;
	}
	public void setGoods_publisher(String goods_publisher) {
		this.goods_publisher = goods_publisher;
	}
	public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	public int getGoods_sales_price() {
		return goods_sales_price;
	}
	public void setGoods_sales_price(int goods_sales_price) {
		this.goods_sales_price = goods_sales_price;
	}
	public int getGoods_point() {
		return goods_point;
	}
	public void setGoods_point(int goods_point) {
		this.goods_point = goods_point;
	}
	public Date getGoods_published_date() {
		return goods_published_date;
	}
	public void setGoods_published_date(Date goods_published_date) {
		this.goods_published_date = goods_published_date;
	}
	public int getGoods_total_page() {
		return goods_total_page;
	}
	public void setGoods_total_page(int goods_total_page) {
		this.goods_total_page = goods_total_page;
	}
	public String getGoods_isbn() {
		return goods_isbn;
	}
	public void setGoods_isbn(String goods_isbn) {
		this.goods_isbn = goods_isbn;
	}
	public int getGoods_delivery_price() {
		return goods_delivery_price;
	}
	public void setGoods_delivery_price(int goods_delivery_price) {
		this.goods_delivery_price = goods_delivery_price;
	}
	public Date getGoods_delivery_date() {
		return goods_delivery_date;
	}
	public void setGoods_delivery_date(Date goods_delivery_date) {
		this.goods_delivery_date = goods_delivery_date;
	}
	public String getGoods_status() {
		return goods_status;
	}
	public void setGoods_status(String goods_status) {
		this.goods_status = goods_status;
	}
	public String getGoods_intro() {
		return goods_intro;
	}
	public void setGoods_intro(String goods_intro) {
		this.goods_intro = goods_intro;
	}
	public String getGoods_writer_intro() {
		return goods_writer_intro;
	}
	public void setGoods_writer_intro(String goods_writer_intro) {
		this.goods_writer_intro = goods_writer_intro;
	}
	public String getGoods_publisher_comment() {
		return goods_publisher_comment;
	}
	public void setGoods_publisher_comment(String goods_publisher_comment) {
		this.goods_publisher_comment = goods_publisher_comment;
	}
	public String getGoods_recommedndation() {
		return goods_recommedndation;
	}
	public void setGoods_recommedndation(String goods_recommedndation) {
		this.goods_recommedndation = goods_recommedndation;
	}
	public String getGoods_contents_order() {
		return goods_contents_order;
	}
	public void setGoods_contents_order(String goods_contents_order) {
		this.goods_contents_order = goods_contents_order;
	}
	public Date getGoods_credate() {
		return goods_credate;
	}
	public void setGoods_credate(Date goods_credate) {
		this.goods_credate = goods_credate;
	}
	@Override
	public String toString() {
		return "GoodsVO [goods_id=" + goods_id + ", goods_sort=" + goods_sort + ", goods_title=" + goods_title
				+ ", goods_writer=" + goods_writer + ", goods_publisher=" + goods_publisher + ", goods_price="
				+ goods_price + ", goods_sales_price=" + goods_sales_price + ", goods_point=" + goods_point
				+ ", goods_published_date=" + goods_published_date + ", goods_total_page=" + goods_total_page
				+ ", goods_isbn=" + goods_isbn + ", goods_delivery_price=" + goods_delivery_price
				+ ", goods_delivery_date=" + goods_delivery_date + ", goods_status=" + goods_status + ", goods_intro="
				+ goods_intro + ", goods_writer_intro=" + goods_writer_intro + ", goods_publisher_comment="
				+ goods_publisher_comment + ", goods_recommedndation=" + goods_recommedndation
				+ ", goods_contents_order=" + goods_contents_order + ", goods_credate=" + goods_credate + "]";
	}

}
