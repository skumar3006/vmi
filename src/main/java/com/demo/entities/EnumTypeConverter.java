package com.demo.entities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.EnumType;

public class EnumTypeConverter extends EnumType {

	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.OTHER);
		} else {
			if (value instanceof Role) {
				st.setObject(index, ((Role) value).getRole(), Types.OTHER);

			}
		}
	}

	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {

		if (!rs.getString(names[0]).isBlank()) {
			if (owner instanceof Role) {
				return Role.valueOf(rs.getString(names[0]).replace("-", ""));
			}
		}
		return super.nullSafeGet(rs, names, session, owner);

	}

}

