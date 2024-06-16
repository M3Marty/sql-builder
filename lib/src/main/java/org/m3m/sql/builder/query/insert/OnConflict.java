package org.m3m.sql.builder.query.insert;

import org.m3m.sql.builder.query.from.TableDataSource;
import org.m3m.sql.builder.query.returning.Returning;
import org.m3m.sql.builder.query.update.UpdateSetBuilder;
import org.m3m.sql.builder.query.update.UpdateSetOps;

public interface OnConflict {

	InsertQuery appendOnConflictExpression(String expression);

	default Returning doNothing() {
		return appendOnConflictExpression("DO NOTHING");
	}

	default UpdateSetOps<UpdateSetBuilder> doUpdate() {
		return new OnConflictUpdateQuery(appendOnConflictExpression(""))
				.from((TableDataSource) null);
	}
}