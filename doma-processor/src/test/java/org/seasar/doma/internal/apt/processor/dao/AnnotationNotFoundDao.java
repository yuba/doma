package org.seasar.doma.internal.apt.processor.dao;

import org.seasar.doma.Dao;

@Dao(config = MyConfig.class)
public interface AnnotationNotFoundDao {

  void aaa();
}
