package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Model.BookService;
import Model.Customer;

public class BookingDao {
	public static void insertBooiking(BookService b) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into book_service(cid,sid,ser_id,booking_price,booking_status,payment_status) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, b.getCid());
			pst.setInt(2, b.getSid());
			pst.setInt(3, b.getSer_id());
			pst.setInt(4, b.getSprice());
			pst.setString(5, b.getBooking_status());
			pst.setString(6, b.getPayment_status());
			pst.executeUpdate();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public static List<BookService> getPendingServiceByCid(int id){
			List<BookService> list=new ArrayList<BookService>();
			try {
				 Connection con=DBConnection.createConnection();
				 String sql="select * from book_service where id=?";
				 PreparedStatement pst=con.prepareStatement(sql);
				 pst.setInt(1, id);
				 ResultSet rs=pst.executeQuery();
				 if(rs.next()) {
					 BookService b=new BookService();
					 b.setBid(rs.getInt("bid"));
					 b.setCid(rs.getInt("cid"));
					 b.setSid(rs.getInt("sid"));
					 b.setSprice(rs.getInt("booking_price"));
					 b.setBooking_status(rs.getString("booking_status"));
					 b.setPayment_status(rs.getString("payment_status"));
					 list.add(b);
				 }
				 System.out.println("done");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}
	public static List<BookService> getPendingServiceBySid(int id){
		List<BookService> list=new ArrayList<BookService>();
		try {
			 Connection con=DBConnection.createConnection();
			 String sql="select * from book_service where id=?";
			 PreparedStatement pst=con.prepareStatement(sql);
			 pst.setInt(1, id);
			 ResultSet rs=pst.executeQuery();
			 if(rs.next()) {
				 BookService b=new BookService();
				 b.setBid(rs.getInt("bid"));
				 b.setCid(rs.getInt("cid"));
				 b.setSid(rs.getInt("sid"));
				 b.setSprice(rs.getInt("booking_price"));
				 b.setBooking_status(rs.getString("booking_status"));
				 b.setPayment_status(rs.getString("payment_status"));
				 list.add(b);
			 }
			 System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<BookService> getPendingServiceForCustomerById(int cid){
		List<BookService> list=new ArrayList<BookService>();
		try {
			Connection con=DBConnection.createConnection();
			String sql ="select * from book_service where cid=? and booking_status='pending'";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, cid);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				BookService b=new BookService();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setSid(rs.getInt("sid"));
				b.setSprice(rs.getInt("booking_price"));
				b.setBooking_status(rs.getString("booking_status"));
				b.setPayment_status(rs.getString("payment_status"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static List<BookService> getPendingServiceForServicemanById(int sid){
		List<BookService> list=new ArrayList<BookService>();
		try {
			Connection con=DBConnection.createConnection();
			String sql ="select * from book_service where ser_id=? and booking_status='pending'";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, sid);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				BookService b=new BookService();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setSid(rs.getInt("sid"));
				b.setSprice(rs.getInt("booking_price"));
				b.setBooking_status(rs.getString("booking_status"));
				b.setPayment_status(rs.getString("payment_status"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void updateBookingStatus(int bid) {
		try {
			Connection con=DBConnection.createConnection();
			String sql="update book_service set booking_status='confirm' where bid=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, bid);
			pst.executeUpdate();
			System.out.println("status Update");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<BookService> getConfirmServiceForCustomer(int cid){
		List<BookService> list = new ArrayList<BookService>();
		try {
			Connection con = DBConnection.createConnection();
			String sql="select * from book_service where cid=? and booking_status='confirm'";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				BookService b = new BookService();
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setSid(rs.getInt("sid"));
				b.setSprice(rs.getInt("booking_price"));
				b.setBooking_status(rs.getString("booking_status"));
				b.setPayment_status(rs.getString("payment_status"));
				list.add(b);
			}
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Customer getEmail(int cid) {
	      Customer c1=null;
	      try {
	    	  Connection con = DBConnection.createConnection();
				String sql="select * from customer where cid=? and booking_status='confirm'";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1, cid);
				ResultSet rs=pst.executeQuery();
				if(rs.next()) {
					c1=new Customer();
					c1.setId(rs.getInt("cid"));
					c1.setEmail(rs.getString("email"));
				}
				   		
		} catch (Exception e) {
	       e.printStackTrace();
	}
		
		
		return c1;
	}
}
