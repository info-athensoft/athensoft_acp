package com.athensoft.crm.customer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.athensoft.crm.customer.entity.ShipToAddress;
import com.athensoft.crm.customer.entity.ShipToContact;

@Component
@Qualifier("shipToContactDaoJDBCImpl")
public class ShipToContactDaoJDBCImpl implements ShipToContactDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<ShipToContact> findAll() {
		final String TABLE1 = "view_crm_shipto_contact";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append(" select * from "+TABLE1);
		String sql = sbf.toString();
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		List<ShipToContact> x = new ArrayList<ShipToContact>();
		try{
			x = jdbc.query(sql, paramSource, new ShipToContactRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}
	
	private static class ShipToContactRowMapper implements RowMapper<ShipToContact>{
		public ShipToContact mapRow(ResultSet rs, int rowNumber) throws SQLException {
			ShipToContact x = new ShipToContact();
			x.setContactId(rs.getLong("global_id"));
			x.setContactNo(rs.getString("contact_no"));
			x.setContactStatus(rs.getInt("contact_status"));
			x.setCustomerId(rs.getLong("customer_id"));
			x.setShiptoName(rs.getString("entity_name"));
			x.setEmail(rs.getString("email"));
			x.setTelNum(rs.getString("tel_num"));
			x.setCellNum(rs.getString("cell_num"));
			x.setFaxNum(rs.getString("fax_num"));
			
			ShipToAddress addr = new ShipToAddress();
			addr.setStreetNum(rs.getString("street_no"));
			addr.setStreetType(rs.getString("street_type"));
			addr.setStreetName(rs.getString("street_name"));
			addr.setUnitType(rs.getString("unit_type"));
			addr.setRoomNum(rs.getString("unit_no"));
			addr.setCityCode(rs.getString("city"));
			addr.setProvinceCode(rs.getString("province"));
			addr.setCountryCode(rs.getString("country"));
			addr.setPostalCode(rs.getString("postal_code"));
			
			x.setShiptoAddr(addr);
	        return x;
		}		
	}

}
