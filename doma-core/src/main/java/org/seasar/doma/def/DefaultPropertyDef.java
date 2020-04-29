package org.seasar.doma.def;

import org.seasar.doma.jdbc.entity.EntityPropertyType;
import org.seasar.doma.jdbc.entity.EntityType;

public class DefaultPropertyDef<PROPERTY> implements PropertyDef<PROPERTY> {

  private final Class<PROPERTY> clazz;
  private final EntityType<?> entityType;
  private final String name;

  public DefaultPropertyDef(Class<PROPERTY> clazz, EntityType<?> entityType, String name) {
    this.clazz = clazz;
    this.entityType = entityType;
    this.name = name;
  }

  @Override
  public Class<PROPERTY> asClass() {
    return clazz;
  }

  @Override
  public EntityPropertyType<?, ?> asType() {
    return entityType.getEntityPropertyType(name);
  }

  @Override
  public String getName() {
    return name;
  }
}