package com.athensoft.ecomm.order.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.athensoft.ecomm.order.entity.Contact;
import com.athensoft.ecomm.order.entity.Order;

@Component
@Qualifier("orderDaoJDBCImpl")
public class OrderDaoJDBCImpl implements OrderDao{

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<Order> findAll() {
//		String sql = "select * from orders";

		String sql = "select * from view_orders";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		List<Order> x = new ArrayList<Order>();
		try{
			x = jdbc.query(sql, paramSource, new OrderRowMapper());
		}catch(Exception ex){
			x = null;
		}
		return x;
	}

	@Override
	public Order findById(long orderId) {
		String sql = "select * from orders where order_id =:order_id";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("order_id", orderId);
		Order x = null;
		try{
			x = jdbc.queryForObject(sql, paramSource, new OrderRowMapper());
		}catch(Exception ex){
			x = null;
		}
		return x;
	}
	
	@Override
	public Order findByNo(String orderNo) {
		String sql = "select * from orders where order_no =:order_no";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("order_no", orderNo);
		Order x = null;
		try{
			x = jdbc.queryForObject(sql, paramSource, new OrderRowMapper());
		}catch(Exception ex){
			x = null;
		}
		return x;
	}
	
	private static class OrderRowMapper implements RowMapper<Order>{
		public Order mapRow(ResultSet rs, int rowNumber) throws SQLException {
			Order x = new Order();
			x.setOrderId(rs.getLong("order_id"));
			x.setOrderNo(rs.getString("order_no"));
			x.setOrderDateTime(rs.getString("order_datetime"));
			x.setOrderStatus(rs.getInt("order_status"));
			x.setGrandTotalAmount(rs.getDouble("grand_total_amount"));
			x.setPaymentMethod(rs.getInt("payment_method"));
			
			Contact customerContact = new Contact();
			customerContact.setEntityName(rs.getString("entity_name"));
            return x;
		}		
	}

}
