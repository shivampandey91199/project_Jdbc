package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Model.ServicemanServicess;

public class ServicemanServiceDao {
	public static void insertService(ServicemanServicess s) {
		try {
			Connection con = DBConnection.createConnection();
			String sql = "insert into service(s_id,s_name,s_price,s_duration,s_cetagory)values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, s.getServiceman_id());
			pst.setString(2, s.getService_name());
			pst.setInt(3, s.getSprice());
			pst.setString(4, s.getService_duration());
			pst.setString(5, s.getService_category());
			pst.executeUpdate();
			System.out.println("Service Upload");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<ServicemanServicess> getServicemanListById(int id) {
		List<ServicemanServicess> list = new ArrayList<ServicemanServicess>();
		try {
			Connection con = DBConnection.createConnection();
			String sql = "select * from Service where s_id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ServicemanServicess s = new ServicemanServicess();
				s.setSid(rs.getInt("sid"));
				s.setServiceman_id(rs.getInt("s_id"));
				s.setService_name(rs.getString("s_name"));
				s.setSprice(rs.getInt("s_price"));
				s.setService_duration(rs.getString("s_duration"));
				s.setService_category(rs.getString("s_cetagory"));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ServicemanServicess getServiceById(int id) {
		ServicemanServicess s = null;
		try {
			Connection con = DBConnection.createConnection();
			String sql = "select * from Service where sid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				s = new ServicemanServicess();
				s.setSid(rs.getInt("sid"));
				s.setServiceman_id(rs.getInt("s_id"));
				s.setService_name(rs.getString("s_name"));
				s.setSprice(rs.getInt("s_price"));
				s.setService_duration(rs.getString("s_duration"));
				s.setService_category(rs.getString("s_cetagory"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
       return s;
	}
	public static void updateService(ServicemanServicess s) {
		try {
			Connection con=DBConnection.createConnection();
			String sql="update service set s_name = ?,s_price=?,s_duration=?,s_cetagory=? where sid=?";
			PreparedStatement pst=con.prepareStatement(sql);
			  pst.setString(1, s.getService_name());
			  pst.setInt(2, s.getSprice());
			  pst.setString(3, s.getService_duration());
			  pst.setString(4, s.getService_category());
			  pst.setInt(5, s.getSid());
			  pst.executeUpdate();
			System.out.println("Service Update");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteService(int id) {
		try {
			Connection con=DBConnection.createConnection();
			String sql="delete from service where sid=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<ServicemanServicess> getAllServices() {
		List<ServicemanServicess> list = new ArrayList<ServicemanServicess>();
		try {
			Connection con = DBConnection.createConnection();
			String sql = "select * from service";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ServicemanServicess s = new ServicemanServicess();
				s.setSid(rs.getInt("sid"));
				s.setServiceman_id(rs.getInt("s_id"));
				s.setService_name(rs.getString("s_name"));
				s.setSprice(rs.getInt("s_price"));
				s.setService_duration(rs.getString("s_duration"));
				s.setService_category(rs.getString("s_cetagory"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
      
}
