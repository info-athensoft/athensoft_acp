package com.athensoft.ecomm.order.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.athensoft.ecomm.order.entity.Order;
import com.athensoft.ecomm.order.entity.OrderItem;

@Component
@Qualifier("orderItemDaoJDBCImpl")
public class OrderItemDaoJDBCImpl implements OrderItemDao {
	
	private static final Logger logger = Logger.getLogger(OrderItemDaoJDBCImpl.class);

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<OrderItem> findByOrderId(long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findByOrderId(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findByOrderNo(String orderNo) {
		
		String sql = "select * from orders_item where order_no =:order_no";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("order_no", orderNo);
		List<OrderItem> x = new ArrayList<OrderItem>();
		try{
			x = jdbc.query(sql, paramSource, new OrderItemRowMapper());
		}catch(Exception ex){
			ex.printStackTrace();
			x = null;
		}
		return x;
	}

	@Override
	public List<OrderItem> findByOrderNo(Order order) {
		String orderNo = "";
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
				
		if(order!=null){
			orderNo = order.getOrderNo();
			orderItemList = findByOrderNo(orderNo);
		}
		return orderItemList;
	}
	
	private static class OrderItemRowMapper implements RowMapper<OrderItem>{
		public OrderItem mapRow(ResultSet rs, int rowNumber) throws SQLException {
			OrderItem x = new OrderItem();
			x.setOrderItemId(rs.getLong("order_item_id"));
			x.setOrderNo(rs.getString("order_no"));
			x.setSeqNo(rs.getInt("seqno"));
			x.setItemId(rs.getLong("item_id"));
			x.setItemName(rs.getString("item_name"));
			x.setItemDesc(rs.getString("item_desc"));
			x.setQuantity(rs.getInt("quantity"));
			x.setUnit(rs.getString("unit"));
			x.setUnitPrice(rs.getDouble("unit_price"));
			x.setAmount(rs.getDouble("amount"));
	        return x;
		}		
	}

}
