package org.seasar.doma.jdbc.query;

import static org.junit.jupiter.api.Assertions.assertEquals;

import example.entity.Emp;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.seasar.doma.internal.jdbc.mock.MockConfig;
import org.seasar.doma.internal.jdbc.util.SqlFileUtil;
import org.seasar.doma.jdbc.InParameter;
import org.seasar.doma.jdbc.PreparedSql;
import org.seasar.doma.jdbc.SqlLogType;

public class SqlFileBatchDeleteQueryTest {

  private final MockConfig runtimeConfig = new MockConfig();

  private Method method;

  @BeforeEach
  protected void setUp(TestInfo testInfo) throws Exception {
    method = testInfo.getTestMethod().get();
  }

  @Test
  public void testPrepare() throws Exception {
    Emp emp1 = new Emp();
    emp1.setId(10);
    emp1.setName("aaa");
    emp1.setVersion(100);

    Emp emp2 = new Emp();
    emp2.setId(20);
    emp2.setName("bbb");
    emp2.setVersion(200);

    SqlFileBatchDeleteQuery<Emp> query = new SqlFileBatchDeleteQuery<Emp>(Emp.class);
    query.setMethod(method);
    query.setConfig(runtimeConfig);
    query.setSqlFilePath(SqlFileUtil.buildPath(getClass().getName(), method.getName()));
    query.setParameterName("e");
    query.setElements(Arrays.asList(emp1, emp2));
    query.setCallerClassName("aaa");
    query.setCallerMethodName("bbb");
    query.setSqlLogType(SqlLogType.FORMATTED);
    query.prepare();

    BatchDeleteQuery batchDeleteQuery = query;
    assertEquals(2, batchDeleteQuery.getSqls().size());
  }

  @Test
  public void testOption_default() throws Exception {
    Emp emp1 = new Emp();
    emp1.setName("aaa");

    Emp emp2 = new Emp();
    emp2.setName("bbb");

    SqlFileBatchDeleteQuery<Emp> query = new SqlFileBatchDeleteQuery<Emp>(Emp.class);
    query.setMethod(method);
    query.setConfig(runtimeConfig);
    query.setSqlFilePath(SqlFileUtil.buildPath(getClass().getName(), method.getName()));
    query.setParameterName("e");
    query.setElements(Arrays.asList(emp1, emp2));
    query.setCallerClassName("aaa");
    query.setCallerMethodName("bbb");
    query.setSqlLogType(SqlLogType.FORMATTED);
    query.prepare();

    PreparedSql sql = query.getSqls().get(0);
    assertEquals("delete from emp where name = ?", sql.getRawSql());
    List<InParameter<?>> parameters = sql.getParameters();
    assertEquals(1, parameters.size());
    assertEquals("aaa", parameters.get(0).getWrapper().get());

    sql = query.getSqls().get(1);
    assertEquals("delete from emp where name = ?", sql.getRawSql());
    parameters = sql.getParameters();
    assertEquals(1, parameters.size());
    assertEquals("bbb", parameters.get(0).getWrapper().get());
  }
}
