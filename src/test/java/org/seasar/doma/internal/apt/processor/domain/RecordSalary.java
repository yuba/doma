package org.seasar.doma.internal.apt.processor.domain;

import org.seasar.doma.Domain;

import java.math.BigDecimal;

@Domain(valueType = BigDecimal.class, accessorMethod = "value")
public record RecordSalary(BigDecimal value) {
}
