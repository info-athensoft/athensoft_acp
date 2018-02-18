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

import com.athensoft.crm.customer.entity.BillToAddress;
import com.athensoft.crm.customer.entity.BillToContact;

@Component
@Qualifier("billToContactDaoJDBCImpl")
public class BillToContactDaoJDBCImpl implements BillToContactDao {

	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<BillToContact> findAll() {
		final String TABLE1 = "view_crm_billto_contact";
		
		StringBuffer sbf = new StringBuffer();
		sbf.append(" select * from "+TABLE1);
		String sql = sbf.toString();
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		List<BillToContact> x = new ArrayList<BillToContact>();
		try{
			x = jdbc.query(sql, paramSource, new BillToContactRowMapper());
		}catch(EmptyResultDataAccessException ex){
			x = null;
		}
		return x;
	}
	
	private static class BillToContactRowMapper implements RowMapper<BillToContact>{
		public BillToContact mapRow(ResultSet rs, int rowNumber) throws SQLException {
			BillToContact x = new BillToContact();
			x.setContactId(rs.getLong("global_id"));
			x.setContactNo(rs.getString("contact_no"));
			x.setContactStatus(rs.getInt("contact_status"));
			x.setCustomerId(rs.getLong("customer_id"));
			x.setBilltoName(rs.getString("entity_name"));
			x.setEmail(rs.getString("email"));
			x.setTelNum(rs.getString("tel_num"));
			x.setCellNum(rs.getString("cell_num"));
			x.setFaxNum(rs.getString("fax_num"));
			
			BillToAddress addr = new BillToAddress();
			addr.setStreetNum(rs.getString("street_no"));
			addr.setStreetType(rs.getString("street_type"));
			addr.setStreetName(rs.getString("street_name"));
			addr.setUnitType(rs.getString("unit_type"));
			addr.setRoomNum(rs.getString("unit_no"));
			addr.setCityCode(rs.getString("city"));
			addr.setProvinceCode(rs.getString("province"));
			addr.setCountryCode(rs.getString("country"));
			addr.setPostalCode(rs.getString("postal_code"));
			
			x.setBilltoAddr(addr);
	        return x;
		}		
	}

}
