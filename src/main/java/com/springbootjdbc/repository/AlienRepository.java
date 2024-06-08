package com.springbootjdbc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbootjdbc.model.Alien;

@Repository
public class AlienRepository {

	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Alien alien)
	{
		//System.out.println("added");
		String sql = "insert into alien (id, name, tech) values (?,?,?)";
		
		template.update(sql,alien.getId(),alien.getName(),alien.getTech());
	}
	
	public List<Alien> findAll()
	{
		String sql = "select * from alien";
		List<Alien> aliens = new ArrayList<>();
		List<Map<String, Object>> rows = template.queryForList(sql);
		for(Map<String, Object> row: rows)
		{
			Alien a = new Alien();
			a.setId((int) row.get("id"));
			a.setName(row.get("name").toString());
			a.setTech(row.get("tech").toString());
			aliens.add(a);
		}

        return aliens;
	}
}
